package Engine;

public class ElectricEngine implements Engine{

    protected String type;
    protected int maxSpeed;
    protected int accelerationRate;
    protected int breakRate;
    protected boolean isOn = true;
    protected boolean isGas = false;
    protected boolean isElectric = false;


    public ElectricEngine() {
        this.type = "Electric";
        this.isElectric = true;
        this.accelerationRate = 72;
        this.breakRate = 20;
        this.maxSpeed = 175;
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
