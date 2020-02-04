// Implement the method Arrays.swapLargestAndSmallest(int[] a) that swaps the largest and smallest element in a.
// If there are multiple largest or smallest elements, pick the first one.
public class Arrays {
    public static void swapLargestAndSmallest(int[] a) {
         int smallestIndex = 0;
         int largestIndex = 0;

         for (int i = 1; i < a.length; i++){
             if (a[i] < a[smallestIndex]){
                 smallestIndex = i;
             }
             if (a[i] > a[largestIndex]){
                 largestIndex = i;
             }
         }
         int temp = a[smallestIndex];
         a[smallestIndex] = a[largestIndex];
         a[largestIndex] = temp;

    }
}
