public class maxHeap {

   public maxHeap(int[] arr) {
      int lastPIndex = arr.length/2-1;
      for(int i = lastPIndex; i >= 0; i--)
         heapify(arr,i);
   }

   private void swap(int[] arr , int f , int s) {
      var t = arr[f];
      arr[f] = arr[s];
      arr[s] = t;
   }

   private void heapify(int[] arr , int i) {
      int largest = i;
      int leftChild = 2*i+1;
      int rightChild = 2*i+2;

      if(leftChild < arr.length && arr[leftChild] > arr[largest])
         largest = leftChild;
      if(rightChild < arr.length && arr[rightChild] > arr[largest])
         largest = rightChild;

      if(largest == i)
         return;

      swap(arr,i,largest);
      heapify(arr,largest);
   }

   public static void main(String args[]) {
      int[] arr = {1,3,2,8};
      maxHeap h = new maxHeap(arr);
      for(int i = 0; i <= arr.length-1; i++)
         System.out.print(arr[i] + " ");
   }
}