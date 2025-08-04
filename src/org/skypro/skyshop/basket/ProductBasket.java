package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.*;

public class ProductBasket {
    private Map<String, List<Product>> products = new HashMap<>();

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
         if (!this.products.isEmpty()) {
            products.values().stream().flatMap(Collection::stream).forEach(System.out::println);
            System.out.println("Специальных товаров: " + getSpecialCount());
            System.out.println("Итого: " + basketCost());
        } else {
            System.out.println("в корзине пусто");
        }
    }


    public double basketCost() {
        return products.values().stream().flatMap(Collection::stream).mapToDouble(s -> s.getCost()).sum();
    }

    public boolean findProduct (String name) {
        return products.containsKey(name);
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
    private int getSpecialCount() {
        return (int) products.values().stream().flatMap(Collection::stream).filter(s -> s.isSpecial()).count();
    }
}



