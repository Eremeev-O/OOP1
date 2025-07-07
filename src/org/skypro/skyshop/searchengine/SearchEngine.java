package org.skypro.skyshop.searchengine;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SearchEngine {
    List<Searchable> searchable = new ArrayList<>();

    public ArrayList search(String srchText){
        List<Searchable> list = new ArrayList<>();
        Iterator<Searchable> iteratorSearch = searchable.iterator();

        while (iteratorSearch.hasNext()) {
            Searchable element = iteratorSearch.next();
            if (element != null &&  element.toString().contains(srchText)) {
                list.add(element);
            }
        }
        return (ArrayList) list;
    }

    public void add(Searchable obj){
            searchable.add(obj);
    }
    public void printSearch(ArrayList obj){
        Iterator printSearch = obj.iterator();
        while (printSearch.hasNext()) {
            Searchable element = (Searchable) printSearch.next();
            if (element != null) {
                System.out.println(element.getStringRepresentation());
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
