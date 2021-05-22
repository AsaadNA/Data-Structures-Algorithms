import java.util.ArrayList;
import java.util.Arrays;

public class BoyreMoore {
	
	public BoyreMoore(String t , String p) {
		char[] text = t.toCharArray();
		char[] pattern = p.toCharArray();
		
		int i = 0 , j , m = p.length();
		
		int[] bcArray = preProcBC(pattern);
		int[] shifts = preProcGS(pattern);
		ArrayList<Integer> results = new ArrayList<Integer>();
		
		while(i <= text.length-m) {
			j = m-1;
			while(j >= 0 && pattern[j] == text[i+j]) {
				j--;
			} if(j < 0) {
				results.add(i);
				i += i+shifts[0];
			} else {
				i = i + Math.max(shifts[j+1], j - bcArray[text[i+j]]);
			}
		} 
		
		System.out.println("Text: " + t);
		System.out.println("Pattern: " + p);
		if(results.size() == 0)
			System.out.println("Match not found");
		else {
			System.out.print("Matches found ");
			for(int ii = 0; ii <= results.size()-1; ii++)
				System.out.print(results.get(ii) + " ");
		}
		
	}

	private int[] preProcBC(char[] pattern) {
		int[] bcArray = new int[256];
		Arrays.fill(bcArray, -1);
		for(int i = 0; i < pattern.length; i++) {
			bcArray[pattern[i]] = i;
		} return bcArray;
	}
	
	private int[] preProcGS(char[] pattern) {
		int m = pattern.length;
		int i = m , j = m+1;
		
		int[] suffixBorder = new int[m+1];
		int[] shifts = new int[m+1];
		Arrays.fill(shifts, 0);
		
		suffixBorder[i] = j;
		
		while(i > 0) {
			while(j <= m && pattern[i-1] != pattern[j-1]) {
				if(shifts[j] == 0)
					shifts[j] = j-i;
				j = suffixBorder[j];
			}
			
			i--; j--;
			suffixBorder[i] = j;
		}
		
		j = suffixBorder[0];
		for(i = 0; i <= m; i++) {
			if(shifts[i] == 0) {
				shifts[i] = j;
			} if(i == j) {
				j = suffixBorder[j];
			}
		} return shifts;
	}
	
	public static void main(String args[]) {
		String pattern = "sort";
		String text = "Insertion sort typically has a smaller constant factor than merge sort";
		BoyreMoore bm = new BoyreMoore(text,pattern);		
	}
	
}
