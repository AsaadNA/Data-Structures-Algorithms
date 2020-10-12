package com.datastructures;

public class Stack {
	
	private int top = -1;
	private int[] stack;
	
	public Stack(int size) {
		stack = new int[size];
	}
	
	//O(1)
	public void push(int x) {
		
		//Overflow condition
		if(top == stack.length - 1) {
            throw new IllegalArgumentException("Overflow Condition in the stack");
		} else {
			top += 1;
			stack[top] = x;
		}
	}
	
	//O(1)
	public void pop() {
		
		//Underflow condition
		if(top == -1) {
			throw new IllegalArgumentException("Underflow Condition in the stack");
		} else {
			top -= 1;
		}
	}
	
	//O(1)
	public void peek() {
		//checking if stack empty
		if(top == -1) {
			System.out.println("Stack is empty");
		} else {
			System.out.println("Peek(): " + stack[top]);
		}
	}
	
	//O(n)
	public void display() {
		for(int i = top; i >= 0; i--) {
			System.out.println(stack[i]);
		}
	}

	public static void main(String args[]) {
		Stack test = new Stack(5);
		test.push(1);
		test.push(2);
		test.push(3);
		test.push(4);
		test.push(5);
		test.push(7);
		test.display();
	}
}
