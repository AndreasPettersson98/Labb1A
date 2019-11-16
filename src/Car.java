import java.awt.*;

public abstract class Car implements Movable {

    /**
     * Possible directions of the car
     */

    enum Direction{
        UP, DOWN, RIGHT, LEFT
    }

    private int nrDoors; // Number of doors on the car
    private double enginePower; // Engine power of the car
    private double currentSpeed; // The current speed of the car
    private Color color; // Color of the car
    private String modelName; // The car model name
    private double x; // X-coordinate
    private double y; // Y-coordinate
    private Direction dir; // Variable for the cars directions

    /**
     *
     * @param nrDoors Number of doors
     * @param enginePower Power of engine
     * @param currentSpeed Current speed of the car
     * @param color Color of the car
     * @param modelName Model name of car
     * @param x X- coordinate
     * @param y Y- coordinate
     */

    public Car(int nrDoors, double enginePower, double currentSpeed, Color color, String modelName, double x, double y) {
        this.nrDoors = nrDoors;
        this.enginePower = enginePower;
        this.currentSpeed = currentSpeed;
        this.color = color;
        this.modelName = modelName;
        this.x = x;
        this.y = y;
        this.dir = dir.RIGHT;

        stopEngine();
    }

    /**
     * The cars moving  direction depending on its position and current speed.
     */

    @Override
    public void move() {
        switch (dir) {
            case UP:
                y -= currentSpeed;
                break;
            case DOWN:
                y += currentSpeed;
                break;
            case RIGHT:
                x += currentSpeed;
                break;
            case LEFT:
                x -= currentSpeed;
                break;
        }

    }

    /**
     * How the cars turn left depending on its moving direction.
     */

    @Override
    public  void turnLeft() {
        switch (dir) {
            case UP:
                dir = Direction.LEFT;
                break;
            case DOWN:
                dir = Direction.RIGHT;
                break;
            case LEFT:
                dir = Direction.DOWN;
                break;
            case RIGHT:
                dir = Direction.UP;
                break;
        }
    }

    /**
     * How the cars turn right depending on its moving direction.
     */

    @Override
    public void turnRight() {
        switch (dir) {
            case UP:
                dir = Direction.RIGHT;
                break;
            case DOWN:
                dir = Direction.LEFT;
                break;
            case LEFT:
                dir = Direction.UP;
                break;
            case RIGHT:
                dir = Direction.DOWN;
                break;

        }
    }

    /**
     * abstract method used by gas and break
     * @return speed factor
     */

    protected abstract double speedFactor();

    /**
     * starts the engine
     */

    public void startEngine() {
        currentSpeed = 0.1;
    }

    /**
     * stops the engine
     */

    public void stopEngine() {
        currentSpeed = 0;
    }

    /**
     * method to gas the car
     * @param amount speed factor
     */

    public void gas(double amount){
        if(amount >= 0 && amount <= 1)
            incrementSpeed(amount);
    }

    /**
     * method to brake the car
     * @param amount speed factor
     */

    public void brake(double amount){
        if(amount >= 0 && amount <= 1)
            decrementSpeed(amount);
    }

    /**
     * increments speed through gas
     * @param amount speed factor
     */

    private void incrementSpeed(double amount){
        currentSpeed = (Math.min(getCurrentSpeed() + speedFactor() * amount, getEnginePower()));
    }

    /**
     * decrements speed through brake
     * @param amount speed factor
     */

    private void decrementSpeed(double amount){
        currentSpeed = (Math.max(getCurrentSpeed() - speedFactor() * amount, 0));
    }


    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public Direction getDir() {
        return dir;
    }

    public double getEnginePower() {
        return enginePower;
    }

    public double getCurrentSpeed() {
        return currentSpeed;
    }
}