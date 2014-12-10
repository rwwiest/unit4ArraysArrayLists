// Implements a 2-D array of characters

public class CharMatrix
{
  // Instance Variables:
  final int rows;
  final int columns;
  char[][] grid;
  // Constructor: creates a grid with dimensions rows, cols,
  // and fills it with spaces
  public CharMatrix(int rows, int cols)
  {
    this.rows = rows;
    this.cols = cols;
    grid = new char[rows][cols];
    for (i=0; i <rows; i ++)
    {
        for (j=0; j<cols; i++)
        {
            grid[i][j] = "";
        }
    }
  }

  // Constructor: creates a grid with dimensions rows , cols ,
  // and fills it with the fill  character
  public CharMatrix(int rows, int cols, char fill)
  {
    chocFill = fill;
    for (i=0; i <rows; i ++)
    {
        for (j=0; j<cols; i++)
        {
            grid[i][j] = chocFill;
        }
    }
  }

  // Returns the number of rows in grid
  public int numRows()
  {
      int numRows = rows; 
      return numRows
  }

  // Returns the number of columns in grid
  public int numCols()
  {
      int numCols = columns;
      return numCols
  }

  // Returns the character at row, col location
  public char charAt(int row, int col)
  {
     int theRow = row;
     int theCol = col;
     char theChar = grid[theRow][theCol];
     return theChar;
  }

  // Sets the character at row, col location to ch
  public void setCharAt(int row, int col, char ch)
  {
    int theRow = row;
    int theCol = col;
    char theChar = ch;
    grid[theRow][theCol] = theChar;
  }

  // Returns true if the character at row, col is a space,
  // false otherwise
  public boolean isEmpty(int row, int col)
  {
      int theRow = row;
      int theCol = col;
      
      if (grid[row][col] == " ")
      {
          return true;
      }
      else
      {
          return false;
      }
  }

  // Fills the given rectangle with fill  characters.
  // row0, col0 is the upper left corner and row1, col1 is the
  // lower right corner of the rectangle.
  public void fillRect(int row0, int col0, int row1, int col1, char fill)
  {
    int theRow = row0;
    int theCol = col0;
  }

  // Fills the given rectangle with SPACE characters.
  // row0, col0 is the upper left corner and row1, col1 is the
  // lower right corner of the rectangle.
  public void clearRect(int row0, int col0, int row1, int col1)
  {
    ...
  }

  // Returns the count of all non-space characters in row 
  public int countInRow(int row)
  {
    ...
  }

  // Returns the count of all non-space characters in col 
  public int countInCol(int col)
  {
    ...
  }
}
