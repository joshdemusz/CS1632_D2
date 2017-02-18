import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.*;

/**
 * Created by joshdemusz on 2/9/17.
 */
public class TestRunner
{
    // ***************************** Tests for 'Simulation.java' ****************************************
    @Test
    public void testIntegerArg()
    {
        String args[] = new String[1];
        args[0] = new String("1");

        Simulation sim = new Simulation();

        assertNotNull(sim.checkArgs(args));
    }

    @Test
    public void testDoubleArg()
    {
        String args[] = new String[1];
        args[0] = new String("1.5");

        Simulation sim = new Simulation();

        assertNull(sim.checkArgs(args));
    }

    @Test
    public void testStringArg()
    {
        String args[] = new String[1];
        args[0] = new String("string");

        Simulation sim = new Simulation();

        assertNull(sim.checkArgs(args));
    }

    @Test
    public void testMultipleArg()
    {
        String args[] = new String[2];
        args[0] = new String("1");
        args[1] = new String("2");

        Simulation sim = new Simulation();

        assertNull(sim.checkArgs(args));
    }

    @Test
    public void testNoArg()
    {
        String args[] = new String[0];

        Simulation sim = new Simulation();

        assertNull(sim.checkArgs(args));
    }

    @Test
    public void testNegativeArg()
    {

    }

    // This test is for the run() method in Simulation class. This test makes sure the method runs to completion
    //      without any infinite loops
    @Test
    public void testRun()
    {
        String args[] = new String[1];
        args[0] = new String("1");

        Simulation sim = new Simulation();
        sim.checkArgs(args);

        assertTrue(sim.run());
    }

    // This test is for the simulateRoute() method in Simulation class. This test makes sure the method runs to completion
    //      without any infinite loops
    @Test
    public void testSimulateRoute()
    {
        Integer seed = 1;
        Random rand = new Random(seed);

        String args[] = new String[1];
        args[0] = new String("1");

        Simulation sim = new Simulation();
        sim.checkArgs(args);

        Car c = new Car(1);

        assertTrue(sim.simulateRoute(c, rand));
    }

    @Test
    public void testLaboonMessage0()
    {
        String args[] = new String[1];
        args[0] = new String("1");

        Simulation sim = new Simulation();
        sim.checkArgs(args);

        assertEquals(new Integer(0), sim.printLaboonMessage(0));
    }

    @Test
    public void testLaboonMessage3()
    {
        String args[] = new String[1];
        args[0] = new String("1");

        Simulation sim = new Simulation();
        sim.checkArgs(args);

        assertEquals(new Integer(3), sim.printLaboonMessage(3));
    }

    @Test
    public void testLaboonMessageOther()
    {
        String args[] = new String[1];
        args[0] = new String("1");

        Simulation sim = new Simulation();
        sim.checkArgs(args);

        assertNull(sim.printLaboonMessage(1));
    }

    // *************************************************************************************************

    // *********************************** Tests for 'Car.java' ****************************************

    // This test is for the moveCar() method in the Car class. This test makes sure that a the initial location for the
    //      car cannot be a 0 or a 5. This tests the "edge" cases for the 1-4 integer range the initial location should
    //      fall under.
    @Test
    public void testGetInitialLocationEdgeCases()
    {
        Integer seed = new Integer(1);
        Random rand = new Random(seed);

        Car c = new Car(1);

        c.initializeLocation(rand);
        assertNotEquals(new Integer(0), c.initializeLocation(rand));
        assertNotEquals(new Integer(5), c.initializeLocation(rand));
    }

    // This test is for the moveCar() method in the Car class. This test assumes that the last visited location is one of the 4 locations
    //      that are still inside the city. All of these locations are tested in this test, and they should all return values that are
    //      not null.
    @Test
    public void testMoveCar()
    {
        Integer seed = new Integer(1);
        Random rand1 = new Random(seed);
        Random rand2 = new Random(seed);

        Car c = new Car(1);
        c.initializeLocation(rand1);

        assertNotNull(c.moveCar(1, rand2));
        assertNotNull(c.moveCar(2, rand2));
        assertNotNull(c.moveCar(3, rand2));
        assertNotNull(c.moveCar(4, rand2));
    }

    // This test is for the moveCar() method in the Car class. This test assumes that the last visited location is outside the city.
    //   Since the simulation should be over at this point, the method should return null. Note: the simulation should not be able
    //   to reach this point.
    @Test
    public void testMoveOutside()
    {
        Integer seed = new Integer(1);
        Random rand = new Random(seed);

        Car c = new Car(1);
        assertNull(c.moveCar(5, rand));
    }
    // *************************************************************************************************

    // ***************************** Tests for 'LocationUtility.java' **********************************
    @Test
    public void testGetStreet()
    {
        assertNotNull(LocationUtility.getStreet(1, 2));
    }

    @Test
    public void testGetStreetBad()
    {
        assertNull(LocationUtility.getStreet(5, 1));
    }

    @Test
    public void testGetPresby()
    {
        assertEquals("Presby", LocationUtility.getLocation(1));
    }

    @Test
    public void testGetUnion()
    {
        assertEquals("Union", LocationUtility.getLocation(2));
    }

    @Test
    public void testGetSennott()
    {
        assertEquals("Sennott", LocationUtility.getLocation(3));
    }

    @Test
    public void testGetHillman()
    {
        assertEquals("Hillman", LocationUtility.getLocation(4));
    }

    @Test
    public void testToPhiladelphia()
    {
        assertEquals("Philadelphia", LocationUtility.getOutsideLocation(2));
    }

    @Test
    public void testToCleveland()
    {
        assertEquals("Cleveland", LocationUtility.getOutsideLocation(3));
    }
    // *************************************************************************************************
}
