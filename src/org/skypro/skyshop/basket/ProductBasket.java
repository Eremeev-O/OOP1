package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

public class ProductBasket {
    private final Product[] products;

    public ProductBasket() {
        this.products = new Product[5];
    }

    public void addProduct(Product product) {
        for (int i = 0; i < this.products.length; i++) {
            if (this.products[i] == null) {
                this.products[i] = product;
                    return;
            }
        }
        System.out.println("Невозможно добавить продукт");
    }

    //  Логика распечатывания содержимого корзины работает от обратного. Если есть запись в массиве, то переменная num
    //  не меняется и, главное! она будет всегда меньше длинны массива. Если только все данные массива упадут в null,
    //  вот тогда num станет равна длинне массива, что и подтверждает работу данного метода на пустой, на полной и на не
    //  заполненной корзине. Алгоритм универсальный, работает даже в случае отсутствия промежуточных значений массива
    //  с продуктами в корзине.
    public void printAllProductBasket() {
        int num = 0;
        int quantity = 0;
        for (int i = 0; i < this.products.length; i++) {
            if (this.products[i] != null) {
                System.out.println(this.products[i].toString());
                if (this.products[i].isSpecial()) {
                    quantity++;
                }
            } else {
                num++;
            }
        }
        if (num != this.products.length) {
            System.out.println("Итого: " + basketCost());
            System.out.println("Специальных товаров: " + quantity);
        } else {
            System.out.println("в корзине пусто");
        }
    }
    public float basketCost() {
        float summ = 0f;
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
