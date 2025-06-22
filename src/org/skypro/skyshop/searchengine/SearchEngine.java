package org.skypro.skyshop.searchengine;

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
}
