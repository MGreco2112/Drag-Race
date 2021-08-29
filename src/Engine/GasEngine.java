package Engine;

public class GasEngine extends Engine{

    public GasEngine() {
        this.type = "Gas";
        this.isGas = true;
        this.accelerationRate = 65;
        this.breakRate = 15;
        this.maxSpeed = 250;
    }


}
