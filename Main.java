/*
    Josh Demusz
    CS 1632
    Deliverable 2
    2/19/17
 */

public class Main
{
    public static void main(String[] args)
    {
        // Create a simulation object
        Simulation sim = new Simulation();

        Integer seed = sim.checkArgs(args);
        // If seed is null, input was invalid
        if(seed == null)
        {
            System.out.println("Please enter the correct arguments.");
            System.exit(0);
        }

        // Run the simulation
        sim.run();

    }

}
