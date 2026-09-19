package com.Stream;

import java.util.*;
import java.util.stream.Collectors;

public class ArrayListStreamMasterclass {

    // A simple custom object to use in our stream pipeline examples
    static class Product {
        String name;
        String category;
        double price;

        Product(String name, String category, double price) {
            this.name = name;
            this.category = category;
            this.price = price;
        }

        public String getName() {
            return name;
        }

        public String getCategory() {
            return category;
        }

        public double getPrice() {
            return price;
        }

        @Override
        public String toString() {
            return String.format("%s (%s, $%.2f)", name, category, price);
        }
    }

    public static void main(String[] args) {
        // Initialize our source ArrayList
        List<Product> catalog = new ArrayList<>();
        catalog.add(new Product("Laptop", "Electronics", 1200.00));
        catalog.add(new Product("Smartphone", "Electronics", 800.00));
        catalog.add(new Product("Coffee Maker", "Home", 90.00));
        catalog.add(new Product("Desk Chair", "Furniture", 250.00));
        catalog.add(new Product("Blender", "Home", 120.00));

        System.out.println("=== 1. FILTERING & TRUNCATING ===");

        // Retain only expensive electronics, limiting the total results to 1 item
        List<Product> premiumElectronics = catalog.stream()
                .filter(p -> p.getCategory().equals("Electronics"))
                .filter(p -> p.getPrice() > 500.00)
                .limit(1)
                .collect(Collectors.toList());
        System.out.println("Premium Electronics (Limited to 1): " + premiumElectronics);
        // OUTPUT: Premium Electronics (Limited to 1): [Laptop (Electronics, $1200.00)]

        System.out.println("\n=== 2. TRANSFORMATION (MAPPING) ===");


        // Extract just the product names into a new String list
        List<String> productNames = catalog.stream()
                .map(Product::getName)
                .collect(Collectors.toList());
        System.out.println("Product Names: " + productNames);
        // OUTPUT: Product Names: [Laptop, Smartphone, Coffee Maker, Desk Chair, Blender]

        System.out.println("\n=== 3. SORTING ===");


        // Sort items by price in descending order
        List<Product> sortedByPriceDesc = catalog.stream()
                .sorted(Comparator.comparingDouble(Product::getPrice).reversed())
                .collect(Collectors.toList());
        System.out.println("Sorted by Price (High to Low):");
        // OUTPUT: Sorted by Price (High to Low):

        sortedByPriceDesc.forEach(p -> System.out.println("  " + p));
        // OUTPUT:   Laptop (Electronics, $1200.00)
        // OUTPUT:   Smartphone (Electronics, $800.00)
        // OUTPUT:   Desk Chair (Furniture, $250.00)
        // OUTPUT:   Blender (Home, $120.00)
        // OUTPUT:   Coffee Maker (Home, $90.00)

        System.out.println("\n=== 4. BOOLEAN MATCHING ===");

        // Check conditions across the entire array list
        boolean hasSuperExpensiveItem = catalog.stream().anyMatch(p -> p.getPrice() > 2000.00);
        boolean allItemsHavePrice = catalog.stream().allMatch(p -> p.getPrice() > 0);
        boolean noFreeItems = catalog.stream().noneMatch(p -> p.getPrice() == 0.0);

        System.out.println("Any item over $2000? " + hasSuperExpensiveItem);
        // OUTPUT: Any item over $2000? false

        System.out.println("All items have positive price? " + allItemsHavePrice);
        // OUTPUT: All items have positive price? true

        System.out.println("No items are free? " + noFreeItems);
        // OUTPUT: No items are free? true

        System.out.println("\n=== 5. SEARCHING & EXTRACTION ===");


        // Find the first product that belongs to the "Home" category
        Optional<Product> firstHomeItem = catalog.stream()
                .filter(p -> p.getCategory().equals("Home"))
                .findFirst();
        firstHomeItem.ifPresent(product -> System.out.println("First Home item found: " + product));
        // OUTPUT: First Home item found: Coffee Maker (Home, $90.00)

        System.out.println("\n=== 6. SCALAR REDUCTION (AGGREGATION) ===");


        // Add up the cost of all products using an object-based reduction
        double overallTotalCost = catalog.stream()
                .map(Product::getPrice)
                .reduce(0.0, Double::sum);
        System.out.println("Total value of inventory: $" + overallTotalCost);
        // OUTPUT: Total value of inventory: $2460.0

        System.out.println("\n=== 7. ADVANCED GROUPING (COLLECTORS) ===");


        // Categorize products by their department into a Map<String, List<Product>>
        Map<String, List<Product>> itemsByCategory = catalog.stream()
                .collect(Collectors.groupingBy(Product::getCategory));

        System.out.println("Items Grouped By Category:");
        // OUTPUT: Items Grouped By Category:

        itemsByCategory.forEach((category, list) -> {
            System.out.println("  Category: " + category + " -> " + list);
        });
        // OUTPUT:   Category: Furniture -> [Desk Chair (Furniture, $250.00)]
        // OUTPUT:   Category: Home -> [Coffee Maker (Home, $90.00), Blender (Home, $120.00)]
        // OUTPUT:   Category: Electronics -> [Laptop (Electronics, $1200.00), Smartphone (Electronics, $800.00)]
    }
}
