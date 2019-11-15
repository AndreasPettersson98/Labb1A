import org.junit.Test;

import static org.junit.Assert.*;

public class CarTest {

    @Test
    public void testTurnRightSaab() {
        //Original direction set to right!
        Saab95 saab = new Saab95(0,2,2);

        saab.turnRight();
        assertTrue(saab.getDir() == Car.Direction.DOWN);
        saab.turnRight();
        assertTrue(saab.getDir() == Car.Direction.LEFT);
        saab.turnRight();
        assertTrue(saab.getDir() == Car.Direction.UP);
        saab.turnRight();
        assertTrue(saab.getDir() == Car.Direction.RIGHT);
    }


    @Test
    public void testTurnLeftSaab() {
        //Original direction set to right!
        Saab95 saab = new Saab95(0,2,2);

        saab.turnLeft();
        assertTrue(saab.getDir() == Car.Direction.UP);
        saab.turnLeft();
        assertTrue(saab.getDir() == Car.Direction.LEFT);
        saab.turnLeft();
        assertTrue(saab.getDir() == Car.Direction.DOWN);
        saab.turnLeft();
        assertTrue(saab.getDir() == Car.Direction.RIGHT);

    }

    @Test
    public void testTurnRightVolvo() {
        //Original direction set to right!
        Volvo240 volvo = new Volvo240(0,2,2);

        volvo.turnRight();
        assertTrue(volvo.getDir() == Car.Direction.DOWN);
        volvo.turnRight();
        assertTrue(volvo.getDir() == Car.Direction.LEFT);
        volvo.turnRight();
        assertTrue(volvo.getDir() == Car.Direction.UP);
        volvo.turnRight();
        assertTrue(volvo.getDir() == Car.Direction.RIGHT);
    }


    @Test
    public void testTurnLeftVolvo() {
       //Original direction set to right!
        Volvo240 volvo = new Volvo240(0,2,2);

        volvo.turnLeft();
        assertTrue(volvo.getDir() == Car.Direction.UP);
        volvo.turnLeft();
        assertTrue(volvo.getDir() == Car.Direction.LEFT);
        volvo.turnLeft();
        assertTrue(volvo.getDir() == Car.Direction.DOWN);
        volvo.turnLeft();
        assertTrue(volvo.getDir() == Car.Direction.RIGHT);

    }


     @Test
    public void testMoveVolvo() {
        Volvo240 volvo = new Volvo240(5,10,10);
        volvo.move();
        assertEquals(15,volvo.getX(),0);
        volvo.turnLeft();
        volvo.move();
        assertEquals(5,volvo.getY(),0);
        volvo.turnLeft();
        volvo.move();
        assertEquals(10, volvo.getX(), 0);
        volvo.turnLeft();
        volvo.move();
        assertEquals(10, volvo.getY(),0);
    }
    @Test
    public void testMoveSaab() {
        Saab95 saab = new Saab95(5,10,10);
        saab.move();
        assertEquals(15,saab.getX(),0);
        saab.turnLeft();
        saab.move();
        assertEquals(5,saab.getY(),0);
        saab.turnLeft();
        saab.move();
        assertEquals(10, saab.getX(), 0);
        saab.turnLeft();
        saab.move();
        assertEquals(10, saab.getY(),0);
    }


    @Test
    public void testGasVolvo() {
        Volvo240 volvo = new Volvo240(0,2,2);
        volvo.gas(-1);
        assertEquals(0,volvo.getCurrentSpeed(),0);
        volvo.gas(2);
        assertEquals(0, volvo.getCurrentSpeed(), 0);
        volvo.gas(0.7);
        assertEquals(0.875, volvo.getCurrentSpeed(),0);

    }
    @Test
    public void testGasSaab() {
        Saab95 saab = new Saab95(0,2,2);
        saab.setTurboOn();
        saab.gas(-1);
        assertEquals(0,saab.getCurrentSpeed(),0);
        saab.gas(2);
        assertEquals(0, saab.getCurrentSpeed(), 0);
        saab.gas(0.7);
        assertEquals(1.1375, saab.getCurrentSpeed(),0);

    }

    @Test
    public void testBrakeVolvo() {
        Volvo240 volvo = new Volvo240(10,2,2);
        volvo.brake(-1);
        assertEquals(10, volvo.getCurrentSpeed(),0);
        volvo.brake(2);
        assertEquals(10, volvo.getCurrentSpeed(),0);
        volvo.brake(1);
        assertEquals(8.75, volvo.getCurrentSpeed(),0);
        volvo.brake(0.3);
        assertEquals(8.375, volvo.getCurrentSpeed(),0);
    }

    @Test
    public void testBrakeSaab() {
        Saab95 saab = new Saab95(10,2,2);
        saab.setTurboOn();
        saab.brake(-1);
        assertEquals(10, saab.getCurrentSpeed(),0);
        saab.brake(2);
        assertEquals(10, saab.getCurrentSpeed(),0);
        saab.brake(1);
        assertEquals(8.375, saab.getCurrentSpeed(),0);
        saab.brake(0.3);
        assertEquals(7.8875, saab.getCurrentSpeed(),0);
    }


    @Test
    public void speedFactor() {
        Volvo240 volvo = new Volvo240(0,0,0);
        volvo.speedFactor();
        assertEquals(1.25,volvo.speedFactor(),0);

    }

    @Test
    public void testStartEngine() {
        Saab95 saab = new Saab95(0,0,0);
        saab.startEngine();
        assertEquals(0.1,saab.getCurrentSpeed(),0);
    }

    @Test
    public void testStopEngine() {
        Saab95 saab = new Saab95(0,0,0);
        saab.startEngine();
        saab.stopEngine();
        assertEquals(0,saab.getCurrentSpeed(),0);
    }
}