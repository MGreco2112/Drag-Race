package Engine;

public abstract class Engine {
    public String type;
    public boolean isOn = false;
    public boolean isGas = false;
    public boolean isElectric = false;

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
