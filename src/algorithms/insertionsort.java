public class insertionsort {

   public static void insertionsort(int arr[]) {
      for(int i = 1; i < arr.length; i++) {
         int value = arr[i];
         int j = i-1;
         while(j >= 0 && arr[j] > value) {
            arr[j + 1] = arr[j];
            j--;
         }

         arr[j + 1] = value;
      }
   }

   public static int[] recursive(int arr[] , int i )
   {
      int elemnt = arr[i];
      int j = i-1;
      while(j >= 0 && arr[j] > elemnt) {
         arr[j + 1] = arr[j];
         j--;
      } arr[j + 1] = elemnt;

      if(i + 1 < arr.length)
      return recursive(arr,i+1);
      else 
         return arr;
   }

   public static void main(String args[]) {
      int[] arr = {5,4,3};
      recursive(arr,0);
      for(int i = 0; i <= arr.length-1; i++)
         System.out.print(arr[i] + " ");
   }
}