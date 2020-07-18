package searchengpack;

import java.util.HashSet;
import java.util.Set;

public class SearchResult {
    private Set<String> data;
    public SearchResult(Set<String> data){
        this.data = data;
    }


    public void displayResult(){
        if(data.size() == 0){
            System.out.println(toString());

            return;
        }
        data.stream().forEach(i -> System.out.println(i));
    }
    public void clear(){
        data.clear();
    }

    @Override
    public String toString(){
        String temp = data.size() == 0 ? "No results found." : "Found " + data.size() + " result/s";
        return temp;
    }
}
