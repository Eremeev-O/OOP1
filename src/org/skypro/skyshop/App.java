package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.Product;

public class App {
    public static void main(String[] args) {
        ProductBasket productBasket = new ProductBasket();

        System.out.println("Добавляем продукты в корзину:");
        productBasket.addProduct(new Product("Мороженое", 100));
        productBasket.addProduct(new Product("Пироженое", 110));
        productBasket.addProduct(new Product("Твороженое", 120));

        System.out.println();
        System.out.println("Выводим перечень продуктов в корзине");
        productBasket.printAllProductBasket();

        System.out.println();
        System.out.println("Отдельный вывод стоимости корзины");
        System.out.println(productBasket.basketCost());

        System.out.println();
        System.out.println("Добавляем еще два продукта и один сверх лимита продуктов в корзине:");
        productBasket.addProduct(new Product("Семечки", 60));
        productBasket.addProduct(new Product("Орехи", 90));
        productBasket.addProduct(new Product("Печенье", 30));

        System.out.println();
        System.out.println("Выводим перечень продуктов в корзине");
        productBasket.printAllProductBasket();


        System.out.println();
        System.out.println("Ищем Печенье  - " + productBasket.findProduct("Печенье"));
        System.out.println("Ищем Орехи  - " + productBasket.findProduct("Орехи"));

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
