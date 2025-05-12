package com.yourdreamcar.ui;

import com.yourdreamcar.data.DealershipFileManager;
import com.yourdreamcar.model.Dealership;
import com.yourdreamcar.model.Vehicle;

import java.util.List;
import java.util.Scanner;

public class UserInterface {

    public static Scanner read = new Scanner(System.in);

    private Dealership dealership;

    public UserInterface() {
        DealershipFileManager dfm = new DealershipFileManager();
        this.dealership = dfm.getDealership();
    }


    public void display(){
        boolean running = true;

        while (running) {
            try {
                System.out.println("☁️☁️☁️ === 🚗 Car Dealership Menu 🚗 === ☁️☁️☁️");
                System.out.println("1️⃣  Search by Price 💰");
                System.out.println("2️⃣  Search by Make & Model 🏷️🚙");
                System.out.println("3️⃣  Search by Year 📅");
                System.out.println("4️⃣  Search by Color 🎨");
                System.out.println("5️⃣  Search by Mileage ⏱️");
                System.out.println("6️⃣  Search by Vehicle Type 🚐");
                System.out.println("7️⃣  View All Vehicles 🚘");
                System.out.println("8️⃣  Add a Vehicle ➕🚗");
                System.out.println("9️⃣  Remove a Vehicle ➖🚗");
                System.out.println("0️⃣  Exit ❌");

                int choice = read.nextInt();

                switch (choice) {
                    case 1 -> processGetByPriceRequest();
                    case 2 -> processGetByMakeModelRequest();
                    case 3 -> processGetByYearRequest();
                    case 4 -> processGetByColorRequest();
                    case 5 -> processGetByMileageRequest();
                    case 6 -> processGetByVehicleTypeRequest();
                    case 7 -> processGetAllVehiclesRequest();
                    case 8 -> processGetAddVehicleRequest();
                    case 9 -> processGetRemoveVehicleRequest();
                    case 0 -> running = false;
                    default -> System.out.println("Invalid Option.");
                }
            } catch (NumberFormatException e) {
                System.out.println("❌ Invalid choice. Please try again.");
            }
        }
    }


    private void processGetByPriceRequest() {

        while (true) {
            try {
                System.out.println("Enter minimum price: ");
                double min = read.nextDouble();
                System.out.println("Enter maximum price: ");
                double max = read.nextDouble();

                if (min > max) {
                    System.out.println("❌ Minimum price cannot be more than maximum price. Please try again.");
                    continue;
                }

                List<Vehicle> results = dealership.getVehiclesByPrice(min, max);

                if (results.isEmpty()) {
                    System.out.println("❌ No matches found. Please try again.");
                } else {
                    for (Vehicle v : results) {
                        System.out.println(v);
                    }
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("❌ Invalid input. Please enter numeric values.");
            } catch (Exception e) {
                System.out.println("❌ Invalid input. Please try again.");
            }
        }
    }


    private void processGetByMakeModelRequest() {

        while (true) {
            try {
                System.out.println("Enter Make: ");
                String make = read.nextLine();
                System.out.println("Enter Model: ");
                String model = read.nextLine();
                List<Vehicle> results = dealership.getVehiclesByMakeModel(make, model);

                if (results.isEmpty()) {
                    System.out.println("❌ No matches found. Please try again.");
                } else {
                    for (Vehicle v : results) {
                        System.out.println(v);
                    }
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("❌ Invalid input. Please enter numeric values.");
            } catch (Exception e) {
                System.out.println("❌ Invalid input. Please try again.");
            }

        }
    }

        private void processGetByYearRequest() {

            while (true) {
                try {
                    System.out.println("Enter minimum Year: ");
                    int min = read.nextInt();
                    System.out.println("Enter maximum Year: ");
                    int max = read.nextInt();

                    if (min > max) {
                        System.out.println("❌ Minimum year cannot be more than maximum price. Please try again.");
                        continue;
                    }

                    List<Vehicle> results = dealership.getVehiclesByYear(min, max);

                    if (results.isEmpty()) {
                        System.out.println("❌ No matches found. Please try again.");
                    } else {
                        for (Vehicle v : results) {
                            System.out.println(v);
                        }
                        break;
                    }
                } catch (NumberFormatException e) {
                    System.out.println("❌ Invalid input. Please enter numeric values.");
                } catch (Exception e) {
                    System.out.println("❌ Invalid input. Please try again.");
                }
            }
        }

    private void processGetByColorRequest() {

        while (true) {
            try {
                System.out.println("Enter Color: ");
                String color = read.nextLine();
                List<Vehicle> results = dealership.getVehiclesByColor(color);

                if (results.isEmpty()) {
                    System.out.println("❌ No matches found. Please try again.");
                } else {
                    for (Vehicle v : results) {
                        System.out.println(v);
                    }
                    break;
                }
            } catch (Exception e) {
                System.out.println("❌ Invalid input. Please try again.");
            }

        }
    }


    private void processGetByMileageRequest() {

        while (true) {
            try {
                System.out.println("Enter minimum Mileage: ");
                int min = read.nextInt();
                System.out.println("Enter maximum Mileage: ");
                int max = read.nextInt();

                if (min > max) {
                    System.out.println("❌ Minimum mileage cannot be more than maximum mileage. Please try again.");
                }
                List<Vehicle> results = dealership.getVehiclesByMileage(min, max);

                if (results.isEmpty()) {
                    System.out.println("❌ No matches found. Please try again.");
                } else {
                    for (Vehicle v : results) {
                        System.out.println(v);
                    }
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("❌ Invalid input. Please enter numeric values.");
            } catch (Exception e) {
                System.out.println("❌ Invalid input. Please try again.");
            }

        }
    }


    private void processGetByVehicleTypeRequest() {

        while (true) {
            try {
                System.out.println("Enter Vehicle Type: ");
                String type = read.nextLine();
                List<Vehicle> results = dealership.getVehiclesByType(type);

                if (results.isEmpty()) {
                    System.out.println("❌ No matches found. Please try again.");
                } else {
                    for (Vehicle v : results) {
                        System.out.println(v);
                    }
                    break;
                }
            } catch (Exception e) {
                System.out.println("❌ Invalid input. Please try again.");
            }
        }
    }


    private void processGetAllVehiclesRequest() {
        List<Vehicle> vehicles = dealership.getAllVehicles();

        if (vehicles == null || vehicles.isEmpty()) {
            System.out.println("Nothing in inventory at the moment.");
        } else {
            System.out.println("List of All Vehicles");
            for (Vehicle v: dealership.getAllVehicles()) {
                System.out.println(v);
            }

        }

    }


    private void processGetAddVehicleRequest() {
        try {
            System.out.println("📥 Enter Vehicle Information:");

            System.out.print("VIN #: ");
            int vin = read.nextInt();
            read.nextLine();

            System.out.println("Year: ");
            int year = read.nextInt();
            read.nextLine();

            System.out.println("Make: ");
            String make = read.nextLine();
            System.out.println("Model: ");
            System.out.println("Vehicle Type: ");
            System.out.println("Color: ");
            System.out.println("Odometer: ");
            System.out.println("Price: ");

            Vehicle newVehicle = new Vehicle(vin,year,make,)

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private void processGetRemoveVehicleRequest() {
    }


}
