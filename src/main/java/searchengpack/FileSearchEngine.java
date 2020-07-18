package searchengpack;
import searchengpack.searchalgo.*;

import java.io.*;
import java.util.*;

public class FileSearchEngine extends SearchEngine {

    private List<String> dataList = new ArrayList<>();
    private Map<String, HashSet<Integer>> indexSet = new Hashtable<>();
    public FileSearchEngine(File dataFile) {
        super(dataFile);
        initMap();
    }

    @Override
    public void search(String query, SearchType algoType) {
        SearchAlgorithm algo = null;
        switch (algoType){
            case ALL:
                algo = new AllSearch(dataList, indexSet);
                break;
            case NONE:
                algo = new NoneSearch(dataList, indexSet);
                break;
            case ANY:
                algo = new AnySearch(dataList, indexSet);
                break;

        }

        result = new SearchResult(algo.search(query));

    }

    public SearchResult getResult(){
        return result;
    }
    public void displayAllData(){
        dataList.stream().forEach(i -> System.out.println(i));
    }

    public List<String> getDataList(){return dataList;};

    private void initMap(){
        int index = 0;
        Scanner scan = null;
        try{
            scan = new Scanner(dataFile);
            while(scan.hasNextLine()){
                String temp = scan.nextLine();
                dataList.add(temp);
                for(String word : temp.split(" ")){
                    String wordTemp = word.toLowerCase();
                    if(indexSet.get(wordTemp) == null){
                        indexSet.put(wordTemp, new HashSet<>());
                    }
                    indexSet.get(wordTemp).add(index);
                }
                index++;
            }

        }catch (FileNotFoundException | NullPointerException e){
            throw new IllegalArgumentException("Error: File not found.");
        }
        finally {
            if(scan != null){
                scan.close();
            }
        }
        System.out.println("Initialize Complete");
    }
}
