package com.yourdreamcar.data;

import com.yourdreamcar.model.Dealership;
import com.yourdreamcar.model.Vehicle;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DealershipFileManager {

    public Dealership getDealership() {
        Dealership dealership = null;

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("YourDreamCar/src/main/resources/inventory.csv"))) {
            String dealershipInfoHeader = bufferedReader.readLine();
            if(dealershipInfoHeader !=null) {
                String[] dealershipInfo = dealershipInfoHeader.split("\\|");
                String name = dealershipInfo[0];
                String address = dealershipInfo[1];
                String phone = dealershipInfo[2];

                dealership = new Dealership(name, address, phone);

                List<String> vehicleLines = new ArrayList<>();
                String vehicleLine;
                while ((vehicleLine = bufferedReader.readLine()) != null) {
                    vehicleLines.add(vehicleLine);
                }
                dealership.loadInventory(vehicleLines);
            }

        } catch (IOException e) {
            System.out.println("❌ Error reading dealership file: " + e.getMessage());
        }
        return dealership;
    }

    public void saveDealership(Dealership dealership) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("YourDreamCar/src/main/resources/inventory.csv"))) {
            bufferedWriter.write(String.format("%s|%s|%s\n",
                    dealership.getName(),
                    dealership.getAddress(),
                    dealership.getPhone()));

            for (Vehicle v : dealership.getAllVehicles()) {
                bufferedWriter.write(String.format("%d|%d|%s|%s|%s|%s|%d|%.2f\n",
                        v.getVin(),
                        v.getYear(),
                        v.getMake(),
                        v.getModel(),
                        v.getVehicleType(),
                        v.getColor(),
                        v.getOdometer(),
                        v.getPrice()));

            }

        } catch (IOException e) {
            System.out.println("❌ Error saving dealership: " + e.getMessage());
        }

    }

}

