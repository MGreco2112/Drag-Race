package Vehicle;

import Engine.Engine;

public class Car extends Vehicle{
    protected String name;

    public Car(String name, Engine engine) {
        this.name = name;
        this.type = "Car";
        this.engine = engine;
        this.isLand = true;
    }

    public int getCurrentSpeed() {
        return currentSpeed;
    }

    public void accelerate() {
        if (currentSpeed < engine.getMaxSpeed()) {
            currentSpeed += engine.getAccelerationRate();

            if (currentSpeed >= engine.getMaxSpeed()) {
                currentSpeed = engine.getMaxSpeed();
                System.out.println("Car has hit max engine speed");
            }

        } else {
            System.out.println("Already traveling at Max Speed");
        }
    }

    public void decelerate() {

        if (currentSpeed > 0) {
            currentSpeed -= engine.getBreakRate();

            if (currentSpeed <= 0) {
                currentSpeed = 0;
                System.out.println("Car is now stopped");
            }

        } else {
            System.out.println("Car is stopped");
        }
    }

    public String toString() {
        return name + " " + engine;
    }


}
