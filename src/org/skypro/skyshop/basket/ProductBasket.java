package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ProductBasket {
    List<Product> products = new ArrayList<>();

    public void addProduct(Product product) {
        products.add(product);
    }

    public void printAllProductBasket() {
        int num = 0;
        int quantity = 0;
        for (int i = 0; i < this.products.size(); i++) {
            if (this.products.get(i) != null) {
                System.out.println(products.get(i).toString());
                if (this.products.get(i).isSpecial()) {
                    quantity++;
                }
            } else {
                num++;
            }
        }
        if (num != this.products.size()) {
            System.out.println("Итого: " + basketCost());
            System.out.println("Специальных товаров: " + quantity);
        } else {
            System.out.println("в корзине пусто");
        }
    }
    public float basketCost() {
        float summ = 0f;
        for (int i = 0; i < this.products.size(); i++) {
            if (this.products.get(i) != null) {
                summ += this.products.get(i).getCost();
            }
        }
        return summ;
    }
    public boolean findProduct (String name) {
        for (int i = 0; i < this.products.size(); i++) {
            if (this.products.get(i) != null && this.products.get(i).getName().equals(name)) {
                return true;
            }
        }
        return false;
    }

    public ArrayList delProduct(String name) {
        List<Product> list = new ArrayList<>();
        Iterator<Product> iterator = products.iterator();

        while (iterator.hasNext()) {
            Product element = iterator.next();
            if (element != null &&  element.getName().equals(name)) {
                list.add(element);
                iterator.remove();
            }
        }
        return (ArrayList) list;
    }

    public void basketCleaning() {
        Iterator<Product> iteratorForBasketCleaning = products.iterator();
        while (iteratorForBasketCleaning.hasNext()) {
            if (iteratorForBasketCleaning.next() != null) {
                iteratorForBasketCleaning.remove();
            }
        }
    }
}



