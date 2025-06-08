package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

public class ProductBasket {
    private final Product[] products;

    public ProductBasket() {
        this.products = new Product[5];
    }

    public void addProduct(String name, int cost) {
        for (int i = 0; i < this.products.length; i++) {
            if (this.products[i] == null && cost > 0) {
                Product newProduct = new Product(name, cost);
                this.products[i] = newProduct;
                return;
            }
        }
        System.out.println("Невозможно добавить продукт");
    }
    public void printAllProductBasket() {
        int num = 0;
        for (int i = 0; i < this.products.length; i++) {
            if (this.products[i] != null) {
                System.out.println(this.products[i].toString());
            } else {
                num++;
            }
        }
        if (num != this.products.length) {
            System.out.println("Итого: " + basketCost());
        } else {
            System.out.println("в корзине пусто");
        }
    }
    public int basketCost() {
        int summ = 0;
        for (int i = 0; i < this.products.length; i++) {
            if (this.products[i] != null) {
                summ += this.products[i].getCost();
            }
        }
        return summ;
    }
    public boolean findProduct (String name) {
        for (int i = 0; i < this.products.length; i++) {
            if (this.products[i] != null && this.products[i].getName().equals(name.toLowerCase())) {
                return true;
            }
        }
        return false;
    }

    public void basketCleaning() {
        for (int i = 0; i < this.products.length; i++) {
            this.products[i] = null;
        }
    }

}
