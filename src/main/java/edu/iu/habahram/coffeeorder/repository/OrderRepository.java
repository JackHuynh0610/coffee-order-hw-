package edu.iu.habahram.coffeeorder.repository;

import edu.iu.habahram.coffeeorder.model.*;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.io.IOException;
@Repository
public class OrderRepository {

    private int id = 0;
    public Receipt add(OrderData order) throws Exception {
        Beverage beverage = null;
        switch (order.beverage().toLowerCase()) {
            case "dark roast":
                beverage = new DarkRoast();
                break;
            case "decaf":
                beverage = new Decaf();
                break;
            case "espresso":
                beverage = new Espresso();
                break;
            case "house blend":
                beverage = new HouseBlend();
                break;
        }
        if (beverage == null) {
            throw new Exception("Beverage type '%s' is not valid!".formatted(order.beverage()));
        }
        for(String condiment : order.condiments()) {
            switch (condiment.toLowerCase()) {
                case "milk":
                   beverage = new Milk(beverage);
                   break;
                case "mocha":
                    beverage = new Mocha(beverage);
                    break;
                case "soy":
                    beverage = new Soy(beverage);
                    break;
                case "whip":
                    beverage = new Whip(beverage);
                    break;
                default:
                    throw new Exception("Condiment type '%s' is not valid".formatted(condiment));
            }
        }
        Receipt receipt = new Receipt(beverage.getDescription(), beverage.cost(), generateId());
        addToDB(receipt);
        return receipt;
    }

    private void addToDB(Receipt receipt) {
        String receiptInfo = receipt.toString();
        String filePath = "db.txt";
        // Write to file
        File file = new File(filePath);
        // if file doesn't exist, then create it
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else{
            // if file exists, then append to it
            try {
                // Open given file in append mode.
                java.io.FileWriter fileWriter = new java.io.FileWriter(file, true);
                fileWriter.write(receiptInfo);
                fileWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private int generateId() {
        return id++;
        
    }
}
