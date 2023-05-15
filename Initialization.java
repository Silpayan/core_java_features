
public class Initialization extends Exception {

	    // Static variable
	    static int counter;      // Default value 0 when class is loaded.

	    // Instance variables
	    int     noOfWatts = 100; // Explicitly set to 100.
	    boolean indicator;       // Implicitly set to default value false.
	    String  location;        // Implicitly set to default value null.

	    public static void main(String[] args) {
	    	Initialization bulb = new Initialization();
	        System.out.println("Static variable counter: "     + Initialization.counter);
	        System.out.println("Instance variable noOfWatts: " + bulb.noOfWatts);
	        System.out.println("Instance variable indicator: " + bulb.indicator);
	        System.out.println("Instance variable location: "  + bulb.location);
	        
	        int weight = 10;
	        Integer thePrice = new Integer(':');                         // Local variables

	        //if (weight <  10) thePrice = 1000;
	        //if (weight >  50) thePrice = 5000;
	        //if (weight >= 10) thePrice = weight*10;            // Always executed.
	        System.out.println("The price is: " + thePrice);   // (1)
	        int i = 0;
            i=i++;
            i=i++;
            i=i++;
            i=i++;
            System.out.println("The value of i is " + i);
	    }
}
