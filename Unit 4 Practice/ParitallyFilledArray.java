public class ParitallyFilledArray
{
    private int [] values;
    private int currentSize;
    
    public ParitallyFilledArray()
    {
        this.values = new int[10];
        this.currentSize = 0;
    }
    
    public String toString()
    {
        String str = "[ ";
        
        for (int i =0; i < this.currentSize; i++)
        {
            if (i>0)
            {
                str += ", ";
            }
            str += this.values[i];
        }
        str+= " ]";
        return str;
    }
    public void fillNElementsRandomly( int numberOfElements, int maxValue)
    {
        for(int i = 0; i < numberOfElements; i++)
        {
            this.values[i] = (int)(Math.random() * maxValue);
            this.currentSize++;
        }
    }
    
    public void removeElementAtIndex( int index)
    {
        this.values[index] = this.values[this.currentSize - 1];
        currentSize--;
    }
    
    public void swapElements(int index1, int index2)
    {
        int tempValue= this.values[index1];
        this.values[index1] = this.values[index2];
        this.values[index2] = tempValue;
    }
    
    public void insertElement(int value)
    {
        if (this.currentSize == this.values.length)
        {
            growArray();
        }
        this.values[currentSize] = value;
        currentSize++;
    }
    
    public void growArray()
    {
        int newArraySize = this.values.length * 2;
        int[] newArray = new int[newArraySize];
        
        for (int i = 0; i < this.values[i];)
        {
            newArray[i] = this.values[i];
        }
        
        this.values = newArray;
    }
}


