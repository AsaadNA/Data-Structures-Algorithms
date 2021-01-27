public class bubblesort {

   public static void bubblesort(int arr[]) {
      for(int i = 0; i <= arr.length-1; i++) {
         for(int j = 0; j <= arr.length-1; j++) {
            if(arr[i] < arr[j]) {
               int t = arr[j];
               arr[j] = arr[i];
               arr[i] = t;
            }
         }
      }
   }

   public static void main(String args[]) {
      int[] arr = {5,4,3};
      bubblesort(arr);
      for(int i = 0; i <= arr.length-1; i++)
         System.out.print(arr[i] + " ");
   }
}