import java.util.Scanner;

public class Main {
	static int result = 0;
	static int mins[];
	
	static int minNumOfCal(int n) {
		
		for(int i=2; i<=n; i++) {
			if(i%6 == 0) 
				mins[i] = Math.min(mins[i/3], Math.min(mins[i/2], mins[i-1])) + 1;
			else if(i%3 == 0)
				mins[i] = Math.min(mins[i/3], mins[i-1]) + 1;
			else if(i%2 == 0)
				mins[i] = Math.min(mins[i/2], mins[i-1]) + 1;
			else 
				mins[i] = mins[i-1] + 1;
		}
		
		return mins[n];
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		mins = new int[n+1];
		sc.close();
		
		System.out.println(minNumOfCal(n));
		
	}
}
