public class binarysearch {

   //Worst Case; 0(log n)
   //Best case: O(1)
   public int BinarySearch(char arr[] , char data) {
      int p = 0 , q;
      int r = arr.length-1;
      while(p <= r) {
         q = (p + r) / 2;
         if(arr[q] == data)
            return q;
         else if(arr[q] > data)
            r = q-1;
         else
            p = q + 1;
      } return -1;
   }
   
   public int RecursiveBinarySearch(char arr[] , int p , int r , char data) {
      int q;
      if(p > r)
         return -1;
      else {
         q = (p+r) / 2;
         if(arr[q] == data)
            return q;
         else if(arr[q] > data)
            return RecursiveBinarySearch(arr, p, q-1, data);
         else
            return   RecursiveBinarySearch(arr,q+1,r,data);
      }
   }

   public static void main(String args[]) {
      int arr[] = {1,5,5,2};
      int result = binarysearch(arr,2,0,arr.length-1);
      System.out.println(result);
   }
}