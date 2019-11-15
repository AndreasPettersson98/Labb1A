import org.junit.Test;

import static org.junit.Assert.*;

public class Saab95Test {

    @Test
    public void TestSetTurboOn() {
        Saab95 saab = new Saab95(0,0,0);
        saab.setTurboOn();
        assertTrue(saab.turboOn);
    }

    @Test
    public void testSetTurboOff() {
        Saab95 saab = new Saab95(0,0,0);
        saab.setTurboOff();
        assertFalse(saab.turboOn);
    }
}