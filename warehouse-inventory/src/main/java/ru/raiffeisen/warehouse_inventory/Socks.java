/*
 * The Krechet Software
 */

package ru.raiffeisen.warehouse_inventory;

/**
 * @author theValidator <the.validator@yandex.ru>
 */
public class Socks {
    
    private final int cottonPercent;
    private final Color color;

    public Socks(int cottonPercent, Color color) {
        this.cottonPercent = cottonPercent;
        this.color = color;
    }

    public int getCottonPercent() {
        return cottonPercent;
    }

    public Color getColor() {
        return color;
    }

}
