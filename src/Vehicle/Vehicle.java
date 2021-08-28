package Vehicle;

import Engine.Engine;

import java.util.ArrayList;
import java.util.List;

public abstract class Vehicle {
    public String type;
    public Engine engine;
    public int maxLoad;
    public boolean isLand = false;
    public boolean isAir = false;
    public boolean isWater = false;

    public void toggleEngine() {
        if (!engine.isOn) {
            engine.turnOn();
        } else {
            engine.turnOff();
        }
    }


}
