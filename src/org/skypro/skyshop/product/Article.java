package org.skypro.skyshop.product;

public class Article implements Searchable {
    private final String articleTitle;
    private final String articleText;

    public Article(String name, String articleText){
        this.articleTitle = name;
        this.articleText = articleText;
    }
    @Override
    public String toString() {
        return this.getArticleTitle() + "/n" + this.getArticleText();
    }

    public String getArticleTitle() {
        return articleTitle;
    }

    public String getArticleText(){
        return articleText;
    }

    public String searchTerm() {
        return getArticleTitle();
    }

    public String contentType() {
        return "ARTICLE";
    }
}
