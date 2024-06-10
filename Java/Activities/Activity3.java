package Activities;

public class Activity3 {
    public static void main(String[] args){
        double seconds = 1000000000 ;
        double EarthSeconds = 31557600;
        double MercurySeconds = 0.2408467;
        double VenusSeconds = 0.61519726;
        double MarsSeconds = 1.8808158;
        double JupiterSeconds = 11.862615;
        double SaturnSeconds = 29.447498;
        double UranusSeconds = 84.016846;
        double NeptuneSeconds = 164.79132;

        System.out.println("Earth Age: " + seconds/EarthSeconds);
        System.out.println("Mercury Age: " + seconds / MercurySeconds);
        System.out.println("Venus Age :" + seconds/VenusSeconds);
        System.out.println("Mars Age :" + seconds/MarsSeconds);
        System.out.println("Jupiter Age :" + seconds/JupiterSeconds);
        System.out.println("Saturn Age :" + seconds/SaturnSeconds);
        System.out.println("Uranus age :" + seconds/UranusSeconds);
        System.out.println("Neptune Age :" + seconds / NeptuneSeconds);
        
    }

}
