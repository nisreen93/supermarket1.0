package com.supermarket;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import com.supermarket.service.SupermarketService;

public class CommandProcessor {
    private final SupermarketService supermarketService;

    public CommandProcessor(SupermarketService supermarketService) {
        this.supermarketService = supermarketService;
    }

    public void processInteractively() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Interactive mode started. Type commands and checkout to finish...");

        while (true) {
            System.out.print("> ");
            String command = scanner.nextLine();
            if (command.equalsIgnoreCase("checkout")) {
                System.out.println(supermarketService.checkout());
                break;
            }
            System.out.println(processCommand(command));
        }
    }

    public void processFromFile(String filePath) throws FileNotFoundException {
        File file = new File(filePath);
        Scanner scanner = new Scanner(file);

        while (scanner.hasNextLine()) {
            String command = scanner.nextLine();
            System.out.println(processCommand(command));
        }

        System.out.println(supermarketService.checkout());
    }

    private String processCommand(String command) {
        try {
            String[] tokens = command.split(" ");
            switch (tokens[0].toLowerCase()) {
                case "add":
                    return supermarketService.addItemToCart(tokens[1], Integer.parseInt(tokens[2]));
                case "offer":
                    return supermarketService.applyOffer(tokens[1], tokens[2]);
                case "bill":
                    return supermarketService.getFormattedBill();
                case "checkout":
                    return "empty cart";
                default:
                    return "Invalid command.";
            }
        } catch (Exception e) {
            return "Error processing command: " + e.getMessage();
        }
    }
}

