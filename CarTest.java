import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.Random;

/**
 * Created by joshdemusz on 2/18/17.
 */
public class CarTest
{
    // *********************************** Tests for 'Car.java' ****************************************

    /* This test is for the moveCar() method in the Car class. This test makes sure that a the initial location for the
          car cannot be a 0 or a 5. This tests the "edge" cases for the 1-4 integer range the initial location should
          fall under. This method uses MOCK objects.
    */
    @Test
    public void testGetInitialLocationEdgeCases()
    {
        Integer seed = new Integer(1);
        Random rand = new Random(seed);

        Integer car_num = Mockito.mock(Integer.class);

        Car c = new Car(car_num);

        c.initializeLocation(rand);
        Assert.assertNotEquals(new Integer(0), c.initializeLocation(rand));
        Assert.assertNotEquals(new Integer(5), c.initializeLocation(rand));
    }

    /*
    This test is for the moveCar() method in the Car class. This test assumes that the last visited location is one of the 4 locations
        that are still inside the city. All of these locations are tested in this test, and they should all return values that are
        not null. This method uses MOCK objects.
     */
    @Test
    public void testMoveCar()
    {
        //Integer seed = new Integer(1);
        Integer seed = Mockito.mock(Integer.class);
        Random rand1 = new Random(seed);
        Random rand2 = new Random(seed);

        Integer car_num = Mockito.mock(Integer.class);

        Car c = new Car(car_num);
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
        Integer car_num = Mockito.mock(Integer.class);

        Car c = new Car(car_num);

        Assert.assertTrue(c.checkSennott(3));

        Assert.assertFalse(c.checkSennott(0));
        Assert.assertFalse(c.checkSennott(1));
        Assert.assertFalse(c.checkSennott(2));
        Assert.assertFalse(c.checkSennott(4));
        Assert.assertFalse(c.checkSennott(5));
        Assert.assertFalse(c.checkSennott(6));
    }
    // *************************************************************************************************
}
