package com.datastructures;	

class Student
{
	private String name,id;
	private int age;
	private char gender;
	
	public Student(String name , String id , int age , char gender) {
		this.name = name;
		this.id = id;
		this.age = age;
		this.gender = gender;
	}
	
	@Override
	public String toString() {
		return String.format("Name: " + name + ", ID: " + id + ", Age: " + age + ",Gender: " + gender);
	}
}

public class Queue {
	
	private Student arr[];
	private int front = -1;
	private int tail = -1;
	
	public Queue(int size)
	{
		arr = new Student[size];
	}
	
	public void Enqueue(Student data)
	{
		if(tail == arr.length-1) {
			throw new IllegalArgumentException("OVERFLOW");
		} else if(front == -1 && tail == -1) {
			front = tail = 0;
			arr[tail] = data;
		} else {
			tail++;
			arr[tail] = data;
		}
	}
	
	public int getSize() { return tail - front; }
	
	public Student Dequeue()
	{
		if(getSize() >= 0) {
			int t = front;
			front++;
			return arr[t];
		} else {
			throw new IllegalArgumentException("UNDERFLOW");
		}
	}
	
	public Student Peek() {
		if(getSize() < 0) throw new IllegalArgumentException("EMPTY");
		else return arr[front];
	}
	
	public boolean isEmpty() {
		return(getSize() < 0);
	}
	
	public void Print() 
	{
		while(!isEmpty()) System.out.println(Dequeue());
	}
	
	public static void main(String args[]) 
	{
		Queue t = new Queue(5);
		t.Enqueue(new Student("Asaad","1912297",21,'m'));
		t.Enqueue(new Student("Ahsan","1912298",18,'m'));
		t.Enqueue(new Student("Mariam","1912233",21,'f'));
		t.Enqueue(new Student("Hallar","1912292",18,'m'));
		t.Enqueue(new Student("Moiz","1912291",22,'m'));
		
		t.Print();
	}
	
}