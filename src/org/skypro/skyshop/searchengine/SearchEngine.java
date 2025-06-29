package org.skypro.skyshop.searchengine;

import org.skypro.skyshop.product.DiscountedProduct;

public class SearchEngine {
    private Searchable[] searchable;

    public SearchEngine(int count){
        this.searchable = new Searchable[count];
    }

    public Searchable[] search(String srchText){
        Searchable[] srchEng = new Searchable[5];
        int id = 0;
        for (Searchable obj: searchable) {
            if (obj != null && obj.toString().contains(srchText)) {
                srchEng[id] = obj;
                id++;
                if (id == 5) {
                    break;
                }
            }
        }
        return srchEng;
    }

    public void add(Searchable obj){
        for (int i = 0; i < this.searchable.length; i++) {
            if (this.searchable[i] == null) {
                this.searchable[i] = obj;
                return;
            }
        }
        System.out.println("Невозможно добавить продукт");
    }
    public void printSearch(Searchable[] obj){
        for (Searchable value : obj) {
            if (value != null) {
                System.out.println(value.getStringRepresentation());
                return;
            }
        }
    }
    public Searchable theMostSuitable(String string){
        int count;
        int index;
        int substringIndex;
        int substringIndexObj = 0;
        Searchable outObj = null;
        for (Searchable value : searchable) {
            if (value != null) {
                count = 0;
                index = 0;
                substringIndex = value.getSearchTerm().toLowerCase().indexOf(string.toLowerCase(), index);
                while (substringIndex != -1) {
                    count++;
                    index = substringIndex + string.length();
                    substringIndex = value.getSearchTerm().toLowerCase().indexOf(string.toLowerCase(), index);
                }
                if (count > substringIndexObj) {
                    substringIndexObj = count;
                    outObj = value;
                }
            }
        }
        if (outObj == null) {
            throw new BestResultNotFound(string);
        }
        return outObj;
    }
}
