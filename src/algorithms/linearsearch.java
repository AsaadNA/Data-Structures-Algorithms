//Time Complexity => O(n)
   public int LinearSearch(char arr[] , char data) {
      for(int i = 0; i <= arr.length-1; i++) {
         if(arr[i] == data) {
            return i;
         }
      } return -1;
   }
   
   public int RecursiveLinearSearch(char arr[] , int i , char data) {
      int n = arr.length-1;
      if(i >= n) 
         return -1;
      else if(arr[i] == data)
         return i;
      else
         return RecursiveLinearSearch(arr, i+1, data);
   }