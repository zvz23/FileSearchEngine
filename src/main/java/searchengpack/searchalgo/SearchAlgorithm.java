package searchengpack.searchalgo;

import searchengpack.SearchResult;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public abstract class SearchAlgorithm implements Searchable {

    protected Set<String> searchResult = new HashSet<>();
    protected List<String> searchFrom;
    protected Map<String, HashSet<Integer>> indexSet;


    public SearchAlgorithm(List<String> searchFrom, Map<String, HashSet<Integer>> indexSet){
        this.searchFrom = searchFrom;
        this.indexSet = indexSet;
    }

}
