package Activities;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Activity13 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<Integer>() ;
        Random indexGen = new Random();

        System.out.print("Enter integer values :");
        System.out.println("Stop integer values :");

        while(scan.hasNextInt()) {
            list.add(scan.nextInt());
        }

        Integer nums[] = list.toArray(new Integer[0]);
        Integer intValue = indexGen.nextInt(nums.length);

        System.out.println("Index value generated :" + intValue);
        System.out.println("Value in the array at that index :" + nums[intValue]);

        scan.close();
    }

}
