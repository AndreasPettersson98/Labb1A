import java.awt.*;




public abstract class Car implements Movable {
    /**
     * Possible directions of the car
     */
    enum Direction{
        UP, DOWN, RIGHT, LEFT
    }

    /**
     * Instance variables
     */

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
     * Setters and Getters.
     */




    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public Direction getDir() {
        return dir;
    }

    public void setDir(Direction dir) {
        this.dir = dir;
    }


    public double getEnginePower() {
        return enginePower;
    }

    public double getCurrentSpeed() {
        return currentSpeed;
    }


    public void setCurrentSpeed(double currentSpeed) {
        this.currentSpeed = currentSpeed;
    }


    /**
     * The cars moving  direction depending on its position and current speed.
     */
    @Override
    public void move() {
        switch (dir) {
            case UP:
                setY(y - currentSpeed);
                break;
            case DOWN:
                setY(y + currentSpeed);
                break;
            case RIGHT:
                setX(x + currentSpeed);
                break;
            case LEFT:
                setX(x - currentSpeed);
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
                setDir(Direction.LEFT);
                break;
            case DOWN:
                setDir(Direction.RIGHT);
                break;
            case LEFT:
                setDir(Direction.DOWN);
                break;
            case RIGHT:
                setDir(Direction.UP);
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
                setDir(Direction.RIGHT);
                break;
            case DOWN:
                setDir(Direction.LEFT);
                break;
            case LEFT:
                setDir(Direction.UP);
                break;
            case RIGHT:
                setDir(Direction.DOWN);
                break;

        }
    }

    /**
     * Abstract method to be able to override the specific speedFactor methods from the sub classes
     */

    protected abstract double speedFactor();
    /**
     * Methods for starting and stopping the engine.
     */

    public void startEngine() {
        currentSpeed = 0.1;
    }

    public void stopEngine() {
        currentSpeed = 0;
    }

    /**
     * Methods to gas or break the car with the amount between 0 and 1
     */

    public void gas(double amount){
        if(amount >= 0 && amount <= 1)
            incrementSpeed(amount);
    }



    public void brake(double amount){
        if(amount >= 0 && amount <= 1)
            decrementSpeed(amount);
    }

    /**
     * Methods for incrementing and decrementing the speed which are helper methods to gas and break.
     */


    private void incrementSpeed(double amount){
        setCurrentSpeed(Math.min(getCurrentSpeed() + speedFactor() * amount, getEnginePower()));
    }

    private void decrementSpeed(double amount){
        setCurrentSpeed(Math.max(getCurrentSpeed() - speedFactor() * amount, 0));
    }


}