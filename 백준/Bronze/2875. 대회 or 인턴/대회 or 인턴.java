import java.util.Scanner;

public class Main {
	
	static int getTeams(int n, int m, int k) {
		int teams = 0;
		
		while(n>1 && m>0) {
			n -= 2;
			m -= 1;
			teams++;
		}
		
		int remains = n + m;
		while(remains < k) {
			teams--;
			remains += 3;
		}
		
		return teams;
	} //getTeams()
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int k = sc.nextInt();
		sc.close();
		
		System.out.println(getTeams(n, m, k));
		
	} //main()
}
