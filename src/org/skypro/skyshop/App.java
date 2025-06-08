package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;

public class App {
    public static void main(String[] args) {
        ProductBasket productBasket = new ProductBasket();

        System.out.println("Вводим продукты в корзину:");
        productBasket.addProduct("Мороженое", 100);
        productBasket.addProduct("Пироженое", 110);
        productBasket.addProduct("Твороженое", 120);
        productBasket.addProduct("Печенье", 30);
        productBasket.addProduct("Конфеты", 200);
        productBasket.addProduct("Семечки", 60);
        productBasket.addProduct("Орехи", 90);

        System.out.println();
        System.out.println("Выводим перечень продуктов в корзине");
        productBasket.printAllProductBasket();

        System.out.println();
        System.out.println("Отдельный вывод стоимости корзины");
        System.out.println(productBasket.basketCost());

        System.out.println();
        System.out.println("Ищем Печенье  - " + productBasket.findProduct("Печенье"));

        System.out.println();
        System.out.println("Очищаем корзину");
        productBasket.basketCleaning();

        System.out.println();
        System.out.println("Выводим перечень продуктов в корзине");
        productBasket.printAllProductBasket();

        System.out.println();
        System.out.println("Считаем стоимость товара в пустой корзине: " + productBasket.basketCost());

        System.out.println();
        System.out.println("Ищем товар в пустой корзине. Например: Спички = " + productBasket.findProduct("Спички"));


    }
}
