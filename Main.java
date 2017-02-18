/**
 * Created by joshdemusz on 2/9/17.
 */
public class Main
{
    public static void main(String[] args)
    {
        //
        Simulation sim = new Simulation();

        Integer seed = sim.checkArgs(args);
        // If seed is null, input was invalid
        if(seed == null)
        {
            System.out.println("Please enter the correct arguments.");
            System.exit(0);
        }

        sim.run();

    }

}
