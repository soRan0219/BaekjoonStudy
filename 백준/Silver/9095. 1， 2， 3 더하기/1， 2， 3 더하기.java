import java.util.Scanner;

public class Main {
	static int[] sums;
	
	static int sumOfNums(int n) {
		if(n < 3) sums[n] = n;
		else if(n == 3) sums[n] = 4;
		else 
			sums[n] = sumOfNums(n-1) + sumOfNums(n-2) + sumOfNums(n-3); 
		
		return sums[n];
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<t; i++) {
			int n = sc.nextInt();
			sums = new int[n+1];
			sb.append(sumOfNums(n) + "\n");
		}
		
		sc.close();
		
		System.out.println(sb);
	}
}
