package Race;
import Vehicle.*;
import Engine.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;


public class RaceInterface {
    private static Car racingCar;
    private static Track currentTrack;
    private static List<Track> tracks = new ArrayList<>();
    private static final Scanner scanner = new Scanner(System.in);

        //setup game (select car and engine, choose courses, set turn to 1)
        //begin game (display length of course, current position of car, give options:
        //  (a)ccelerate: current speed += acceleration. Current location += current speed. Distance to finish -=
        //  current location
        //  (c)oast: current location += current speed. Distance to finish -= current location
        //  (b)reak: current speed -= breaking speed. Current Location += current speed. Distance to finish -=
        //  current location)
        //turn increments.
        //if finish line is not crossed relaunch menu, if isFinished break until speed reaches zero and count turns
        //once finished and car stopped display number of turns taken and distance past finish line

    public static void game() {
        setupGame();

        do {
            turn();
        } while (currentTrack.carLocation < currentTrack.getTrackLength());

        while (currentTrack.carLocation >= currentTrack.getTrackLength() && racingCar.getCurrentSpeed() > 0) {
            racingCar.decelerate();
        }

    }

    private static void setupGame() {
        setCurrentTrack();
        setCurrentRacingCar();
        currentTrack.addTurnTaken();

    }

    private static void turn() {
        String choice = "";
        System.out.println("Welcome to " + currentTrack.getName() + "!\nTrack length: " + currentTrack.getTrackLength() + " feet");

        do {
            System.out.println("What will you do?" +
                    "\n(a)ccelerate?" +
                    "\n(c)oast" +
                    "\n(b)reak");

            choice = scanner.nextLine();

            switch (choice.toLowerCase(Locale.ROOT)) {
                case "a" ->
            }



        } while (currentTrack.carLocation < currentTrack.getTrackLength());

    }

    private static void getTracks() {
        for (int i = 0; i < tracks.size(); i++) {
            System.out.printf("%d) ", i+1);
            System.out.printf("%s: Length in ft/s: ", tracks.get(i).getName());
            System.out.printf("%d\n", tracks.get(i).getTrackLength());
        }
    }

    private static void setCurrentTrack() {
        String choice = "";

        tracks.add(new Track("Track 01", 500));

        do {
            System.out.println("Which Track would you like to race on?\nEnter the number next to the Track");
            getTracks();
            choice = scanner.nextLine();
        } while (Integer.parseInt(choice) - 1 < -1 && Integer.parseInt(choice) - 1 >= tracks.size());

        System.out.println("The selected Track is " + tracks.get(Integer.parseInt(choice) - 1).getName());
        currentTrack = tracks.get(Integer.parseInt(choice)-1);
    }

    private static void setCurrentRacingCar() {
        GasEngine gasEngine = new GasEngine();
        ElectricEngine electricEngine = new ElectricEngine();
        String choice = "";
        String carType = "";
        Engine engineType = null;

        do {
            System.out.println("Select the Car you wish to race with\nEnter the number next to the desired Car");
            currentTrack.getCarTypes();
            choice = scanner.nextLine();
        } while (Integer.parseInt(choice) - 1 < -1 && Integer.parseInt(choice) - 1 >= currentTrack.getCarsLength());

        carType = currentTrack.getCarName(Integer.parseInt(choice)-1);

        choice = "";

        do {
            System.out.println("Which Engine will you put in " + carType + " ?\n");
            System.out.println("1) " + gasEngine);
            System.out.println("2) " + electricEngine);

            choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    System.out.println("You have selected Gas Engine");
                    engineType = gasEngine;
                    break;

                case "2":
                    System.out.println("You have selected Electric Engine");
                    engineType = electricEngine;
                    break;

                default:
                    System.out.println("Invalid Engine Selection\nTry again");
            }
        } while (!choice.equals("1") && !choice.equals("2"));

        System.out.println("You have selected a " + carType + " running on a(n) " + engineType);
        racingCar = new Car(carType, engineType);
    }



}
