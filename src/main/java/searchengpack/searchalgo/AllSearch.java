package searchengpack.searchalgo;

import java.util.*;
import java.util.stream.Collectors;

public class AllSearch extends SearchAlgorithm {


    public AllSearch(List<String> searchFrom, Map<String, HashSet<Integer>> indexSet) {
        super(searchFrom, indexSet);
    }

    @Override
    public Set<String> search(String query) {
        searchResult.clear();
        String[] querySplit = query.split(" ");
        Set<String> set = Arrays.stream(querySplit).map(i -> i.toLowerCase()).collect(Collectors.toSet());
        if(querySplit.length == 0){
            return searchResult;
        }
        HashSet<Integer> tempSet = indexSet.get(querySplit[0].toLowerCase());
        if(querySplit.length == 1){
            if(tempSet == null){
                searchResult.clear();
            }
            else{
                tempSet.stream().forEach(i -> searchResult.add(searchFrom.get(i)));
            }
            return searchResult;
        }
        Map<Integer, Integer> map = new Hashtable<>();
        for(String word : set){
            tempSet = indexSet.get(word);
            if(tempSet == null){
                searchResult.clear();
                return searchResult;
            }
            else{
                for(Integer i : tempSet){
                    int tempInt = i.intValue();
                    if(map.containsKey(tempInt)){
                        int tempGet = map.get(tempInt);
                        map.replace(tempInt, tempGet, tempGet + 1);
                    }
                    else{
                        map.put(tempInt, 1);
                    }
                }
            }
        }
        for(Integer key : map.keySet()){
            int tempInt = key.intValue();
            if(map.get(tempInt).intValue() == querySplit.length){
                searchResult.add(searchFrom.get(key));
            }
        }
        return searchResult;
    }

}
