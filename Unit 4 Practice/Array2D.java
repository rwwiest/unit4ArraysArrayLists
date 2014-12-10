public class Array2D
{
    private int [][] table = 
        {
            {1,2,3},
            {4,5,6},
            {7,8,9},
            {10,11,12}
        };
    public Array2D()
    {
    }
    
    public String toString()
    {
        String str = "";
        //table.length is the number of rows in the table
        for( int row = 0; row < table.length; row++)
        {
            // table [row].lenght is the number of columns in the row
            for (int col = 0; col< table[row].length; col++)
            {
                str += table[row][col] + "\t";
            }
            
            str += "\n";
        }
        return str;
    }
    public static void main(String[] args)
    {
        Array2D table = new Array2D();
        System.out.println(table.toString());
        System.out.println(table.extractRow(1));
    }
    
    public String extractRow(int row)
    {
        String str = "";
        
        for (int col = 0; col< table[row].length; col++)
            {
                str += table[row][col] + "\t";
            }
        
        return str;
    }
}