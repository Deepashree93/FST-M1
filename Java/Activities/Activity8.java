package Activities;

class CustomException extends Exception {
    String message = null;

    CustomException(String message){
        this.message=message;
    }
@Override
public String getMessage() {
    return message;
}
public class Activity8 {
    public static void main(String[] args) {
        try {
        Activity8.exceptionTest("Will print to console");
        Activity8.exceptionTest(null);
        }catch(CustomException CE) {
            System.out.println("Print message :" + CE.message );
        }
    }

    private static void exceptionTest(String s1) throws CustomException {
        // TODO Auto-generated method stub
        if (s1 == null){
            throw new CustomException("String has null value");
        } else {
            System.out.println("String value :" +s1);
        }
    }

}
}
