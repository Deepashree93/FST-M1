package Activities;

import java.util.ArrayList;

public class Activity9 {
    public static void main(String[] args) {
        ArrayList<String> namesList = new ArrayList<String>();
        namesList.add("Renu");
        namesList.add("Ram");
        namesList.add("Joe");
        namesList.add("Pavi");
        namesList.add("John");

        for(int i = 0; i<namesList.size(); i++){
            System.out.println("All the names :" + namesList.get(i));
        }
        System.out.println("3rd name in the list :" + namesList.get(2));
        System.out.println("Check the name(Pavi) in the list :" + namesList.contains("Pavi"));
        System.out.println("Number of names in the list :" + namesList.size());
        System.out.println("Removed Renu from the list :" + namesList.remove(0));
        System.out.println("Number of names in the list after removing :" + namesList.size());
    }

}
