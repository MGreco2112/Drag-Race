package Race;

import Vehicle.*;
import Engine.*;


public class Track {
    private final String name;
    private final int trackLength;
    protected int carLocation = 0;
    private int turnsTaken = 0;
    private final String[] cars = {"DeLorean", "Nissan Z", "Acura NSX", "Mustang GT"};

    public Track(String name, int trackLength) {
        this.name = name;
        this.trackLength = trackLength;
    }

    public void getCarTypes() {
        for (int i = 0; i < cars.length; i++) {
            System.out.printf("%d) ", i+1);
            System.out.printf("%s\n", cars[i]);

        }
    }

    public int getCarsLength() {
        return cars.length;
    }

    public String getCarName(int index) {
        return cars[index];
    }

    public String getName() {
        return name;
    }

    public int getTurnsTaken() {
        return turnsTaken;
    }

    public int getTrackLength() {
        return trackLength;
    }

    public void addTurnTaken() {
        turnsTaken++;
    }


}
