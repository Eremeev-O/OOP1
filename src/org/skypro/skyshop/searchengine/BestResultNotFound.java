package org.skypro.skyshop.searchengine;

public class BestResultNotFound extends RuntimeException{
    private String string;

    public BestResultNotFound(String string) {
        this.string = string;
    }

    @Override
    public String toString(){
        return "Для запроса {" + string + "} не нашлось подходящей статьи.";
    }
}
