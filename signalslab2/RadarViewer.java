import java.util.Scanner;
import javax.swing.JFrame;
/**
 * Class that contains the main method for the program and creates the frame containing the component.
 * 
 * @author @Riley Wiest
 * @version 12/12/14
 */
public class RadarViewer
{
    /**
     * main method for the program which creates and configures the frame for the program
     *
     */
    public static void main(String[] args) throws InterruptedException
    {
        // create the radar, set the monster location, and perform the initial scan
        final int ROWS = 100;
        final int COLS = 100;
        //taking in user input on the locaation and slope of the monster
        Scanner in = new Scanner(System.in);
        System.out.println("What is the row of the monster's starting location(0-99): ");
        int monsterLocationRow = in.nextInt();
        System.out.println("What is the column of the monster's starting location(0-99): ");
        int monsterLocationCol = in.nextInt();
        System.out.println("What is monster's change in x coordinate(0-5): ");
        int changeX = in.nextInt();
        System.out.println("What is monster's change in y coordinate(0-5): ");
        int changeY = in.nextInt();
        
        Radar radar = new Radar(ROWS, COLS,monsterLocationRow,monsterLocationCol,changeY,changeX  );
        radar.setNoiseFraction(0.01);
        radar.scan();
        
        JFrame frame = new JFrame();
        
        frame.setTitle("Signals in Noise Lab");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // a frame contains a single component; create the radar component and add it to the frame
        RadarComponent component = new RadarComponent(radar);
        frame.add(component);
        
        // set the size of the frame to encompass the contained component
        frame.pack();
        
        // make the frame visible which will result in the paintComponent method being invoked on the
        //  component.
        frame.setVisible(true);
        
        // perform 100 scans of the radar wiht a slight pause between each
        // after each scan, instruct the Java Run-Time to redraw the window
        //int listOfSlopes[][] = new int[11][11];
        for(int i = 0; i < 120; i++)
        {
            Thread.sleep(100); // sleep 100 milliseconds (1/10 second)
            
            radar.scan();
            
            frame.repaint();
        }
        
        
        int [] finalArray = radar.finalSlopes();
        System.out.println(finalArray[0] + " " +finalArray[1] );
    }
}