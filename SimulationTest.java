/*
    Josh Demusz
    CS 1632
    Deliverable 2
    2/19/17
 */

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;
import java.util.Random;

public class SimulationTest
{
    // ***************************** Tests for 'Simulation.java' ****************************************

    /*
    This is a simple test for the constructor method. It makes sure that the object created
        by the constructor is not null.
     */
    @Test
    public void testConstructor()
    {
        Simulation s = new Simulation();

        Assert.assertNotNull(s);
    }

    /*
    This test is for the checkArgs method. It makes sure that the method returns an integer value when
         an integer argument is passed in. It should NOT return null when an integer is passed in.
    */
    @Test
    public void testIntegerArg()
    {
        String args[] = new String[1];
        args[0] = new String("1");

        Simulation sim = new Simulation();

        Assert.assertNotNull(sim.checkArgs(args));
    }

    /*
    This test is for the checkArgs method. It makes sure that the method returns NULL if a double
         argument is passed in.
    */
    @Test
    public void testDoubleArg()
    {
        String args[] = new String[1];
        args[0] = new String("1.5");

        Simulation sim = new Simulation();

        Assert.assertNull(sim.checkArgs(args));
    }

    /*
    This test is for the checkArgs method. It makes sure that the method returns NULL if a String
        argument is passed in.
    */
    @Test
    public void testStringArg()
    {
        String args[] = new String[1];
        args[0] = new String("string");

        Simulation sim = new Simulation();

        Assert.assertNull(sim.checkArgs(args));
    }

    /*
    This test is for the checkArgs method. It makes sure that the method returns NULL if more than one
        argument is passed in, regardless of type.
    */
    @Test
    public void testMultipleArg()
    {
        String args[] = new String[2];
        args[0] = new String("1");
        args[1] = new String("2");

        Simulation sim = new Simulation();

        Assert.assertNull(sim.checkArgs(args));
    }

    /*
     This test is for the checkArgs method. It makes sure that the method returns NULL if no
         argument is passed in.
     */
    @Test
    public void testNoArg()
    {
        String args[] = new String[0];

        Simulation sim = new Simulation();

        Assert.assertNull(sim.checkArgs(args));
    }

    /* This test is for the run() method in Simulation class. This test makes sure the method runs to completion
          without any infinite loops
    */
    @Test
    public void testRun()
    {
        String args[] = new String[1];
        args[0] = new String("1");

        Simulation sim = new Simulation();
        sim.checkArgs(args);

        Assert.assertTrue(sim.run());
    }

    /* This test is for the simulateRoute() method in Simulation class. This test makes sure the method runs to completion
          without any infinite loops. This test uses a MOCK class.
    */
    @Test
    public void testSimulateRoute()
    {
        Integer seed = 1;
        Random r1 = new Random(seed);
        Random r2 = new Random(seed);

        String args[] = new String[1];
        args[0] = new String("1");

        Simulation sim = new Simulation();
        sim.checkArgs(args);

        Car c = new Car(1);
        c.initializeLocation(r2);

        boolean b = sim.simulateRoute(c, r1);

        Assert.assertTrue(b);
    }

    /*
    This test is for the method 'printLaboonMessage'. It makes sure that the correct String is returned
        when a car visited Sennott 0 times.
     */
    @Test
    public void testLaboonMessage0()
    {
        String args[] = new String[1];
        args[0] = new String("1");

        Simulation sim = new Simulation();
        sim.checkArgs(args);

        Assert.assertEquals(new Integer(0), sim.printLaboonMessage(0));
    }

    /*
     This test is for the method 'printLaboonMessage'. It makes sure that the correct String is returned
         when a car visited Sennott 3 times.
    */
    @Test
    public void testLaboonMessage3()
    {
        String args[] = new String[1];
        args[0] = new String("1");

        Simulation sim = new Simulation();
        sim.checkArgs(args);

        Assert.assertEquals(new Integer(3), sim.printLaboonMessage(3));
    }

    /*
     This test is for the method 'printLaboonMessage'. It makes sure that the correct String is returned
         when a car visited Sennott between 0 and 3 times.
    */
    @Test
    public void testLaboonMessageOther()
    {
        String args[] = new String[1];
        args[0] = new String("1");

        Simulation sim = new Simulation();
        sim.checkArgs(args);

        Assert.assertNull(sim.printLaboonMessage(1));
    }

    /*
    This test makes sure that the Simulation class only initializes a Car object's location once.
        It uses MOCK objects as well as STUBBING.
     */
    @Test
    public void testInitializeLocation()
    {
        String args[] = new String[1];
        args[0] = new String("1");

        Simulation sim = new Simulation();
        sim.checkArgs(args);

        Car c = Mockito.mock(Car.class);
        Random r = Mockito.mock(Random.class);

        Mockito.when(c.initializeLocation(r)).thenReturn(0);
        sim.initializeLocation(c, r);
        Mockito.verify(c, Mockito.times(1)).initializeLocation(r);
    }

    /*
    This test makes sure that the Simulation class only allows for one movement of the car at a time.
        It uses MOCK objects as well as STUBBING.
    */
    @Test
    public void testLeastMove()
    {
        String args[] = new String[1];
        args[0] = new String("1");

        Simulation sim = new Simulation();
        sim.checkArgs(args);

        Car c = Mockito.mock(Car.class);
        Random r = new Random(1);

        // Make sure moveCar in Car class is only called once each time
        Mockito.when(c.moveCar(0, r)).thenReturn(0);
        sim.moveCar(c, r);
        Mockito.verify(c, Mockito.times(1)).moveCar(0, r);
    }

    /*
    This test makes sure that the Simulation class successfully executes the 'moveCar' method.
        It uses MOCK objects as well as STUBBING.
    */
    @Test
    public void testCarMove()
    {
        String args[] = new String[1];
        args[0] = new String("1");

        Simulation sim = new Simulation();
        sim.checkArgs(args);

        Car c = Mockito.mock(Car.class);
        Random r = new Random(1);

        // Make sure moveCar in Car class is called
        Mockito.when(c.moveCar(0, r)).thenReturn(0);
        sim.moveCar(c, r);
        Assert.assertEquals(new Integer(0), c.moveCar(0, r));
    }

    @Test
    public void testGetSeed()
    {
        Simulation s = new Simulation();

        s.setSeed(1);

        Assert.assertEquals(new Integer(1), s.getSeed());
    }

    @Test
    public void testSetSeed()
    {
        Simulation s = new Simulation();

        s.setSeed(2);

        Assert.assertEquals(new Integer(2), s.getSeed());
    }

    // *************************************************************************************************

}
