package Engine;

public class GasEngine implements Engine{
    protected String type;
    protected int maxSpeed;
    protected int accelerationRate;
    protected int breakRate;
    protected boolean isOn = true;
    protected boolean isGas = false;
    protected boolean isElectric = false;


    public GasEngine() {
        this.type = "Gas";
        this.isGas = true;
        this.accelerationRate = 65;
        this.breakRate = 15;
        this.maxSpeed = 250;
    }

    public boolean getIsOn() {
        return isOn;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public int getAccelerationRate() {
        return accelerationRate;
    }

    public int getBreakRate() {
        return breakRate;
    }

    public String toString() {
        if (isGas) {
            return "Gas Engine" + ":\nSpeed in ft/s: " + accelerationRate + "\nBreaking Rate in ft/s: " + breakRate;
        } else {
            return "Electric Engine" + ":\nSpeed in ft/s: " + accelerationRate + "\nBreaking Rate in ft/s: " + breakRate;
        }
    }



}
