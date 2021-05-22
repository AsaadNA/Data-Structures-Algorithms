import java.util.ArrayList;
import java.util.Scanner;

class Item {
	public int weight;
	public int benefit;
	
	public Item(int weight , int benefit) {
		this.weight = weight;
		this.benefit = benefit;
	}
	
	public void print() {
		System.out.print("("+weight+","+benefit+")  ");
	}
}

public class Knapsack {
	
	private ArrayList<Item> data = new ArrayList<Item>();

	public Knapsack() {
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("# of elements: ");
		int loop = scanner.nextInt();
		
		data.add(new Item(0,0));
		for(int i = 0; i <= loop-1; i++) {
			System.out.print("Enter (weight,benefit) : ");
			int weight = scanner.nextInt();
			int benefit = scanner.nextInt();
			data.add(new Item(weight,benefit));
		}
		
		System.out.print("Enter MAX weight: ");
		int W = scanner.nextInt();
		
		int n = data.size()-1;
		int b[][] = new int[data.size()][W+1];
		
		//Computing 
		for(int i = 0; i <= n; i++) {
			for(int w = 0; w <= W; w++) {
				if(i == 0 || w == 0) {
					b[i][w] = 0;
				} else if(data.get(i).weight <= w) {
					if((data.get(i).benefit) + b[i-1][w-data.get(i).weight] > b[i-1][w]) {
						b[i][w] = data.get(i).benefit + b[i-1][w-data.get(i).weight];
					} else {
						b[i][w] = b[i-1][w];
					}
				} else {
					b[i][w] = b[i-1][w];
				}
			}
		}
		
		System.out.println("");

		print(n,W,b); //print the table

		System.out.println("");
		
		//Finding out which row label is in the knapsack basket by tracing back
		int i = n , j = W;
		while(i > 0 && j > 0) {
			if(b[i][j] == b[i-1][j]) {
				i--;
			} else {
				data.get(i).print();
				j -= data.get(i).weight;
				i--;
			}
		} 
		
		System.out.println("are include in knapsack for max value of " + b[n][W]);
		 
	}

	//Printing out the table
	public void print(int n , int W , int b[][]) {
		System.out.print("         ");
		for(int i = 0; i <= W; i++) {
			System.out.print(i + " ");
		}System.out.println("");
		System.out.print("         ");
		for(int i = 0; i <= W-1; i++) {
			System.out.print("--");
		} System.out.println("");
		
		for(int i = 0; i <= n; i++) {
			if(i >= 1)  { data.get(i).print(); System.out.print(i + "|"); } 
			else if(i < 1) { System.out.print("       " +i + "|"); }
			for(int j = 0; j <= W; j++) {
				System.out.print(b[i][j] +  " ");
			} System.out.println("");
		}
	} 
	
	public static void main(String args[]) {
		Knapsack kp = new Knapsack();		
	}

}
