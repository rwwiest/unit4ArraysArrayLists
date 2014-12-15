import java.util.Scanner;
import java.util.ArrayList;
/**
 * The model for radar scan and accumulator
 * 
 * @author @Riley Wiest
 * @version 12/12/14
 */
public class Radar
{
    
    // stores whether each cell triggered detection for the current scan of the radar
    private boolean[][] currentScan;
    
    // value of each cell is incremented for each scan in which that cell triggers detection 
    private int[][] accumulator;
    
    // location of the monster
    private int monsterLocationRow;
    private int monsterLocationCol;

    // probability that a cell will trigger a false detection (must be >= 0 and < 1)
    private double noiseFraction;
    
    // number of scans of the radar since construction
    private int numScans;
    
    // creating the slope of monster
    private int changeX;
    private int changeY;
    // instance variables needed to search for the monster
    private int dY;
    private int dX;
    //making instance variables for these lists
    public ArrayList<int[]> pastAlivePoints=new ArrayList<int[]>();
    public ArrayList<int[]> currentAlivePoints=new ArrayList<int[]>();
    //public ArrayList<int[]> slopesThatMeetCondition=new ArrayList<int[]>();
    public int slopesThatMeetCondition[][] = new int[11][11];
    
    
    // initializing the Scan() method counter
    int count= 0;
    /**
     * Constructor for objects of class Radar
     * 
     * @param   rows    the number of rows in the radar grid
     * @param   cols    the number of columns in the radar grid
     */
    public Radar(int rows, int cols, int monsterLocationRow1 , int monsterLocationCol1 ,  int changeY1, int changeX1)
    {
        // initialize instance variables
        currentScan = new boolean[rows][cols]; // elements will be set to false
        accumulator = new int[rows][cols]; // elements will be set to 0
        
        monsterLocationRow = monsterLocationRow1;
        monsterLocationCol = monsterLocationCol1;
        changeY = changeY1;
        changeX = changeX1;
        noiseFraction = 0.01;
        numScans= 0;
    }
    
    public int[] finalSlopes()
    /**
     * This prints out the change in Y and the change in X
     * 
     * return: returns an array containing change in y and change in x as its elements
     */
    {
        System.out.println("Length of the list: " + slopesThatMeetCondition.length);
        int largestIndexI=0;
        int largestIndexJ= 0;
        int largestNumber= 0;
        for (int i = 0; i < 11; i++)
        {
            for (int j = 0; j < 11; j++)
            {
                if (slopesThatMeetCondition[i][j] > largestNumber)
                {
                    largestNumber = slopesThatMeetCondition[i][j];
                    largestIndexI= i;
                    largestIndexJ= j;
                }
            }
        }
        System.out.println("dY: " + (largestIndexI-5));
        System.out.println("dX: " + (largestIndexJ-5));
        int[] returnArray = {largestIndexI-5,largestIndexJ-5};
        return returnArray;
    }
    /**
     * Performs a scan of the radar. Noise is injected into the grid and the accumulator is updated.
     * 
     * 
     */
    public void scan()
    {
        // zero the current scan grid
        for(int row = 0; row < currentScan.length; row++)
        {
            for(int col = 0; col < currentScan[0].length; col++)
            {
                currentScan[row][col] = false;
            }
        }
        
        
        
        
        // detect the monster
        //currentScan[monsterLocationRow][monsterLocationCol] = true;
        
        
        // inject noise into the grid
        injectNoise();
        //added all the alive points (row,col) to an arrayList
        if (count == 0)
        {
            //ArrayList<int[]> pastAlivePoints=new ArrayList<int[]>();
            for(int row = 0; row < currentScan.length; row++)
            {
                for(int col = 0; col < currentScan[0].length; col++)
                {
                    if(currentScan[row][col] == true)
                    {
                        pastAlivePoints.add(new int[] {row,col});
                        //System.out.println(pastAlivePoints.size());
                    }
                }
            }
            //System.out.println(pastAlivePoints.size() + " first");
        }
        //System.out.println("Between the action");
        
        if (count !=0)
        {
            //System.out.println(pastAlivePoints.size() + " Past");
            ArrayList<int[]> currentAlivePoints=new ArrayList<int[]>();
            for(int row = 0; row < currentScan.length; row++)
            {
                for(int col = 0; col < currentScan[0].length; col++)
                {
                    if(currentScan[row][col] == true)
                    {
                        currentAlivePoints.add(new int[] {row,col});
                        //System.out.println(currentAlivePoints.size());
                    }
                }
            }
            //System.out.println(currentAlivePoints.size() + " Current");
            for(int i = 0; i < pastAlivePoints.size(); i++)
            {
                for (int j = 0; j < currentAlivePoints.size(); j++)
                {
                    int dY= (currentAlivePoints.get(j)[0] - pastAlivePoints.get(i)[0]);
                    int dX= (currentAlivePoints.get(j)[1] - pastAlivePoints.get(i)[1]);
                    //System.out.println("This occurs");
                    if ((dY > -5 && dY <5) && (dX > -5 && dX < 5))
                    {
                        slopesThatMeetCondition[dY+5][dX+5] ++;
                        //System.out.println("This actually works");
                        slopesThatMeetCondition[dY+5][dX+5] ++;
                    }
                }
            }
            pastAlivePoints = currentAlivePoints;
        }
        
        // udpate the accumulator
        for(int row = 0; row < currentScan.length; row++)
        {
            for(int col = 0; col < currentScan[0].length; col++)
            {
                if(currentScan[row][col] == true)
                {
                   accumulator[row][col]++;
                }
            }
        }
        
        // keep track of the total number of scans
        count ++;
        numScans++;
        //return slopesThatMeetCondition;
    }

    /**
     * Sets the location of the monster
     * 
     * @param   row     the row in which the monster is located
     * @param   col     the column in which the monster is located
     * @pre row and col must be within the bounds of the radar grid
     */
    public void setMonsterLocation(int row, int col)
    {
        // remember the row and col of the monster's location
        monsterLocationRow = row;
        monsterLocationCol = col;
        
        // update the radar grid to show that something was detected at the specified location
        currentScan[row][col] = true;
    }
    
     /**
     * Sets the probability that a given cell will generate a false detection
     * 
     * @param   fraction    the probability that a given cell will generate a flase detection expressed
     *                      as a fraction (must be >= 0 and < 1)
     */
    public void setNoiseFraction(double fraction)
    {
        noiseFraction = fraction;
    }
    
    /**
     * Returns true if the specified location in the radar grid triggered a detection.
     * 
     * @param   row     the row of the location to query for detection
     * @param   col     the column of the location to query for detection
     * @return true if the specified location in the radar grid triggered a detection
     */
    public boolean isDetected(int row, int col)
    {
        return currentScan[row][col];
    }
    
    /**
     * Returns the number of times that the specified location in the radar grid has triggered a
     *  detection since the constructor of the radar object.
     * 
     * @param   row     the row of the location to query for accumulated detections
     * @param   col     the column of the location to query for accumulated detections
     * @return the number of times that the specified location in the radar grid has
     *          triggered a detection since the constructor of the radar object
     */
    public int getAccumulatedDetection(int row, int col)
    {
        return accumulator[row][col];
    }
    
    /**
     * Returns the number of rows in the radar grid
     * 
     * @return the number of rows in the radar grid
     */
    public int getNumRows()
    {
        return currentScan.length;
    }
    
    /**
     * Returns the number of columns in the radar grid
     * 
     * @return the number of columns in the radar grid
     */
    public int getNumCols()
    {
        return currentScan[0].length;
    }
    
    /**
     * Returns the number of scans that have been performed since the radar object was constructed
     * 
     * @return the number of scans that have been performed since the radar object was constructed
     */
    public int getNumScans()
    {
        return numScans;
    }
    
    /**
     * Sets cells as falsely triggering detection based on the specified probability
     * 
     */
    private void injectNoise()
    {
        for(int row = 0; row < currentScan.length; row++)
        {
            for(int col = 0; col < currentScan[0].length; col++)
            {
                // each cell has the specified probablily of being a false positive
                if(Math.random() < noiseFraction)
                {
                    currentScan[row][col] = true;
                }
            }
        }
       
        monsterLocationRow = monsterLocationRow + changeY;
        monsterLocationCol= monsterLocationCol + changeX;
        if (monsterLocationRow > 99)
        {
            monsterLocationRow = monsterLocationRow - 99;
        }
        if (monsterLocationCol > 99)
        {
            monsterLocationCol = monsterLocationCol - 99;
        }
        currentScan[monsterLocationRow][monsterLocationCol] = true;
    }
    
}