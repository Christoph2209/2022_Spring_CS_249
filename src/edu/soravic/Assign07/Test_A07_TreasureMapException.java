package edu.realemj.Assign07;
// NOTE: CHANGE realemj to YOUR SITNETID!!!
import org.testng.Assert;
import org.testng.annotations.Test;

public class Test_A07_TreasureMapException {

    @Test()
    public void test_Constructors() {
        // Create another Exception
        Exception e = new ArithmeticException("What bear is best?");

        // Create a TreasureMapException
        Exception se = new TreasureMapException("BEARS...BEES...BSG", e);

        // Check the message
        Assert.assertEquals(se.getMessage(), "BEARS...BEES...BSG");

        // Check the chained exception
        Assert.assertEquals(se.getCause(), e);

        // Create a TreasureMapException
        Exception anotherE = new TreasureMapException("Roll out the barrel...");

        // Check the message
        Assert.assertEquals(anotherE.getMessage(), "Roll out the barrel...");

        // Check the chained exception
        Assert.assertNull(anotherE.getCause());
    }

}
