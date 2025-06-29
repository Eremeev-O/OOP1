package org.skypro.skyshop.article;

import org.skypro.skyshop.searchengine.Searchable;

import java.text.MessageFormat;

public class Article implements Searchable {
    private final String articleTitle;
    private final String articleText;

    public Article(String name, String articleText){
        this.articleTitle = name;
        this.articleText = articleText;
    }


    public String getArticleTitle() {
        return articleTitle;
    }

    public String getArticleText(){
        return articleText;
    }
    @Override
    public String toString() {
        return this.getArticleTitle() + "\r\n" + this.getArticleText();
    }

    public String getSearchTerm() {
        return getArticleTitle();
    }

    public String contentType() {
        return "ARTICLE";
    }
}
