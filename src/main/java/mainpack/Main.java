package mainpack;
import searchengpack.FileSearchEngine;
import searchengpack.searchalgo.SearchType;
import java.util.*;
import java.io.File;
public class Main {
    static Scanner input = new Scanner(System.in);
    public static void main(String[] args) {
        if(args.length == 0){
            throw new IllegalArgumentException("Error: no file input");
        }
        if(args.length > 2){
            throw new IllegalArgumentException("Error: too many arguments");
        }
        File data = null;
        switch (args[0]){
            case "--data":
                data = new File(args[1]);
                break;
            default:
                throw new IllegalArgumentException("Error: Invalid argument");
        }
        FileSearchEngine searchEngine = new FileSearchEngine(data);
        int option;
        do{
            option = displayMenu();
            switch (option){
                case 1:
                    System.out.println("Select a matching strategy: ALL, ANY, NONE");
                    String strategy = input.nextLine();
                    System.out.println("Search: ");
                    String searchTemp = input.nextLine();
                    try{
                        SearchType type = SearchType.valueOf(strategy.toUpperCase());
                    }catch (IllegalArgumentException e){
                        throw new IllegalArgumentException("Error: Invalid search strategy");
                    }
                    searchEngine.search(searchTemp, SearchType.valueOf(strategy.toUpperCase()));
                    searchEngine.getResult().displayResult();
                    searchEngine.clearResults();
                    break;
                case 2:
                    searchEngine.displayAllData();
                    break;
                default:
                    break;

            }
        }while (option != 0);
        System.out.println("\nBye!");


    }

    public static int displayMenu(){
        Scanner scan = new Scanner(System.in);
        System.out.println("=== Menu ===");
        int option = -1;
        do{
            System.out.println("1. Search data\n2. Print all data\n0. Exit");
            option = scan.nextInt();
            scan.nextLine();
            if(option != 1 && option != 2 && option != 0){
                System.out.println("\nIncorrect option! Try again.\n");
            }
        }while(option != 1 && option != 2 && option != 0);
        return option;
    }


}
