package Vehicle;

import Engine.Engine;

import java.util.ArrayList;
import java.util.List;

public abstract class Vehicle {
    protected String type;
    protected Engine engine;
    protected int currentSpeed = 0;
    protected boolean isLand = false;
    protected boolean isAir = false;
    protected boolean isWater = false;

    protected void toggleEngine() {
        if (!engine.getIsOn()) {
            engine.turnOn();
        } else {
            engine.turnOff();
        }
    }

    protected abstract void accelerate();

    protected abstract void decelerate();


}
