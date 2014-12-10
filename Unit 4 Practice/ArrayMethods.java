public class ArrayMethods
{
    public static void main(String[] args)
    {
        int[] array = {0,1,2,3,4};
        int last=  array.length -1;
        int temp = arr[last];
        for (int i=last;i>0;i--)
        {   
            array[i] = array[i-1];
        }
        
        array[0] = temp;
    }
}