/*
 * The Krechet Software
 */

package ru.raiffeisen.warehouse_inventory;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author theValidator <the.validator@yandex.ru>
 */
@Entity
public class Socks implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "cotton_percent")
    private int cottonPercent;
    @Enumerated(EnumType.STRING)
    private Color color;
    private int quantity;

    public Socks() {
    }

    public Socks(int cottonPercent, Color color) {
        this.cottonPercent = cottonPercent;
        this.color = color;
    }

    public Socks(int cottonPercent, Color color, int quantity) {
        this.cottonPercent = cottonPercent;
        this.color = color;
        this.quantity = quantity;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getCottonPercent() {
        return cottonPercent;
    }

    public void setCottonPercent(int cottonPercent) {
        if (cottonPercent < 0 || cottonPercent > 100) {
            throw new IllegalArgumentException("Wrong cotton percent value!");
        } 
        this.cottonPercent = cottonPercent;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
}
