
import java.awt.*;

/**
 * Class for describing a Saab95
 */
public class Saab95 extends Car{

    public boolean turboOn;

    /**
     *
     * @param currentSpeed current speed of the car
     * @param x coordinate x
     * @param y coordinate y
     */

    public Saab95(double currentSpeed, double x, double y){
        super(2, 125, currentSpeed, Color.red,"Saab95",x , y );

    }

    /**
     * Method that sets the turbo on
     */

    public void setTurboOn(){
        turboOn = true;
    }

    /**
     * Method that sets the turbo off
     */
    public void setTurboOff(){
        turboOn = false;
    }

    /**
     *Helper method for the methods that increments/decrements speed.
     */

    @Override
    public double speedFactor(){
        double turbo = 1;
        if(turboOn) turbo = 1.3;
        return getEnginePower() * 0.01 * turbo;
    }

}

