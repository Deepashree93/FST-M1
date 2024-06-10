package Activities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.SystemMenuBar;

import scala.Array;

class Plane {
    private List<String> passengers;
    private int maxPassengers;
    private Date lastTimeTookOf;
    private Date lastTimeLanded;

    Plane(int maxPassengers){
        this.maxPassengers = maxPassengers ;
        this.passengers = new ArrayList<>(); 
    }

    public void onboard(String passenger){
        this.passengers.add(passenger);
    }

    public Date takeoff() {
        return lastTimeTookOf ;
    }
    
    public void land(Date lastTimeLanded){
        this.lastTimeLanded = new Date();
        this.passengers.clear();
    }

    public Date getLastTimeLanded() {
        return lastTimeLanded ;
    }

    public List<String> getPassengers() {
        return passengers ;
    }
}

public class Activity6 {
    public static void main (String [] args) throws InterruptedException{
    Plane plane = new Plane(10);
    plane.onboard("Sumit");
    plane.onboard("Rekha");
    plane.onboard("Peter");
    plane.onboard("Ramya");

    System.out.println("Take-off time :" + plane.takeoff());
    System.out.println("List of passengers : " + plane.getPassengers());
    Thread.sleep(5000);
    plane.land(null);
    System.out.println("Time of landing : " + plane.getLastTimeLanded());
}
}



