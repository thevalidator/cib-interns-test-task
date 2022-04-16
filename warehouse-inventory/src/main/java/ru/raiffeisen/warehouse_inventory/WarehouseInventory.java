/*
 * The Krechet Software
 */
package ru.raiffeisen.warehouse_inventory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/**
 *
 * @author theValidator <the.validator@yandex.ru>
 */
@SpringBootApplication
public class WarehouseInventory {

    public static void main(String[] args) {
        System.out.println("Warehouse inventory DEMO");
        SpringApplication.run(WarehouseInventory.class, args);
        //Socks s = new Socks(100, Color.BLUE);
    }

}
