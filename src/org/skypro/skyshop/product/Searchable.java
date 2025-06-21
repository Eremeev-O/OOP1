package org.skypro.skyshop.product;

public interface Searchable {
    String searchTerm();
    String contentType();

    default String getStringRepresentation(){
        return this.searchTerm() + " - " + this.contentType();
    }
}
