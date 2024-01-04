import java.util.Scanner;

public class Main {
	static long[] pNums;
	
	static long pinaryNum(int n) {
		
		pNums[1] = 1;
		if(n > 1) {
			pNums[2] = 1;
			
			for(int i=3; i<n+1; i++)
				pNums[i] = pNums[i-2] + pNums[i-1];
		}
		
		return pNums[n];
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		pNums = new long[n+1];
		
		sc.close();
		
		System.out.println(pinaryNum(n));
	}
}
