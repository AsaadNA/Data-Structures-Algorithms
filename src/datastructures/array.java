public class array {

   private int[] arr;
   private int counter = 0;

   public array(int size) {
      arr = new int[size];
   }

   public void insert(int data) {
      arr[counter] = data;
      counter++;
   }

   public void remove(int data) {
      int dataIndex = -1;
      for(int i = 0; i <= counter-1; i++) {
         if(arr[i] == data) {
            dataIndex = i;
            counter--;
            break;
         }
      }

      for(int i = dataIndex; i <= counter-1; i++) {
         arr[i] = arr[i+1];
      }
   }

   public void print() {
      for(int i = 0; i <= counter-1; i++)
         System.out.print(arr[i] + " ");
   }

   public static void main(String args[]) {
      array a = new array(5);

      a.insert(1);
      a.insert(2);
      a.insert(3);
      a.insert(4);
      a.insert(5);

      a.remove(3);
      a.remove(1);
      a.remove(5);

      a.print();
   }
}