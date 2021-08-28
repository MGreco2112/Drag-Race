package Engine;

public class GasEngine extends Engine{

    public GasEngine() {
        this.type = "Gas";
        this.isGas = true;
        this.accelerationRate = 25;
        this.breakRate = 8;
        this.maxSpeed = 200;
    }


}
