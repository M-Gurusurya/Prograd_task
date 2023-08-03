import java.util.Scanner;

public class MaxSubarraySum {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("enter array size");
        int size=scanner.nextInt();
        int array[]=new int[size];
        for(int i=0;i<size;i++)
        {
            array[i]=scanner.nextInt();
        }
        System.out.println(findMaxSubarraySum(array,size));
    }
    static int findMaxSubarraySum(int array[],int size)
    {
        int max=Integer.MIN_VALUE;
        int sum=0;
        for(int i=0;i<size;i++)
        {
            sum+=array[i];
            if(sum>max)
            {
                max=sum;
            }
            if(sum<0)
            {
                sum=0;
            }
        }
        return max;
    }
}
