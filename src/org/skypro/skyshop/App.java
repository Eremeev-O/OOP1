package org.skypro.skyshop;

import org.skypro.skyshop.article.Article;
import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.*;
import org.skypro.skyshop.searchengine.SearchEngine;

public class App{
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

        System.out.println();
        System.out.println("Создаем объекты SearchEngine и Article:");
        SearchEngine searchEngine = new SearchEngine(12);
        searchEngine.add(new SimpleProduct("Мороженое", 100));
        searchEngine.add(new DiscountedProduct("Пироженое", 110, 15));
        searchEngine.add(new FixPriceProduct("Твороженое"));
        searchEngine.add(new SimpleProduct("Семечки", 60));
        searchEngine.add(new DiscountedProduct("Орехи", 90, 20));
        searchEngine.add(new SimpleProduct("Печенье", 30));

        searchEngine.add(new Article("Мясо как источник белка", "Чрезмерное употребление мяса вредит здоровью."));
        searchEngine.add(new Article("Ты все еще голодный?", "Если ты голодный - заставь себя поесть!"));
        searchEngine.add(new Article("Магазин автозапчастей", "Широкий выбор комплектующих для авто."));
        searchEngine.add(new Article("Ozon", "Закажи, оплати, дождись, забери, убедись что не подходит - выкинь!"));
        searchEngine.add(new Article("Полет птицы", "Статья про сложное строение перьев у пернатых."));
        searchEngine.add(new Article("Огородные вредители", "Купил перегной - беги за препаратами от вредителей! :)"));

        System.out.println();
        System.out.println("Демонстрация поиска и вывода результата:");

        searchEngine.printSearch(searchEngine.search("Магазин"));
        searchEngine.printSearch(searchEngine.search("голодный"));
        searchEngine.printSearch(searchEngine.search("выбор"));
        searchEngine.printSearch(searchEngine.search("перьев"));
        searchEngine.printSearch(searchEngine.search("Пироженое"));
        searchEngine.printSearch(searchEngine.search("забери"));
        searchEngine.printSearch(searchEngine.search("Орехи"));

    }
}
