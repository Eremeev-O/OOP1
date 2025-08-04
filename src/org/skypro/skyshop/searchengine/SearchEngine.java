package org.skypro.skyshop.searchengine;

import java.util.*;

import static java.util.stream.Collectors.*;

public class SearchEngine {

    private Set<Searchable> searchable = new HashSet<>();


    public void add(Searchable obj){
        searchable.add(obj);
    }

    public TreeSet<String> search(String srchText){
        return searchable.stream()
                .filter(object -> object.toString().contains(srchText))
                .map(object -> object.getSearchTerm())
                .collect(toCollection(() -> new TreeSet<>(new Comparator<String>() {
                    @Override
                    public int compare(String o1, String o2) {
                        if (o2.length() == o1.length()) {
                            return o1.compareTo(o2);
                        }
                        return o2.length() - o1.length();
                    }
                })));
    }

    public void printSearch(TreeSet<String> obj){
        for (String value: obj) {
            Iterator<Searchable> iteratorSearch = searchable.iterator();
            while (iteratorSearch.hasNext()) {
                Searchable element = iteratorSearch.next();
                if (element != null && element.toString().contains(value)) {
                    System.out.println(element.getStringRepresentation());
                }
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
