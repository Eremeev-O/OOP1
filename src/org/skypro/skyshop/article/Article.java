package org.skypro.skyshop.article;

import org.skypro.skyshop.searchengine.Searchable;

import java.util.Objects;

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

    @Override
    public boolean equals(Object obj) {
        if (obj == null || getClass() != obj.getClass()) return false;
        Article article = (Article) obj;
        return Objects.equals(articleTitle, article.articleTitle);
    }

    @Override
    public int hashCode() {
        return Objects.hash(articleTitle);
    }
}
