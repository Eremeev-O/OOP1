package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;

public class App {
    public static void main(String[] args) {
        ProductBasket productBasket = new ProductBasket();

        System.out.println("Заполняем перечень возможных продуктов:");
        org.skypro.skyshop.basket.Basket.basket();

        System.out.println("Добавляем продукты в корзину:");
        productBasket.addProduct("орехи");
        productBasket.addProduct("твороженое");
        productBasket.addProduct("пироженое");
        System.out.println("Попробуем добавить продукт, которого нет в списке - Курица");
        productBasket.addProduct("курица");

        System.out.println();
        System.out.println("Выводим перечень продуктов в корзине");
        productBasket.printAllProductBasket();

        System.out.println();
        System.out.println("Отдельный вывод стоимости корзины");
        System.out.println(productBasket.basketCost());

        System.out.println();
        System.out.println("Добавляем еще два продукта и один сверх лимита продуктов в корзине:");
        productBasket.addProduct("семечки");
        productBasket.addProduct("орехи");
        productBasket.addProduct("Лимонад");

        System.out.println();
        System.out.println("Выводим перечень продуктов в корзине");
        productBasket.printAllProductBasket();


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
