package org.skypro.skyshop.product;

import org.skypro.skyshop.searchengine.Searchable;

import java.util.Objects;

public abstract class Product implements Searchable {
    private final String name;

    public Product(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Поле (name) заводимого продукта пустое");
        }
        this.name = name;
    }

    public abstract boolean isSpecial();

    public String getName() {
        return name;
    }

    public abstract float getCost();

    public String getSearchTerm(){
        return this.getName();
    }

    public String contentType(){
        return "PRODUCT";
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || getClass() != obj.getClass()) return false;
        Product product = (Product) obj;
        return Objects.equals(name, product.name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }
}
