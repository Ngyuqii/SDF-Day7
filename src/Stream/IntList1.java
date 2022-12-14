package Stream;

import java.security.SecureRandom;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class IntList1 {

    public static void main(String[] args) {
        
        List<Integer> numList = new LinkedList<>();

        Random rand = new SecureRandom();
        Integer numSize = 200;
        Integer numRange = 100;

        for (Integer i = 0; i < numSize; i++) {
            Integer num = rand.nextInt(numRange);
            numList.add(num);
        }
        System.out.printf("The numList > %s.\n\n", numList);

        mapping(numList);
        System.out.println("Mapping is complete.\n");

        filtering(numList);
        System.out.println("Filtering by multiples of 3 is complete.\n");

    }

    public static void mapping (List<Integer> numList) {

        System.out.println("Applying Map.");

        List<String> sMapList = new LinkedList<>();
        List<Integer> iMapList = new LinkedList<>();

        //Method 1 using for loop
        for (Integer n : numList) {
            sMapList.add("%d%d".formatted(n,n));
        }
        for (String j : sMapList) {
            iMapList.add(Integer.parseInt(j));
        }
        System.out.printf("The iMapList > %s\n", iMapList);

        //Method 2 using stream
        iMapList = numList.stream()
        .map(n -> "%d%d". formatted(n,n))
        .map(Integer::parseInt) //change elements in mapList from string to integer
        .toList();
        System.out.printf("The stream iMapList > %s\n", iMapList);

    }
    
    public static void filtering(List<Integer> numList) {

        System.out.println("Applying Filter.");
        
        List<Integer> filterList = new LinkedList<>();
        
        //Method 1 using for loop
        for (Integer n : numList) {
            if((n%3 == 0) && (n != 0)) {
                filterList.add(n);
            }
        }
        System.out.printf("The filterList > %s\n", filterList);
       
        //Method 2 using stream
        filterList = numList.stream()
        .filter(n -> ((n%3 == 0) && (n != 0)))
        .distinct() //remove duplicates
        .sorted() //sort in ascending order
        .limit(10) //return only the first 10 values
        .toList(); //add to filterList
        System.out.printf("The stream filterList > %s\n", filterList);

    }

}