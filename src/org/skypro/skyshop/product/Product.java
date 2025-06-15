package org.skypro.skyshop.product;

public abstract class Product {
    private final String name;

    public Product(String name) {
        this.name = name.toLowerCase();
    }

    public abstract boolean isSpecial();

    public String getName() {
        return name;
    }

    public abstract float getCost();

@Override
    public abstract String toString();
}
