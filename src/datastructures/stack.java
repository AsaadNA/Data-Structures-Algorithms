public class stack {

   private int[] arr;
   private int top = -1;

   public stack(int size) {
      arr = new int[size];
   }

   public void push(int data) {
      if(top == arr.length-1)
         System.out.println("Stack is full");
      else {
         top += 1;  
         arr[top] = data;
      }
   }

   public int pop() {
      if(top <= 0) {
         int t = arr[top];
         top = -1;
         return t;
      } else {
         int t = arr[top];
         top -=1;
         return t;
      }
   }

   public boolean isEmpty() {
      return (top == -1);
   }

   public void print() {
      while(!isEmpty()) {
         System.out.println(pop());
      }
   }

   public static void main(String args[]) {
      stack t = new stack(5);

      t.push(1);
      t.push(2);
      t.push(3);
      t.push(4);
      t.push(5);

      t.print();

   }
}