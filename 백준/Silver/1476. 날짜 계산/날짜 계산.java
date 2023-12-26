import java.util.Scanner;

public class Main {
	
	static int getYear(int e, int s, int m) {
		int i = 1;
		
		while(true) {
			
			if((i-e)%15 == 0 && (i-s)%28 == 0 && (i-m)%19 == 0)
				return i;
			else 
				i++;
			
		} //while
		
	} //getYear()
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int e = sc.nextInt();
		int s = sc.nextInt();
		int m = sc.nextInt();
		
		sc.close();
		System.out.println(getYear(e, s, m));
		
	} //main()
}
