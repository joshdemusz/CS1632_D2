/**
 * Created by joshdemusz on 2/18/17.
 */
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import java.util.ArrayList;

public class TestRunner
{
    public static void main(String[] args)
    {
        ArrayList<Class> classesToTest = new ArrayList<Class>();
        boolean anyFailures = false;

        classesToTest.add(CarTest.class);
        classesToTest.add(SimulationTest.class);
        classesToTest.add(LocationUtilityTest.class);

        // Loop through the test files for each class
        for (Class c: classesToTest)
        {
            Result r = JUnitCore.runClasses(c);

            // Print any failures for the currect class
            for (Failure f : r.getFailures())
            {
                System.out.println(f.toString());
            }

            // If r is not successful, there was at least 1 failure
            if (!r.wasSuccessful())
            {
                anyFailures = true;
            }
        }

        // Notify the user if any tests failed, or if all the tests were passed
        if (anyFailures)
        {
            System.out.println("\n!!! - At least one failure, see above.");
        }
        else
        {
            System.out.println("\nALL TESTS PASSED");
        }
    }
}