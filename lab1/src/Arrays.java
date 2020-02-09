public class Arrays {
    public static void swapLargestAndSmallest(int[] a) {
        int smallestIndex = 0; // suppose the smallest element is at index 0
        int largestIndex = 0; // suppose the largest element is at index 0

        for (int i = 1; i < a.length; i++){
            if (a[i] < a[smallestIndex]){ // if the element in the array is smaller than the element in the smallestIndex, swap index
                smallestIndex = i;
            }
            if (a[i] > a[largestIndex]){ // if the element in the array is larger than the element in the largestIndex, swap index
                largestIndex = i;
            }
        }
        int temp = a[smallestIndex]; // creating a temp place for smallest element
        a[smallestIndex] = a[largestIndex];
        a[largestIndex] = temp;

    }
}
