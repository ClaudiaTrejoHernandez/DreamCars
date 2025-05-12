package com.yourdreamcar.data;

import com.yourdreamcar.model.Dealership;

public class DealershipFileManager {

    public Dealership getDealership() {
        //Read from inventory.csv

        return new Dealership("Honda Dublin", "123 Main St","555-1234");
    }


    public void saveDealership(Dealership dealership) {
        //Write to inventory.csv

    }

}
