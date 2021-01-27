class Node {
   int data;
   Node left , right;

   public Node(int data) {
      this.data = data;
      this.left = this.right = null;
   }
}

public class bst {

   private Node root;

   private Node Insert(Node root , int data) {
      Node newNode = new Node(data);
      if(root == null) {
         root = newNode;
         return root;
      } else if(data < root.data) {
         root.left = Insert(root.left,data);
      } else if(data > root.data) {
         root.right = Insert(root.right,data);
      } return root;
   }

   private Node Remove(Node root , int data) {
      if(root == null) {
         return root;
      } if(data < root.data) {
         root.left = Remove(root.left,data);
      } else if(data > root.data) {
         root.right = Remove(root.right,data);
      } else {
         if(root.left == null)
            return root.right;
         else if(root.right == null)
            return root.left;

         root.data = findMin(root.right);
         root.right = Remove(root.right,root.data);
      } return root;
   }

   private Node Search(Node root , int data) {
      if(root == null)
         return root;
      if(data < root.data)
        return Search(root.left,data);
      else if(data > root.data)
        return Search(root.right,data);
      return root;
   }

   private int findMin(Node root) {
      int minValue = 0;
      if(root == null)
         return -1;
      while(root.left != null) {
         minValue = root.left.data;
         root = root.left;
      } return minValue;
   }

   private int findMax(Node root) {
      int maxVal = -1;
      if(root == null)
         return -1;
      while(root.right != null) {
         maxVal = root.right.data;
         root = root.right;
      } return maxVal;
   }

   private void InorderPrint(Node root) {
      if(root == null) return;

      InorderPrint(root.left);
      System.out.print(root.data + " ");
      InorderPrint(root.right);
   }

   private int getHeight(Node root) {
      if(root == null)
         return -1;
      else if(root.left == null && root.right == null)
         return 0;
      return 1+Math.max(getHeight(root.left),getHeight(root.right));
   }

   private void PrintNodesAtHeight(Node root , int distance) {
      if(root == null)
         return;
      else if(distance == 0)
         System.out.print(root.data + " ");

      PrintNodesAtHeight(root.left,distance-1);
      PrintNodesAtHeight(root.right,distance-1);
   }

   private boolean isTreeEqual(Node first , Node second) {
      if(first == null && second == null)
         return true;
      else if(first != null && second != null) {
         return (first.data == second.data && (isTreeEqual(first.left,second.left)) && (isTreeEqual(first.right,second.right)));
      } return false;
   }

   public Node getRoot() { return this.root; }

   public boolean isTreeEqual(bst otherTree) {
      return isTreeEqual(root,otherTree.getRoot());
   }

   public void PrintNodesAtHeight(int distance) {
      PrintNodesAtHeight(root,distance);
   }

   public int getHeight() {
      return getHeight(root);
   }

   public void Insert(int data) {
      root = Insert(root,data);
   }

   public void Remove(int data) {
      root = Remove(root,data);
   }

   private void Search(int data) {
      root = Search(root,data);
      if(root != null) {
         System.out.println("FOUND");
      }
   }

   public int findMin() {
      return findMin(root);
   }

   public int findMax() {
      return findMax(root);
   }

   public void InorderPrint() {
      InorderPrint(root);
   }

   public static void main(String args[]) {
      bst b = new bst();

      b.Insert(5);
      b.Insert(2);
      b.Insert(6);

   }
}