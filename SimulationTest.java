import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.Random;

/**
 * Created by joshdemusz on 2/18/17.
 */
public class SimulationTest
{
    // ***************************** Tests for 'Simulation.java' ****************************************

    /*
    This test is for the checkArgs method. It makes sure that the method returns an integer value when
         an integer argument is passed in. It should NOT return null when an integer is passed in.
         This test uses a MOCK object.
    */
    @Test
    public void testIntegerArg()
    {
        Integer i = Mockito.mock(Integer.class);

        String args[] = new String[1];
        args[0] = new String(i.toString());

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

    // This test is for the run() method in Simulation class. This test makes sure the method runs to completion
    //      without any infinite loops
    @Test
    public void testRun()
    {
        String args[] = new String[1];
        args[0] = new String("1");

        Simulation sim = new Simulation();
        sim.checkArgs(args);

        Assert.assertTrue(sim.run());
    }

    // This test is for the simulateRoute() method in Simulation class. This test makes sure the method runs to completion
    //      without any infinite loops. This test uses a MOCK class.
    @Test
    public void testSimulateRoute()
    {
        Integer seed = 1;
        Random rand = new Random(seed);

        String args[] = new String[1];
        args[0] = new String("1");

        Simulation sim = new Simulation();
        sim.checkArgs(args);

        Car c = Mockito.mock(Car.class);

        Assert.assertTrue(sim.simulateRoute(c, rand));
    }

    /*
    This test makes sure that the method 'simulateRoute)' is called exactly
        5 times when the method 'run()' is called. This test uses STUBBING as well as MOCKS.
    */
    @Test
    public void testSimulateTimes()
    {
        String args[] = new String[1];
        args[0] = new String("1");

        Simulation sim = new Simulation();
        sim.checkArgs(args);

        Car c = Mockito.mock(Car.class);
        Random r = Mockito.mock(Random.class);

        Mockito.when(sim.simulateRoute(c, r)).thenReturn(true);
        sim.run();
        Mockito.verify(sim, Mockito.times(5)).simulateRoute(c, r);
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
    This test makes sure that the method 'printLaboonMessage(n)' is called exactly
        5 times when the method 'run()' is called. This test uses STUBBING.
     */
    @Test
    public void testPrintMessage5Times()
    {
        String args[] = new String[1];
        args[0] = new String("1");

        Simulation sim = new Simulation();
        sim.checkArgs(args);

        Mockito.when(sim.printLaboonMessage(0)).thenReturn(0);
        sim.run();
        Mockito.verify(sim, Mockito.times(5)).printLaboonMessage(0);
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

    // *************************************************************************************************

}
