package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.SimpleProduct;

public class App {
    public static void main(String[] args) {
        ProductBasket productBasket = new ProductBasket();

        System.out.println("Добавляем продукты в корзину:");
        productBasket.addProduct(new SimpleProduct("Мороженое", 100));
        productBasket.addProduct(new DiscountedProduct("Пироженое", 110, 15));
        productBasket.addProduct(new FixPriceProduct("Твороженое"));

        System.out.println();
        System.out.println("Выводим перечень продуктов в корзине");
        productBasket.printAllProductBasket();

        System.out.println();
        System.out.println("Отдельный вывод стоимости корзины");
        System.out.println(productBasket.basketCost());

        System.out.println();
        System.out.println("Добавляем еще два продукта и один сверх лимита продуктов в корзине:");
        productBasket.addProduct(new SimpleProduct("Семечки", 60));
        productBasket.addProduct(new DiscountedProduct("Орехи", 90, 20));
        productBasket.addProduct(new SimpleProduct("Печенье", 30));

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
