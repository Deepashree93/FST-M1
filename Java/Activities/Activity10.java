package Activities;

import java.util.HashSet;

public class Activity10 {
    public static void main(String[] args) {
        HashSet<String> hs = new HashSet<String>() ;
        hs.add("J");
        hs.add("A");
        hs.add("V");
        hs.add("A");
        hs.add("P");
        hs.add("L");

        System.out.println("Size of the hashset :" + hs.size());
        hs.remove("J");
        hs.remove("K");
        hs.contains("V");
        System.out.println("Updated set :" + hs);
    }

}
