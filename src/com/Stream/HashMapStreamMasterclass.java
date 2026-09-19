package com.Stream;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class HashMapStreamMasterclass {

    public static void main(String[] args) {
        // Initialize our source HashMap tracking department headcount
        Map<String, Integer> departmentHeadcount = new HashMap<>();
        departmentHeadcount.put("Engineering", 150);
        departmentHeadcount.put("Marketing", 45);
        departmentHeadcount.put("Sales", 120);
        departmentHeadcount.put("HR", 15);
        departmentHeadcount.put("Legal", 8);

        System.out.println("=== 1. FILTERING & COLLECTING INTO A NEW MAP ===");
        // Retain only large departments (headcount >= 50) and collect back into a new Map
        Map<String, Integer> largeDepartments = departmentHeadcount.entrySet().stream()
                .filter(entry -> entry.getValue() >= 50)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

        System.out.println("Large Departments: " + largeDepartments);
        // OUTPUT: Large Departments: {Engineering=150, Sales=120}


        System.out.println("\n=== 2. EXTRACTING KEYS OR VALUES ONLY ===");
        // Example A: Filter keys by string properties and collect to a List
        List<String> shortNamedDepts = departmentHeadcount.keySet().stream()
                .filter(deptName -> deptName.length() <= 5)
                .collect(Collectors.toList());
        System.out.println("Departments with names <= 5 letters: " + shortNamedDepts);
        // OUTPUT: Departments with names <= 5 letters: [Sales, HR, Legal]

        // Example B: Extract values directly into a primitive stream for analytical math
        int totalEmployees = departmentHeadcount.values().stream()
                .mapToInt(Integer::intValue)
                .sum();
        System.out.println("Total company headcount: " + totalEmployees);
        // OUTPUT: Total company headcount: 338


        System.out.println("\n=== 3. DATA TRANSFORMATION (MAPPING KEYS/VALUES) ===");
        // Create a new map where department names are uppercase and headcount is doubled
        Map<String, Integer> expandedBudgets = departmentHeadcount.entrySet().stream()
                .collect(Collectors.toMap(
                        entry -> entry.getKey().toUpperCase(),
                        entry -> entry.getValue() * 2
                ));
        System.out.println("Transformed Map: " + expandedBudgets);
        // OUTPUT: Transformed Map: {HR=30, SALES=240, ENGINEERING=300, MARKETING=90, LEGAL=16}


        System.out.println("\n=== 4. SORTING MAP ENTRIES ===");
        // Sort the entries by value (headcount) in descending order and save to a List of Entries
        List<Map.Entry<String, Integer>> sortedBySizeDesc = departmentHeadcount.entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .collect(Collectors.toList());

        System.out.println("Ranked Departments (High to Low):");
        // OUTPUT: Ranked Departments (High to Low):
        sortedBySizeDesc.forEach(entry -> System.out.println("  " + entry.getKey() + ": " + entry.getValue()));
        // OUTPUT:   Engineering: 150
        // OUTPUT:   Sales: 120
        // OUTPUT:   Marketing: 45
        // OUTPUT:   HR: 15
        // OUTPUT:   Legal: 8


        System.out.println("\n=== 5. COMPLEX GROUPING BY MAP DATA ===");
        // Group department names into "Large" or "Small" based on headcount
        Map<String, List<String>> deptsByScale = departmentHeadcount.entrySet().stream()
                .collect(Collectors.groupingBy(
                        entry -> entry.getValue() >= 50 ? "Large Depts" : "Small Depts",
                        Collectors.mapping(Map.Entry::getKey, Collectors.toList())
                ));
        System.out.println("Departments Grouped by Scale: " + deptsByScale);
        // OUTPUT: Departments Grouped by Scale: {Small Depts=[Marketing, HR, Legal], Large Depts=[Engineering, Sales]}


        System.out.println("\n=== 6. CONVERTING HASHMAP ENTRIES TO ARRAYS ===");
        // Extract map keys into a single-dimensional String array block
        String[] departmentNamesArray = departmentHeadcount.keySet().stream()
                .toArray(String[]::new);
        System.out.println("Keys Array: " + java.util.Arrays.toString(departmentNamesArray));
        // OUTPUT: Keys Array: [Engineering, Marketing, Sales, HR, Legal]
    }
}

