import java.util.ArrayList;
import java.util.Random;

/**
 * Created by joshdemusz on 2/9/17.
 */
public class Car
{
    private Integer number;
    /*
    Locations:
        1 - Presby
        2 - Union
        3 - Sennott
        4 - Hillman
        5 - Outside city
     */
    private Integer location;
    private ArrayList<Integer> locations;

    // Statistical data that needs to be collected from simulation
    private Integer num_sennott_visited;

    public Car(Integer num)
    {
        locations = new ArrayList<Integer>();

        setNumber(num);
        setNum_sennott_visited(0);
    }

    public Integer initializeLocation(Random rand)
    {
        Integer initial_location = rand.nextInt(4) + 1;

        // Set as current location
        setLocation(initial_location);

        // Add initial locatiton to list of locations
        getLocations().add(initial_location);

        return initial_location;
    }

    public Integer moveCar(Integer old_location, Random rand)
    {
        // Find a random new location based off of the old location of the car
        Integer location_boolean = rand.nextBoolean() ? 0 : 1;
        Integer new_location = null;

        if(old_location == 1)
        {
            if(location_boolean == 0)
            {
                new_location = 2;
            }
            else if(location_boolean == 1)
            {
                new_location = 3;
            }
        }
        else if(old_location == 2)
        {
            if(location_boolean == 0)
            {
                new_location = 4;
            }
            else if(location_boolean == 1)
            {
                new_location = 5;
            }
        }
        else if(old_location == 3)
        {
            if(location_boolean == 0)
            {
                new_location = 1;
            }
            else if(location_boolean == 1)
            {
                new_location = 5;
            }
        }
        else if(old_location == 4)
        {
            if(location_boolean == 0)
            {
                new_location = 2;
            }
            else if(location_boolean == 1)
            {
                new_location = 3;
            }
        }
        else
        {
            System.out.println("Error");
        }

        // Set current location to new location
        setLocation(new_location);

        // Add current location to visited locations
        getLocations().add(new_location);

        if(new_location == 3)
        {
            setNum_sennott_visited(getNum_sennott_visited() + 1);
        }

        return new_location;
    }

    public Integer getNumber()
    {
        return number;
    }

    public void setNumber(Integer number)
    {
        this.number = number;
    }

    public Integer getLocation()
    {
        return location;
    }

    public void setLocation(Integer location)
    {
        this.location = location;
    }

    public ArrayList<Integer> getLocations()
    {
        return locations;
    }

    public void setLocations(ArrayList<Integer> locations)
    {
        this.locations = locations;
    }

    public Integer getNum_sennott_visited()
    {
        return num_sennott_visited;
    }

    public void setNum_sennott_visited(Integer num_sennott_visited)
    {
        this.num_sennott_visited = num_sennott_visited;
    }
}
