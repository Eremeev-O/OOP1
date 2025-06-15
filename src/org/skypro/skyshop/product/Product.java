package org.skypro.skyshop.product;

public class Product {
    private final String name;
    private final int cost;

    public Product(String name, int cost) {
        this.name = name.toLowerCase();
        this.cost = cost;
    }

    public String getName() {
        return name;
    }

    public int getCost() {
        return cost;
    }

@Override
    public String toString() {
        return this.getName() + " : " + getCost();
    }
}
