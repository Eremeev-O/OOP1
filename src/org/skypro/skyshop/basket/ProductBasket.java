package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.*;

public class ProductBasket {
    Map<String, List<Product>> products = new LinkedHashMap<>();

    public void addProduct(Product product) {
        List<Product> list = new ArrayList<>();
        if ((products.get(product.getName()) == null)) {
            list.add (product);
            products.put(product.getName(), list);
        } else {
            list = products.get(product.getName());
            list.add(product);
            products.put(product.getName(), list);
        }
    }

    public void printAllProductBasket() {
        int quantity = 0;
        for (Map.Entry<String, List<Product>> element: products.entrySet()){
            if (element.getValue() != null) {
                for (Product value: element.getValue()){
                    System.out.println(value.toString());
                    if (value.isSpecial()) {
                        quantity++;
                    }
                }
            }
        }
        if (!this.products.isEmpty()) {
            System.out.println("Итого: " + basketCost());
            System.out.println("Специальных товаров: " + quantity);
        } else {
            System.out.println("в корзине пусто");
        }
    }

    public float basketCost() {
        float summ = 0f;
        for (Map.Entry<String, List<Product>> element: products.entrySet()){
            if (element.getValue() != null) {
                for (Product value: element.getValue()){
                    summ += value.getCost();
                }
            }
        }
        return summ;
    }

    public boolean findProduct (String name) {
        if (products.containsKey(name)) {
            return true;
        } else {
            return false;
        }
    }

    public List<Product> delProduct(String name) {
        List<Product> list = new ArrayList<>();
        if (products.containsKey(name)) {
            List<Product> element = products.get(name);
            list.addAll(element);
            products.remove(name);
        }
        return list;
    }

    public void basketCleaning() {
        products.clear();
    }
}



