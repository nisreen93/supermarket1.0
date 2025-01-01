package com.supermarket.service;

import org.springframework.stereotype.Service;

import com.supermarket.model.CartItem;
import com.supermarket.model.Item;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.io.BufferedReader;
import java.io.FileReader;

@Service
public class SupermarketService {
	private final Map<String, Item> inventory = new HashMap<>();
	private final List<CartItem> cart = new ArrayList<>();
	private final Map<String, String> activeOffers = new HashMap<>();

	public SupermarketService() {
	}

	public String addItemToCart(String name, int quantity) {
		Item item = inventory.get(name);
		if (item == null || item.getQuantity() < quantity) {
			return "Item not available or insufficient stock.";
		}
		item.setQuantity(item.getQuantity() - quantity);
		cart.add(new CartItem(item, quantity));
		return "Added " + name + " " + quantity ;
	}

	public Map<String, Object> getBill() {
	    double subtotal = 0.0;
	    double discount = 0.0;

	    for (CartItem cartItem : cart) {
	        String itemName = cartItem.getItem().getName();
	        double itemPrice = cartItem.getItem().getPrice();
	        int quantity = cartItem.getQuantity();

	        subtotal += itemPrice * quantity;

	        if (activeOffers.containsKey(itemName)) {
	            String offerType = activeOffers.get(itemName);

	            if ("buy_2_get_1_free".equals(offerType)) {
	                int freeItems = quantity / 3;
	                discount += freeItems * itemPrice;
	            } else if ("buy_1_get_half_off".equals(offerType)) {
	                int eligibleItems = quantity / 2;
	                discount += eligibleItems * (itemPrice / 2);
	            }
	        }
	    }

	    double total = subtotal - discount;
	    Map<String, Object> bill = new HashMap<>();
	    bill.put("subtotal", Math.round(subtotal * 100.0) / 100.0);
	    bill.put("discount", Math.round(discount * 100.0) / 100.0);
	    bill.put("total", Math.round(total * 100.0) / 100.0);
	    return bill;
	}

	public String checkout() {
		cart.clear();
		return "Checkout complete.";
	}

	public Map<String, Item> getInventory() {
		return inventory;
	}

	public String applyOffer(String offerType, String itemName) {
		if (!inventory.containsKey(itemName)) {
			return "Item not found in inventory.";
		}
		
		activeOffers.put(itemName, offerType);
		return "offer added";
	}

	public String getFormattedBill() {
		Map<String, Object> bill = getBill();
		return String.format("subtotal:%.2f, discount:%.2f, total:%.2f", bill.get("subtotal"), bill.get("discount"),
				bill.get("total"));
	}

	public void loadInventory(String filePath) {
		try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
			String line;
			while ((line = reader.readLine()) != null) {
				String[] parts = line.split(",");
				if (parts.length != 3) {
					System.out.println("Invalid inventory line: " + line);
					continue;
				}

				String productName = parts[0].trim();
				double price;
				int quantity;

				try {
					price = Double.parseDouble(parts[1].trim());
					quantity = Integer.parseInt(parts[2].trim());
				} catch (NumberFormatException e) {
					System.out.println("Invalid number format in line: " + line);
					continue;
				}

				inventory.put(productName, new Item(productName, price, quantity));
			}
			System.out.println("Inventory loaded successfully.");
		} catch (IOException e) {
			System.err.println("Error reading inventory file: " + e.getMessage());
		}
	}

}
