package Activities;

interface BicycleParts {
    public int gears = 0;
    public int speed = 0;
}

interface BicycleOperations {
    public void applyBrake(int decrement) ;
    public void speedUp(int increment) ;
}

class Bicycle implements BicycleOperations,BicycleParts {
    public int gears;
    public int currentSpeed;

    Bicycle(int gears, int currentSpeed){
        this.gears = gears;
        this.currentSpeed = currentSpeed;
    }

    public void applyBrake(int decrement){
        currentSpeed = currentSpeed-decrement ;
        System.out.println("Current speed :" + currentSpeed);
    }

    public void speedUp(int increment){
        currentSpeed = currentSpeed+increment;
        System.out.println("Current speed :" + currentSpeed);
    }

    public String bicycleDesc() {
        return("No of gears are "+ gears + "\nSpeed of bicycle is " + currentSpeed);
    }
}

class MountainBike extends Bicycle {
    public int seatHeight ;

    public MountainBike(int gears, int currentSpeed, int seatHeight) {
        //Invoking base-class(Bicycle) constructor
        super(gears, currentSpeed);
        this.seatHeight = seatHeight ;
    }
    public void setHeight(int newValue) {
        seatHeight = newValue;
    }
}
public class Activity7 {
    public static void main(String args[]) {
        MountainBike mb = new MountainBike(2, 0, 25);
        System.out.println(mb.bicycleDesc());
        mb.speedUp(10);
        mb.applyBrake(3);
}
}
