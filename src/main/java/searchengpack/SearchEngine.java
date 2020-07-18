package searchengpack;

import searchengpack.searchalgo.SearchType;

import java.io.File;



public abstract class SearchEngine {
    protected File dataFile;
    protected SearchResult result;
    public SearchEngine(File dataFile) {
        this.dataFile = dataFile;
    }


    public abstract void search(String query, SearchType algorithm);

    public void clearResults(){
        result.clear();
    }


}
