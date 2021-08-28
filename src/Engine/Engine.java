package Engine;

public abstract class Engine {
    protected String type;
    protected int accelerationRate;
    protected int breakRate;
    protected boolean isOn = false;
    protected boolean isGas = false;
    protected boolean isElectric = false;

    public boolean getIsOn() {
        return isOn;
    }

    public int getAccelerationRate() {
        return accelerationRate;
    }

    public int getBreakRate() {
        return breakRate;
    }

    public void turnOn() {
        if (!isOn) {
            System.out.println("Engine is now on");
            isOn = true;
        } else {
            System.out.println("Engine is already on");
        }
    }

    public void turnOff() {
        if (isOn) {
            System.out.println("Engine is now off");
        } else {
            isOn = false;
            System.out.println("Engine is already off");
        }
    }
}
