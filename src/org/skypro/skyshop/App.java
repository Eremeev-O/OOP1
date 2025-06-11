package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.Product;

public class App {
    public static void main(String[] args) {
        ProductBasket productBasket = new ProductBasket();
        Product[] productList = new Product[7];

        productBasket.addProductList("Мороженое", 100, productList);
        productBasket.addProductList("Пироженое", 110, productList);
        productBasket.addProductList("Твороженое", 120, productList);
        productBasket.addProductList("Печенье", 30, productList);
        productBasket.addProductList("Конфеты", 200, productList);
        productBasket.addProductList("Семечки", 60, productList);
        productBasket.addProductList("Орехи", 90, productList);

        System.out.println("Добавляем продукты в корзину:");
        productBasket.addProduct(productList[0]);
        productBasket.addProduct(productList[2]);
        productBasket.addProduct(productList[1]);

        System.out.println();
        System.out.println("Выводим перечень продуктов в корзине");
        productBasket.printAllProductBasket();

        System.out.println();
        System.out.println("Отдельный вывод стоимости корзины");
        System.out.println(productBasket.basketCost());

        System.out.println();
        System.out.println("Добавляем еще два продукта и один сверх лимита продуктов в корзине:");
        productBasket.addProduct(productList[5]);
        productBasket.addProduct(productList[6]);
        productBasket.addProduct(productList[3]);

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
