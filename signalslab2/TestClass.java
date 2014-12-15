import java.util.Scanner;
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Write a description of test class TestClass here.
 * 
 * @author Riley Wiest 
 * @version 12/15/14
 */
public class TestClass
{
    /** description of instance variable x (add comment for each instance variable) */
    
    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }

    
    public TestClass()
    // constructor for the test class
    {
    }
    
    @Test
    public void TestRadar1()
    {
        Radar radar = new Radar(100,100,0,0,1,1);
                for(int i = 0; i < 120; i++)
        {
            radar.scan(); 
        }
        int[] finalSlope = radar.finalSlopes();
        assertEquals(1, finalSlope[0]);
        assertEquals(1, finalSlope[1]);
    }
    
    @Test
    public void TestRadar2()
    {
        Radar radar = new Radar(100,100,17,15,2,2);
        for(int i = 0; i < 120; i++)
        {
            radar.scan();
        }
        int[] finalSlope = radar.finalSlopes();
        assertEquals(2, finalSlope[0]);
        assertEquals(2, finalSlope[1]);
    }
}
