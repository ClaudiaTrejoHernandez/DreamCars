package com.yourdreamcar;

import java.io.File;

public class Main {
    public static void main(String[] args) {
        File file = new File("src/main/resources/inventory.csv");

        if (file.exists()) {
            System.out.println("CSV file found: " + file.getAbsolutePath());
        }else {
            System.out.println("CSV file not found!");
        }
    }
}