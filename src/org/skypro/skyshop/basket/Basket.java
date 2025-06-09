package org.skypro.skyshop.basket;

public class Basket {

    public static void basket() {
        org.skypro.skyshop.basket.ProductBasket.addProductList("Мороженое", 100);
        org.skypro.skyshop.basket.ProductBasket.addProductList("Пироженое", 110);
        org.skypro.skyshop.basket.ProductBasket.addProductList("Твороженое", 120);
        org.skypro.skyshop.basket.ProductBasket.addProductList("Печенье", 30);
        org.skypro.skyshop.basket.ProductBasket.addProductList("Конфеты", 200);
        org.skypro.skyshop.basket.ProductBasket.addProductList("Семечки", 60);
        org.skypro.skyshop.basket.ProductBasket.addProductList("Орехи", 90);
        System.out.println("Попробуем добавить в список продуктов продукт сверх размера выделенного массива - Лимонад");
        org.skypro.skyshop.basket.ProductBasket.addProductList("Лимонад", 120);
    }
}


