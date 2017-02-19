/*
    Josh Demusz
    CS 1632
    Deliverable 2
    2/19/17
 */

import org.junit.Assert;
import org.junit.Test;
import java.util.ArrayList;
import java.util.Random;

/**
 * Created by joshdemusz on 2/18/17.
 */
public class CarTest
{
    // *********************************** Tests for 'Car.java' ****************************************

    /*
    This is a simple test for the constructor method. It makes sure that the object created
        by the constructor is not null.
     */
    @Test
    public void testConstructor()
    {
        Car c = new Car(1);

        Assert.assertNotNull(c);
    }

    /* This test is for the moveCar() method in the Car class. This test makes sure that a the initial location for the
          car cannot be a 0 or a 5. This tests the "edge" cases for the 1-4 integer range the initial location should
          fall under.
    */
    @Test
    public void testGetInitialLocationEdgeCases()
    {
        Integer seed = new Integer(1);
        Random rand = new Random(seed);

        Car c = new Car(1);

        c.initializeLocation(rand);
        Assert.assertNotEquals(new Integer(0), c.initializeLocation(rand));
        Assert.assertNotEquals(new Integer(5), c.initializeLocation(rand));
    }

    /*
    This test is for the moveCar() method in the Car class. This test assumes that the last visited location is one of the 4 locations
        that are still inside the city. All of these locations are tested in this test, and they should all return values that are
        not null.
     */
    @Test
    public void testMoveCar()
    {
        Integer seed = new Integer(1);
        Random rand1 = new Random(seed);
        Random rand2 = new Random(seed);

        Car c = new Car(1);
        c.initializeLocation(rand1);

        Assert.assertNotNull(c.moveCar(1, rand2));
        Assert.assertNotNull(c.moveCar(2, rand2));
        Assert.assertNotNull(c.moveCar(3, rand2));
        Assert.assertNotNull(c.moveCar(4, rand2));
    }

    /*
    This test is for the moveCar() method in the Car class. This test assumes that the last visited location is outside the city.
         Since the simulation should be over at this point, the method should return null. Note: the simulation should not be able
         to reach this point.
    */
    @Test
    public void testMoveOutside()
    {
        Integer seed = new Integer(1);
        Random rand = new Random(seed);

        Car c = new Car(1);
        Assert.assertNull(c.moveCar(5, rand));
    }

    /*
     This test is for the 'checkSennott' method. This test makes sure that the method only returns true
        if the location passed in is Sennott.
     */
    @Test
    public void testCheckSennott()
    {
        Car c = new Car(1);

        // Sennott is location 3
        Assert.assertTrue(c.checkSennott(3));

        // The following locations (0-6) are NOT Sennott
        Assert.assertFalse(c.checkSennott(0));
        Assert.assertFalse(c.checkSennott(1));
        Assert.assertFalse(c.checkSennott(2));
        Assert.assertFalse(c.checkSennott(4));
        Assert.assertFalse(c.checkSennott(5));
        Assert.assertFalse(c.checkSennott(6));
    }

    /*
     This test tests the getter for the 'number' variable. It is similar to the test for the setter.
     */
    @Test
    public void testGetNumber()
    {
        Car c = new Car(1);

        c.setNumber(1);

        Assert.assertEquals(new Integer(1), c.getNumber());
    }

    /*
     This test tests the setter for the 'number' variable. It is similar to the test for the getter.
    */
    @Test
    public void testSetNumber()
    {
        Car c = new Car(1);

        c.setNumber(2);

        Assert.assertEquals(new Integer(2), c.getNumber());
    }

    /*
     This test tests the getter for the 'locations' variable. It is similar to the test for the setter.
    */
    @Test
    public void testGetLocation()
    {
        Car c = new Car(1);

        c.setLocation(1);

        Assert.assertEquals(new Integer(1), c.getLocation());
    }

    /*
     This test tests the setter for the 'location' variable. It is similar to the test for the getter.
    */
    @Test
    public void testSetLocation()
    {
        Car c = new Car(1);

        c.setLocation(2);

        Assert.assertEquals(new Integer(2), c.getLocation());
    }

    /*
     This test tests the getter for the 'locations' variable. It is similar to the test for the setter.
    */
    @Test
    public void testGetLocations()
    {
        Car c = new Car(1);

        ArrayList<Integer> locations = new ArrayList<Integer>();

        c.setLocations(locations);

        Assert.assertEquals(locations, c.getLocations());
    }

    /*
     This test tests the setter for the 'locations' variable. It is similar to the test for the getter.
    */
    @Test
    public void testSetLocations()
    {
        Car c = new Car(1);

        ArrayList<Integer> locations = new ArrayList<Integer>();

        c.setLocations(locations);

        Assert.assertEquals(locations, c.getLocations());
    }

    /*
     This test tests the getter for the 'num_sennott_visited' variable. It is similar to the test for the setter.
    */
    @Test
    public void testGetNumSennott()
    {
        Car c = new Car(1);

        c.setNum_sennott_visited(1);

        Assert.assertEquals(new Integer(1), c.getNum_sennott_visited());
    }

    /*
     This test tests the setter for the 'num_sennott_visited' variable. It is similar to the test for the getter.
    */
    @Test
    public void testSetNumSennott()
    {
        Car c = new Car(1);

        c.setNum_sennott_visited(3);

        Assert.assertEquals(new Integer(3), c.getNum_sennott_visited());
    }

    // *************************************************************************************************
}
