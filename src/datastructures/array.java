package com.datastructures;

public class Array {
    
    private int counter = 0;
    private int[] items;
    
    public Array(int length) {
        items = new int[length];
    }
    
    //This will remove item at given index
    public void RemoveAt(int index) {
        if(counter < 0 || counter > items.length) {
            throw new IllegalArgumentException();
        } for(int i = index; i <= counter; i++) {
            items[i] = items[i + 1];
        } counter--;
    }
    
    //This will return the index of the given data item
    public int indexOf(int data) {
        for(int i = 0; i < counter; i++)
            if(data == items[i]) return i;
        return -1;
    }
        
    //Insert the data into the list
    public void Insert(int data) {
        if(items.length == counter) {
            int[] temp = new int[counter*2];
            for(int i = 0; i < counter; i++) {
                temp[i] = items[i]; 
            } items = temp;
        }
        
        items[counter++] = data;
    }
    
    public int findLargest() {
        int largest = 0;
        for(int i = 0; i < counter; i++) {
            if(largest < items[i]) largest = items[i];
        } return largest;
    }
    
    /**
     * 
     * Time Complexity for the following function: O(n^2)
     * 
     */
    public Array findCommons(int[] arr) {
        Array commonsArray = new Array(1);
        for(int i = 0; i < counter; i++) { //O(N)
            for(int j = 0; j < arr.length; j++) { //O(N)
                if(items[i] == arr[j]) {
                    commonsArray.Insert(items[i]);
                }   
            }
        } return commonsArray;
    }
    
    //This will print the array
    public void Print() {
        for(int i = 0; i <= counter - 1; i++) {
            System.out.println(items[i]);
        }
    }
    
     public static void main(String []args){
        Array a = new Array(3);
        a.Insert(1);
        a.Insert(35);
        a.Insert(3);
        a.Insert(4);
        
        //Finding common items b/w 'a' & 'b'
        int[] b = {2,1,3};
        Array commonItems = a.findCommons(b);
        commonItems.Print();
     }
}