package org.skypro.skyshop;

import org.skypro.skyshop.article.Article;
import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.*;
import org.skypro.skyshop.searchengine.BestResultNotFound;
import org.skypro.skyshop.searchengine.SearchEngine;

public class App{
    public static void main(String[] args) throws IllegalArgumentException {
        ProductBasket productBasket = new ProductBasket();

        System.out.println("Добавляем продукты в корзину:");
        productBasket.addProduct(new SimpleProduct("Мороженое", 100));
        productBasket.addProduct(new DiscountedProduct("Пироженое", 110, 15));
        productBasket.addProduct(new FixPriceProduct("Твороженое"));
        productBasket.addProduct(new SimpleProduct("Орехи", 100));
        productBasket.addProduct(new SimpleProduct("Семечки", 60));
        productBasket.addProduct(new DiscountedProduct("Орехи", 90, 20));
        productBasket.addProduct(new SimpleProduct("Печенье", 30));

        System.out.println();
        System.out.println("Выводим перечень продуктов в корзине");
        productBasket.printAllProductBasket();

        System.out.println();
        System.out.println("Отдельный вывод стоимости корзины");
        System.out.println(productBasket.basketCost());

        System.out.println();
        System.out.println("Ищем Бублик  - " + productBasket.findProduct("Бублик"));
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
        System.out.println("Ищем товар в пустой корзине. Например: Орехи = " + productBasket.findProduct("Орехи"));

        System.out.println();
        System.out.println("Создаем объекты SearchEngine и Article:");
        SearchEngine searchEngine = new SearchEngine();
        searchEngine.add(new SimpleProduct("Мороженое", 100));
        searchEngine.add(new DiscountedProduct("Пироженое", 110, 15));
        searchEngine.add(new FixPriceProduct("Твороженое"));
        searchEngine.add(new SimpleProduct("Семечки", 60));
        searchEngine.add(new DiscountedProduct("Кешью - орехи", 90, 20));
        searchEngine.add(new SimpleProduct("Печенье", 30));
//        searchEngine.add(new SimpleProduct("Фундук - орехи", 100));
        searchEngine.add(new SimpleProduct("Арахис - орехи", 40));
        searchEngine.add(new SimpleProduct("Фундук - орехи", 100));
        searchEngine.add(new SimpleProduct("Миндаль - орехи", 100));

        searchEngine.add(new Article("Бумбоксбббббоксииибоммирррбокс", "Chrome1"));
        searchEngine.add(new Article("Бумбоксбббббоксииибомбумирррбокс", "Chrome2"));
        searchEngine.add(new Article("Мясо как источник белка", "Чрезмерное употребление мяса вредит здоровью."));
        searchEngine.add(new Article("Ты все еще голодный?", "Если ты голодный - заставь себя поесть!"));
        searchEngine.add(new Article("Магазин автозапчастей", "Широкий выбор комплектующих для авто."));
        searchEngine.add(new Article("Ozon", "Закажи, оплати, дождись, забери, убедись что не подходит - выкинь!"));
        searchEngine.add(new Article("Полет птицы", "Статья про сложное строение перьев у пернатых."));
        searchEngine.add(new Article("Огородные вредители", "Купил перегной - беги за препаратами от вредителей! :)"));

        System.out.println();
        System.out.println("Демонстрация поиска и вывода результата:");

        searchEngine.printSearch(searchEngine.search("Магазин"));
        System.out.println();
        searchEngine.printSearch(searchEngine.search("голодный"));
        System.out.println();
        searchEngine.printSearch(searchEngine.search("выбор"));
        System.out.println();
        searchEngine.printSearch(searchEngine.search("перьев"));
        System.out.println();
        searchEngine.printSearch(searchEngine.search("Пироженое"));
        System.out.println();
        searchEngine.printSearch(searchEngine.search("забери"));
        System.out.println();
        searchEngine.printSearch(searchEngine.search("орехи"));

        System.out.println();
        System.out.println("Создадим заведомо некорректные продукты");

        try {
            searchEngine.add(new SimpleProduct("", 60));
            searchEngine.add(new DiscountedProduct("Жук", 10, -11));
            searchEngine.add(new DiscountedProduct("Пчела", 0, 11));
        } catch (IllegalArgumentException e) {
            System.out.println(e);
        }

        try {
        System.out.println(searchEngine.theMostSuitable("Магазин").toString());
        System.out.println(searchEngine.theMostSuitable("бум").toString());
        System.out.println(searchEngine.theMostSuitable("бeeee").toString());

        } catch (BestResultNotFound e) {
            System.out.println(e);
        }

        System.out.println();
        System.out.println("Добавляем продукты в корзину:");
        productBasket.addProduct(new SimpleProduct("Мороженое", 100));
        productBasket.addProduct(new DiscountedProduct("Пироженое", 110, 15));
        productBasket.addProduct(new FixPriceProduct("Твороженое"));
        productBasket.addProduct(new SimpleProduct("Орехи", 100));
        productBasket.addProduct(new SimpleProduct("Семечки", 60));
        productBasket.addProduct(new DiscountedProduct("Орехи", 90, 20));
        productBasket.addProduct(new SimpleProduct("Печенье", 30));

        System.out.println();
        System.out.println("Выводим перечень продуктов в корзине");
        productBasket.printAllProductBasket();

        System.out.println();
        System.out.println("Удаляем продукты:");
        System.out.println(productBasket.delProduct("Орехи"));


        System.out.println();
        System.out.println("Выводим перечень продуктов в корзине");
        productBasket.printAllProductBasket();

        System.out.println();
        System.out.println("Удаляем несуществующие продукты:");
        if (productBasket.delProduct("Пасатижи").isEmpty()) {
            System.out.println("Список пуст");

        }
    }
}
