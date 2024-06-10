package Activities;

public class Activity2 {
    public static void main(String[] args) {
        int[] array1 = {10, 77, 10, 54, -11, 10};
        int totalsum = 30;
        int number = 10 ;
        System.out.println("FinalResult is :"  + sumvalue(array1, totalsum,number));
    }
    public static boolean sumvalue(int []array1, int totalsum, int number) {
        int sum = 0 ;
        for (int i = 0; i<array1.length; i++){
            if (array1[i]==10)
            {
                 sum = sum+array1[i] ;
            }

                 if(sum==30)
        {
            return totalsum == sum;
            }   
    }
        return false;
 }
}

    

