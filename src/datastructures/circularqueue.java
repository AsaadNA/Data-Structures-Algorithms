public class circularqueue {

   private int[] arr;
   private int front = -1 , rear = -1;

   public circularqueue(int size) {
      arr = new int[size];
   }

   public void enqueue(int data) {
      if(front == -1 && rear == -1) {
         front = rear = 0;
         arr[rear] = data;
      } else {
         rear = (rear + 1) % arr.length;
         arr[rear] = data;  
      }
   }

   public void dequeue() {
      front = (front + 1) % arr.length;
   }

   public void print() {
      int i = front;
      if(front == -1 && rear == -1) {
         System.out.println("Empoty");
      } else {
         while(i != rear) {
            System.out.print(arr[i] + " ");
            i = (i + 1) % arr.length;
         }
      }
   }

   public static void main(String args[]) {
      circularqueue q = new circularqueue(5);

      q.enqueue(1);
      q.enqueue(2);
      q.enqueue(3);
      q.enqueue(4);
      q.enqueue(5);

      q.dequeue();

      q.print();
   }
}