public class heap {

  private int[] items = new int[10];
  private int size;

  public boolean isFull() {
    return (size == items.length);
  }

  private void bubbleup() {
    int index = size - 1;
    while(index > 0 && items[index] > items[parent(index)]) {
      swap(index,parent(index));
      index = parent(index);
    }
  }

  private void bubbledown() {
    int index = 0;
    while(index <= size && !isValidParent(index)) {
      int largerChildIndex = largerChildIndex(index);
      swap(index,largerChildIndex);
      index = largerChildIndex;
    }
  }

  private int largerChildIndex(int index) {
    if(!hasLeftChild(index)) 
      return index;
    else if(!hasRightChild(index))
      return leftChildIndex(index);
    return (items[leftChildIndex(index)]) > items[rightChildIndex(index)] ? leftChildIndex(index) : rightChildIndex(index);
  }

  private boolean isValidParent(int index) {
    if(!hasLeftChild(index))
      return true;
    else if(!hasRightChild(index))
      return items[index] >= items[leftChildIndex(index)];
      return items[index] >= items[leftChildIndex(index)] && items[index] >= items[rightChildIndex(index)];
  }

  private int leftChildIndex(int index) {
    return index*2+1;
  }

  private int rightChildIndex(int index) {
    return index*2+2;
  }

  private boolean hasLeftChild(int index) {
    return leftChildIndex(index) <= size;
  }

  private boolean hasRightChild(int index) {
    return rightChildIndex(index) <= size;
  }

  private int parent(int index) {
    return (index-1)/2;
  }

  private void swap(int f , int s) {
    int temp = items[f];
    items[f] = items[s];
    items[s] = temp;
  }

  public void insert(int value) {
    if(isFull())
      System.out.println("Full");
    items[size++] = value;
    bubbleup();
  }

  public boolean isEmpty() { return (size == 0); }

  public int remove() {
    if(isEmpty())
      throw new IllegalStateException();
    int root = items[0];
    items[0] = items[size-1];
    size--;

    bubbledown();
    return root;
  }

  //Descending order
  public void heapSort() {
    int[] numbers = {5,3,10,1,4};
    heap h = new heap();
    for(var n : numbers)
      h.insert(n);
    for(var i = 0; i < numbers.length; i++)
      numbers[i] = h.remove();

    for(int i = 0; i <= numbers.length-1; i++)
      System.out.print(numbers[i] + " ");
  }

  //Ascending order
  public void heapSortAsc() {
    int[] numbers = {5,3,10,1,4};
    heap h = new heap();
    for(var n : numbers)
      h.insert(n);
    for(var i = numbers.length-1; i >= 0; i--)
      numbers[i] = h.remove();

    for(int i = 0; i <= numbers.length-1; i++)
      System.out.print(numbers[i] + " ");
  }


  public static void main(String args[]) {
    heap h = new heap();
    h.insert(1);
    h.insert(2);
    h.insert(3);
    //System.out.println(h.remove());
    h.heapSortAsc();
  }
}