package org.skypro.skyshop.product;

import org.skypro.skyshop.searchengine.Searchable;

public abstract class Product implements Searchable {
    private final String name;

    public Product(String name) {
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

}
