import Engine.*;
import Race.*;
import Vehicle.*;

public class Main {

    public static void main(String[] args) {
	    /*
	    The objective of this assignment is to create an application that allows a user to select at minimum
	    a vehicle and an engine type.
	     Next the system should show distance left to travel and the user has at least three options:
        accelerate
        coast
        decelerate


        accelerate should raise the vehicles speed by (recommended) the engines acceleration rate until the vehicle
         reaches max speed.
        coast should maintain the vehicles current speed or if implemented apply some sort of reduction due to
         either friction, wind resistance,
        vehicle weight etc.
        decelerate should reduce the vehicles speed by the (recommended) vehicles brake
         rate (unless a tire/breaks class is implemented)


        no matter what option is selected a single Tick of time should pass where the vehicles current speed is
         added to its position the
         speed is adjusted by the selected option. Then the options are given again.


        application should finish once the user gets the vehicle to travel the given distance and comes to a stop
         (a tick passes where the location of
         the car does not change) should display the amount of ticks it took.


        be creative on this I'm giving very little information to see if you can build something from almost no
         information.
        Ask for help when stuck and take the needed time to plan.
	     */

        RaceInterface.game();

    }
}
