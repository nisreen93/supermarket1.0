package com.supermarket;

import java.io.FileNotFoundException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.supermarket.service.SupermarketService;

@SpringBootApplication
public class SuperMarketApplication {


    public static void main(String[] args) throws FileNotFoundException {
        SpringApplication.run(SuperMarketApplication.class, args);
        SupermarketService supermarketService = new SupermarketService();
        CommandProcessor commandProcessor = new CommandProcessor(supermarketService);

        if (args.length == 0) {
            System.out.println("Usage: java -jar target/SuperMarket-1.0.jar inventory.csv commands.txt");
            return;
        }

        String inventoryFile = args[0];
        supermarketService.loadInventory(inventoryFile);

        if (args.length == 2) {
            String commandsFile = args[1];
            commandProcessor.processFromFile(commandsFile);
        } else {
            commandProcessor.processInteractively();
        }
    }
}