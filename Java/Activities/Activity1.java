package Activities;

public class Activity1 {
    public static void main(String [] args){
        Car suzuki = new Car();
        suzuki.make = 2014 ;
        suzuki.color = "Black";
        suzuki.transmission = "Manual";

        suzuki.displayCharacteristics();
        suzuki.accelerate();
        suzuki.brake();
    }

}
