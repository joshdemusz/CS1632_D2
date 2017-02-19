/*
    Josh Demusz
    CS 1632
    Deliverable 2
    2/19/17
 */

public final class LocationUtility
{
    // Make sure that this class cannot be instantiated.
    private LocationUtility()
    {

    }

    /*
    Locations:
        1 - Presby
        2 - Union
        3 - Sennott
        4 - Hillman
        5 - Outside city
    */
    public static String getStreet(Integer start, Integer end)
    {
        String street = null;

        // Returns a street String based on the start and end locations which are passed in.
        if(start == 1 && end == 2)
        {
            street = new String("Fourth Ave.");
        }
        else if(start == 1 && end == 3)
        {
            street = new String("Bill St.");
        }
        else if(start == 2 && end == 5)
        {
            street = new String("Fourth Ave.");
        }
        else if(start == 2 && end == 4)
        {
            street = new String("Phil St.");
        }
        else if(start == 3 && end == 5)
        {
            street = new String("Fifth Ave.");
        }
        else if(start == 3 && end == 1)
        {
            street = new String("Bill St.");
        }
        else if(start == 4 && end == 3)
        {
            street = new String("Fifth Ave.");
        }
        else if(start == 4 && end == 2)
        {
            street = new String("Phil St.");
        }

        return street;
    }

    public static String getLocation(Integer num)
    {
        String location = null;

        // Returns a location String based on which location number is passed in
        if(num.equals(1))
        {
            location = new String("Presby");
        }
        else if(num.equals(2))
        {
            location = new String("Union");
        }
        else if(num.equals(3))
        {
            location = new String("Sennott");
        }
        else if(num.equals(4))
        {
            location = new String("Hillman");
        }

        return location;
    }

    public static String getOutsideLocation(Integer last_visited)
    {
        String outside_location = null;

        // If car exited the city, determine where it is going based on the previous locaiton visited
        if(last_visited.equals(2))
        {
            outside_location = new String("Philadelphia");
        }
        else if(last_visited.equals(3))
        {
            outside_location = new String("Cleveland");
        }

        return outside_location;
    }
}
