package searchengpack.searchalgo;


import java.util.*;
import java.util.stream.Collectors;

public class AnySearch extends SearchAlgorithm {


    public AnySearch(List<String> searchFrom, Map<String, HashSet<Integer>> indexSet) {
        super(searchFrom, indexSet);
    }

    @Override
    public Set<String> search(String query) {
        searchResult.clear();
        String[] querySplit = query.split(" ");
        Set<String> set = Arrays.stream(querySplit).map(i -> i.toLowerCase()).collect(Collectors.toSet());
        for(String word : set){
            HashSet<Integer> tempSet = indexSet.get(word);
            if(tempSet != null){
                tempSet.stream().forEach(i -> searchResult.add(searchFrom.get(i)));
            }
        }
        return  searchResult;
    }
}
