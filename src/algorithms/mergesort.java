public class mergesort {

   private static void merge(int arr[] , int l , int m , int h) {
      int temp[] = new int[h-l+1];
      int i = l , j = m+1 , k = 0;

      while(i <= m && j <= h) {
         if(arr[i] < arr[j]) {
            temp[k] = arr[i];
            i++;
         } else {
            temp[k] = arr[j];
            j++;
         } k++;
      }

      while(i <= m) {
         temp[k] = arr[i];
         i++; k++;
      }

      while(j <= h) {
         temp[k] = arr[i];
         j++; k++;
      }

      for(i = l; i <= h; i++)
         arr[i] = temp[i-l];
   }

   public static void mergesort(int arr[] , int l , int h) {
      if(l < h) {
      int m = (l + h) / 2;
      mergesort(arr,0,m);
      mergesort(arr,m+1,h);
      merge(arr,l,m,h);
      } else {
         return;
      }
   }

   public static void main(String args[]) {
      int[] arr = {5,4,3};
      mergesort(arr,0,arr.length-1);
      for(int i = 0; i <= arr.length-1; i++)
         System.out.print(arr[i] + " ");
   }
}