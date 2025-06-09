package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

public class ProductBasket {
    final Product[] products;
    static final Product[] productList = new Product[7];

    public ProductBasket() {
        this.products = new Product[5];
    }

    public void addProduct(String name) {
        for (int i = 0; i < this.products.length; i++) {
            if (this.products[i] == null && findProductList(name) && findProductListID(name)>0) {
                this.products[i] = productList[findProductListID(name)];
                return;
            }
        }
        System.out.println("Невозможно добавить продукт");
    }

    public static void addProductList(String name, int cost) {
        for (int i = 0; i < productList.length; i++) {
            if (productList[i] == null && cost > 0) {
                Product newProduct = new Product(name, cost);
                productList[i] = newProduct;
                return;
            }
        }
        System.out.println("Невозможно добавить продукт в список продуктов");
    }

    //  Логика распечатывания содержимого корзины работает от обратного. Если есть запись в массиве, то переменная num
    //  не меняется и, главное! она будет всегда меньше длинны массива. Если только все данные массива упадут в null,
    //  вот тогда num станет равна длинне массива, что и подтверждает работу данного метода на пустой, на полной и на не
    //  заполненной корзине. Алгоритм универсальный, работает даже в случае отсутствия промежуточных значений массива
    //  с продуктами в корзине.
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

    public boolean findProductList (String name) {
        for (int i = 0; i < productList.length; i++) {
            if (productList[i] != null && productList[i].getName().equals(name.toLowerCase())) {
                return true;
            }
        }
        return false;
    }
    public int findProductListID(String name) {
        for (int i = 0; i < productList.length; i++) {
            if (productList[i] != null && productList[i].getName().equals(name.toLowerCase())) {
                return i;
            }
        }
        return -1;
    }

    public void basketCleaning() {
        for (int i = 0; i < this.products.length; i++) {
            this.products[i] = null;
        }
    }

}
