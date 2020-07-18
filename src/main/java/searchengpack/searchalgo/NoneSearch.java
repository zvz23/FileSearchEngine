package searchengpack.searchalgo;

import java.util.*;
import java.util.stream.Collectors;

public class NoneSearch extends SearchAlgorithm {


    public NoneSearch(List<String> searchFrom, Map<String, HashSet<Integer>> indexSet) {
        super(searchFrom, indexSet);
    }

    @Override
    public Set<String> search(String query) {
        searchResult.clear();
        Set<Integer> notInclude = new HashSet<>();
        String[] querySplit = query.split(" ");
        Set<String> set = Arrays.stream(querySplit).map(i -> i.toLowerCase()).collect(Collectors.toSet());
        for(String word : set){
            HashSet<Integer> tempSet = indexSet.get(word);
            if(tempSet != null){
                tempSet.stream().forEach(i -> notInclude.add(i));
            }
        }

        for(int i = 0; i < searchFrom.size(); i++){
            if(!notInclude.contains(i)){
                searchResult.add(searchFrom.get(i));
            }
        }

        return searchResult;
    }
}
