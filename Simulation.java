import java.util.ArrayList;
import java.util.Random;

/**
 * Created by joshdemusz on 2/9/17.
 */
public class Simulation
{
    private Integer seed;

    public Simulation()
    {
    }

    public boolean run()
    {
        ArrayList<Car> cars = new ArrayList<Car>();

        Random rand_initial = new Random(seed);
        Random rand_route = new Random(seed);

        // Iterate through 5 drivers
        for(int i = 0; i < 5; i++)
        {
            // Initialize car
            Car curr = new Car(i+1);

            // Initialize driver location
            curr.initializeLocation(rand_initial);

            // Simulate the driver's path
            simulateRoute(curr, rand_route);

            cars.add(curr);
        }

        // Print the paths for each car
        for(int i = 0; i < 5; i++)
        {
            Car curr = cars.get(i);

            //System.out.println(curr.getLocations().toString());

            // Cycle through path of each car. Print out each movement.
            for(int j = 1; j < curr.getLocations().size(); j++)
            {
                Integer start_location_num = curr.getLocations().get(j-1);
                Integer end_location_num = curr.getLocations().get(j);

                //System.out.println("start "+start_location_num);
                //System.out.println("end "+end_location_num);

                String street = LocationUtility.getStreet(start_location_num, end_location_num);
                String start_location;
                String end_location;

                start_location = LocationUtility.getLocation(start_location_num);

                if(end_location_num == 5)
                {
                    end_location = LocationUtility.getOutsideLocation(curr.getLocations().get(j-1));
                }
                else
                {
                    end_location = LocationUtility.getLocation(end_location_num);
                }

                System.out.println("Driver "+ curr.getNumber()+" heading from "+start_location+" to "+end_location+" via "+street);
            }

            // Print out number of times the car visited Sennott
            System.out.println("Driver "+curr.getNumber()+" met with Professor Laboon "+curr.getNum_sennott_visited()+" time(s).");

            // Prints a message based on how many times the student went to Laboon for help
            printLaboonMessage(curr.getNum_sennott_visited());

            System.out.print("-----\n");
        }

        return true;
    }

    public boolean simulateRoute(Car c, Random rand)
    {
        while(c.moveCar(c.getLocation(), rand) != 5)
        {
            //System.out.println(c.getLocation());
        };

        return true;
    }

    public Integer checkArgs(String[] args)
    {
        Integer seed = null;

        // If there is only one argument and it is an integer
        if(args.length == 1 && args[0].matches("^-?\\d+$"))
        {
            seed = Integer.parseInt(args[0]);
            setSeed(seed);
        }

        return seed;
    }


    public Integer printLaboonMessage(Integer n)
    {
        Integer r = null;

        if(n == 0)
        {
            System.out.println("That student missed out!");
            r = new Integer(0);
        }
        else if(n >= 3)
        {
            System.out.println("Wow, that driver needed lots of CS help!");
            r = new Integer(3);
        }

        return r;
    }

    public Integer getSeed()
    {
        return seed;
    }

    public void setSeed(Integer seed)
    {
        this.seed = seed;
    }
}
