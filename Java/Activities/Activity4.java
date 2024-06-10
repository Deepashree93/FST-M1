package Activities;

import java.util.Arrays;

public class Activity4 {
    public static void sortedarray(int [] array) {
        for (int i = 0; i<array.length;i++){
            int sortednum = array[i];
            
            int j = i - 1;
            while (j >= 0 && sortednum < array[j]) {
                array[j + 1] = array[j];
                --j;
            }
            array[j+1] = sortednum ;
        }

    }

public static void main(String [] args){
    int numbers [] = {4,3,2,1,6,5};
    sortedarray(numbers);
    System.out.println("Array before sorting : " + Arrays.toString(numbers));
    //System.out.println("Array after sorting" + );
}
}

