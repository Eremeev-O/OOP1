package org.skypro.skyshop.searchengine;

import java.util.*;

public class SearchEngine {
    List<Searchable> searchable = new ArrayList<>();

    public void add(Searchable obj){
        searchable.add(obj);
    }
    public TreeMap<String, Searchable> search(String srchText){
        int num = 0;
        TreeMap<String, Searchable> tempTree = new TreeMap<>();
        Iterator<Searchable> iteratorSearch = searchable.iterator();

        while (iteratorSearch.hasNext()) {
            Searchable element = iteratorSearch.next();
            if (element != null &&  element.toString().contains(srchText)) {
                if (!tempTree.containsKey(element.getSearchTerm())){
                    tempTree.put(element.getSearchTerm(), element);
                } else {
                    num++;
                    tempTree.put(element.getSearchTerm() + "_" + num, element);
                }
            }
        }
        return tempTree;
    }

    public void printSearch(TreeMap<String, Searchable> obj){
        for (Map.Entry<String, Searchable> element: obj.entrySet()) {
            if (element != null) {
                System.out.println(element.getValue().getStringRepresentation());
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
