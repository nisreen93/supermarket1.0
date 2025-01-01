/*package com.supermarket.controller;

import org.springframework.web.bind.annotation.*;
import com.supermarket.service.CartService;

@RestController
@RequestMapping("/cart")
public class ShoppingCartController {
    private final CartService cartService;

    public ShoppingCartController(CartService cartService) {
        this.cartService = cartService;
    }

    @PostMapping("/add")
    public String addItem(@RequestParam String item, @RequestParam int quantity) {
        cartService.addItem(item, quantity);
        return "added " + item + " " + quantity;
    }

    @PostMapping("/offer")
    public String applyOffer(@RequestParam String productName, @RequestParam String offer) {
        cartService.applyOffer(productName, offer);
        return "offer has been added";
    }

    @GetMapping("/bill")
    public String getBill() {
        return cartService.generateBill();
    }

    @PostMapping("/checkout")
    public String checkout() {
        cartService.checkout();
        return "done";
    }
}
*/