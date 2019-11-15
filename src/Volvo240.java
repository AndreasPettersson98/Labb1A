import java.awt.*;

/**
 * Class that describes a Volvo240
 */

public class Volvo240 extends Car{

    private final static double trimFactor = 1.25;

    /**
     * A constructor that sets data to a Volvo240 when created from its super class Car
     */

    public Volvo240( double currentSpeed, double x, double y){
        super(4, 100, currentSpeed, Color.BLACK, "Volvo240" ,x , y);
    }

    /**
     *Helper method for the methods that increments/decrements speed.
     */

    @Override
    public double speedFactor(){
        return getEnginePower() * 0.01 * trimFactor;
    }




}