import org.junit.Assert;
import org.junit.Test;

/**
 * Created by joshdemusz on 2/18/17.
 */
public class LocationUtilityTest
{
    // ***************************** Tests for 'LocationUtility.java' **********************************

    /*
    This method tests the 'getStreet' method. It makes sure that the method does NOT return a null
        value when the arguments (locations) passed in are connected by a street in the correct
        direction.
     */
    @Test
    public void testGetStreet()
    {
        Assert.assertNotNull(LocationUtility.getStreet(1, 2));
    }

    /*
    This method tests the 'getStreet' method. It makes sure that the method does return a null
        value when the arguments (locations) passed in are NOT connected by a street in the correct
        direction.
     */
    @Test
    public void testGetStreetBad()
    {
        Assert.assertNull(LocationUtility.getStreet(5, 1));
    }

    /*
    This method tests the 'getLocation' method for the 'Presby' location. It makes sure that the method
        returns the correct String value given the input.
     */
    @Test
    public void testGetPresby()
    {
        Assert.assertEquals("Presby", LocationUtility.getLocation(1));
    }

    /*
    This method tests the 'getLocation' method for the 'Union' location. It makes sure that the method
        returns the correct String value given the input.
     */
    @Test
    public void testGetUnion()
    {
        Assert.assertEquals("Union", LocationUtility.getLocation(2));
    }

    /*
    This method tests the 'getLocation' method for the 'Sennott' location. It makes sure that the method
        returns the correct String value given the input.
     */
    @Test
    public void testGetSennott()
    {
        Assert.assertEquals("Sennott", LocationUtility.getLocation(3));
    }

    /*
    This method tests the 'getLocation' method for the 'Hillman' location. It makes sure that the method
        returns the correct String value given the input.
     */
    @Test
    public void testGetHillman()
    {
        Assert.assertEquals("Hillman", LocationUtility.getLocation(4));
    }

    /*
    This method tests the 'getOutsideLocation' method for the 'Philadelphia' location. It makes sure that the method
        returns the correct String value given the input.
     */
    @Test
    public void testToPhiladelphia()
    {
        Assert.assertEquals("Philadelphia", LocationUtility.getOutsideLocation(2));
    }

    /*
     This method tests the 'getOutsideLocation' method for the 'Cleveland' location. It makes sure that the method
         returns the correct String value given the input.
      */
    @Test
    public void testToCleveland()
    {
        Assert.assertEquals("Cleveland", LocationUtility.getOutsideLocation(3));
    }
    // *************************************************************************************************
}
