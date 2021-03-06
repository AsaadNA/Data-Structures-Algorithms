public class selectionsort {

  // Utility function to swap values at two indices in the array
    public static void swap(int[] arr, int i, int j)
    {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
 
    // Recursive function to perform selection sort on sub-array arr[i..n-1]
    public static void selectionSort(int[] arr, int i, int n)
    {
        // find the minimum element in the unsorted sub-array[i..n-1]
        // and swap it with arr[i]
        int min = i;
        for (int j = i + 1; j < n; j++)
        {
            // if arr[j] element is less, then it is the new minimum
            if (arr[j] < arr[min]) {
                min = j;    // update index of min element
            }
        }
 
        // swap the minimum element in sub-array[i..n-1] with arr[i]
        swap(arr, min, i);
 
        if (i + 1 < n) {
            selectionSort(arr, i + 1, n);
        }
    }

   public static void selectionsort(int arr[]) {
      int minIndex = -1;
      for(int i = 0; i <= arr.length-1; i++) {
         minIndex = i;
         for(int j = i + 1; j <= arr.length-1; j++) {
            if(arr[i] > arr[j]) {
               minIndex = j;
            }
         }

         int temp = arr[minIndex];
         arr[minIndex] = arr[i];
         arr[i] = temp;

      }
   }

   public static void main(String args[]) {
      int[] arr = {5,4,3};
      selectionSort(arr,0,arr.length);
      for(int i = 0; i <= arr.length-1; i++)
         System.out.print(arr[i] + " ");
   }
}