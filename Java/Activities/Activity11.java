package Activities;

import java.util.HashMap;


public class Activity11 {
    public static void main(String[] args) {
        HashMap<Integer, String> colours = new HashMap<Integer,String>();
        colours.put(1, "Blue");
        colours.put(2,"Green");
        colours.put(3,"Yellow");
        colours.put(4, "Pink");
        colours.put(5, "Violet");

        System.out.println("Map is :" + colours);
        colours.remove(3);
        System.out.println("Check if Green colour exists :" + colours.containsValue("Green"));
        System.out.println("Map size :" + colours.size());
    }

}
