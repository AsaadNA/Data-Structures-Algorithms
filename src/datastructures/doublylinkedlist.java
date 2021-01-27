class Node {
   int data;
   Node prev,next;

   public Node(int data) {
      this.data = data;
      this.prev = this.next = null;
   }
}

public class doublylinkedlist {

   private Node head,curr;

   public void Insert(int data) {
      Node newNode = new Node(data);
      if(head == null) {
         head = newNode;
      } else {
         curr = head;
         while(curr.next != null) {
            curr = curr.next;
         }
         newNode.prev = curr;
         curr.next = newNode;
      }
   }

   public void Remove(int data) {
      curr = head;
      Node temp = curr;

      while(curr != null && curr.data != data) {
         temp = curr;
         curr = curr.next;
      }

      if(curr.prev == null && curr.next == null) {
         curr = null;
      } else if(curr.prev == null && curr.next != null) {
         head = head.next;
      } else if(curr.next == null && curr.prev != null) {
         temp.next = null;
      } else if(curr != null && curr.data == data) {
         temp.next = curr.next;
         curr.next.prev = curr.prev;
      }
   }

   public void Print() {
      curr = head;
      while(curr != null) {
         System.out.print(curr.data + " ");
         curr = curr.next;
      }
   }

   public static void main(String args[]) {
      doublylinkedlist l = new doublylinkedlist();

      l.Insert(1);
      l.Insert(2);
      l.Insert(3);
      l.Insert(4);

      l.Remove(4);
      l.Print();
   }
}