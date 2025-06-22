package org.skypro.skyshop.searchengine;

public interface Searchable {
    String getSearchTerm();
    String contentType();

    default String getStringRepresentation(){
        return this.getSearchTerm() + " - " + this.contentType();
    }
}
