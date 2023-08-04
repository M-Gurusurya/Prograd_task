import java.util.Arrays;
import java.util.Scanner;
public class MaximumGap {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("enter array size");
        int size=scanner.nextInt();
        int array[]=new int[size];
        for(int i=0;i<size;i++)
        {
            array[i]=scanner.nextInt();
        }
        System.out.println(findMaxGap(array,size));
    }
    static int findMaxGap(int array[],int size)
    {
        int min = array[0], max = array[0];
        for (int i=0;i<size;i++){
            min = Math.min(min, array[i]);
            max = Math.max(max, array[i]);
        }
        if (min == max)
        {
            return 0;
        }
        int bucketSize = (int) Math.ceil((double) (max - min) / (size - 1));
        int[] minBucket = new int[size];
        int[] maxBucket = new int[size];
        Arrays.fill(minBucket, Integer.MAX_VALUE);
        Arrays.fill(maxBucket, Integer.MIN_VALUE);
        for (int i=0;i<size;i++) {
            int idx = (array[i] - min) / bucketSize;
            minBucket[idx] = Math.min(array[i], minBucket[idx]);
            maxBucket[idx] = Math.max(array[i], maxBucket[idx]);
        }
        int maxGap = bucketSize;
        int previous = maxBucket[0];
        for (int i = 1; i < size; i++) {
            if (minBucket[i] == Integer.MAX_VALUE) continue;
            maxGap = Math.max(maxGap, minBucket[i] - previous);
            previous = maxBucket[i];
        }
        return maxGap;
    }
}
