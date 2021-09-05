package Race;
import Vehicle.*;
import Engine.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;


public abstract class RaceInterface {
    private static Car racingCar;
    private static Track currentTrack;
    private static boolean hitWall = false;
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
        } while (currentTrack.getCarLocation() < currentTrack.getTrackLength());

        System.out.println("Finish line crossed! Breaking...");

        while (currentTrack.getCarLocation() >= currentTrack.getTrackLength() && racingCar.getCurrentSpeed() > 0) {
            racingCar.decelerate();
            currentTrack.addTurnTaken();

            if (currentTrack.getCarLocation() <= currentTrack.locationOfWall) {
                System.out.println("You hit the wall! Game Over!");
                hitWall = true;
                return;
            }
        }

        endOfRace();
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

            System.out.println(racingCar.getName() + " is currently traveling at " + racingCar.getCurrentSpeed() + " " +
                    "feet per second");

            System.out.println("What will you do?" +
                    "\n(a)ccelerate?" +
                    "\n(c)oast" +
                    "\n(b)reak");

            choice = scanner.nextLine();

            switch (choice.toLowerCase(Locale.ROOT)) {
                case "a" -> accelerateCar();
                case "c" -> coast();
                case "b" -> decreaseSpeed();
                default -> System.out.println("Invalid Selection\nTry again");
            }

            currentTrack.increaseCarLocation(racingCar.getCurrentSpeed());

            System.out.println(racingCar.getName() + " is currently " + (currentTrack.getTrackLength() - currentTrack.getCarLocation()) + " feet from the finish");

            currentTrack.addTurnTaken();

        } while (currentTrack.getCarLocation() < currentTrack.getTrackLength());

    }

    private static void getTracks() {
        for (int i = 0; i < tracks.size(); i++) {
            System.out.printf("%d) ", i+1);
            System.out.printf("%s: Length in ft: ", tracks.get(i).getName());
            System.out.printf("%d\n", tracks.get(i).getTrackLength());
        }
    }

    private static void setCurrentTrack() {
        String choice = "";

        tracks.add(new Track("Beginner Track", 1_500, -250));
        tracks.add(new Track("Intermediate Track", 1_000, -150));
        tracks.add(new Track("Expert Track", 500, -50));

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

    private static void accelerateCar() {
        System.out.print(racingCar.getName() + " accelerates from " + racingCar.getCurrentSpeed() + " feet per " +
                "second");

        racingCar.accelerate();

        System.out.println(" to " + racingCar.getCurrentSpeed() + " feet per second");
    }

    private static void coast() {
        System.out.println(racingCar.getName() + " continues at " + racingCar.getCurrentSpeed() + " feet per second");
    }

    private static void decreaseSpeed() {
        System.out.print(racingCar.getName() + " reduces speed from " + racingCar.getCurrentSpeed() + " feet per " +
                "second");

        racingCar.decelerate();

        System.out.println(" to " + racingCar.getCurrentSpeed() + " feet per second");
    }

    private static void endOfRace() {
        System.out.println("The race is over!\n" + racingCar.getName() + " finished in " + currentTrack.getTurnsTaken() +
                " turns" + (hitWall ? ". You hit the wall" : "."));
    }


}
