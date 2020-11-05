class Node {
   
   public int  data;
   public Node next;
   
   public void DisplayNode() {
      System.out.println(data);
   }
}

public class SLL {
   
   private Node head = null;
   private Node current = null;
   
   public boolean isEmpty() {
      return (head == null);
   }
   
   public void InsertHead(int data) {
      Node newNode = new Node();
      newNode.data = data;
      head = newNode;
   }
   
   public void RemoveHead() {
      if(head != null) head = head.next;
   }
   
   public void InsertMiddle(int data) {
      Node newNode = new Node();
      newNode.data = data;
      Node current = head;
      while(current.next != null) current = current.next;
      current.next = newNode;
   }
   
   public void DeleteMiddle() {
      current = head;
      Node temp = null;
      while(current != head.next) {
         temp = current;
         current = current.next;
      } temp.next = current.next;
   }
   
   public void DeleteLast() {
      current = head;
      Node temp = null;
      while(current.next != null) {
         temp = current;
         current = current.next;
      } temp.next = current.next;  
   }
   
   public void Print() {
      current = head;
      while(current != null) {
         current.DisplayNode();
         current = current.next;
      }
   }
     
   public static void main(String args[]) {
      
      SLL test = new SLL();
      
      test.InsertHead(1);
      test.InsertMiddle(2);
      test.InsertMiddle(3);
      test.InsertMiddle(4);
      test.InsertMiddle(5);
      test.InsertMiddle(6);
      
      test.RemoveHead(); //remove 1
      test.DeleteMiddle(); //remove 3 because head is now 2
      test.DeleteLast(); //delete 6
      
      test.Print();
      
   }
}