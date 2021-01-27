public class queue {

   private int[] arr;
   private int front = -1 ,  back = -1;

   public queue(int size) {
      arr = new int[size];
   }

   public void enqueue(int data) {
      if(front == -1 && back == -1) {
         front = 0;
         back = 0;
      }

      arr[back] = data;
      back++;
   }

   public int dequeue() {
      if(front == arr.length-1) {
         int t = arr[front];
         front = back = -1;
         return t;
      } else {
         int t = arr[front];  
         front += 1;
         return t;
      }
   }

   public boolean isEmpty() {
      return (front == -1 && back == -1);
   }

   public void print() {
      //for(int i = front; i <= back-1; i++)
      //   System.out.print(arr[i] + " ");

      while(!isEmpty())
         System.out.print(dequeue() + " ");
   }

   public static void main(String args[]) {
      queue q = new queue(5);

      q.enqueue(1);
      q.enqueue(2);
      q.enqueue(3);
      q.enqueue(4);
      q.enqueue(5);

      q.dequeue();

      q.print();
   }
}