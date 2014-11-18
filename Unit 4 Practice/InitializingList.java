public class InitializingList
{
    public static void main(String[] args)
    {
        int[] units = {147, 150, 170, 143, 123};
        int[] values = units;
        units[3] = 10;
        System.out.println(values[3]);
    }
}
