package Vehicle;

import Engine.Engine;

public class Car extends Vehicle{

    public Car(Engine engine, int maxLoad) {
        this.type = "Car";
        this.engine = engine;
        this.maxLoad = maxLoad;
        this.isLand = true;
    }

    protected void accelerate() {
        currentSpeed += engine.getAccelerationRate();
    }

    protected void decelerate() {
        currentSpeed -= engine.getBreakRate();
    }


}
