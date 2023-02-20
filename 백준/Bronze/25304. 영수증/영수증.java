import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		int finalMoney = s.nextInt();
		int kind = s.nextInt();
		
		int sum = 0;
		for(int i=1; i<=kind; i++) {
			sum += s.nextInt() * s.nextInt();
		}
		
		String str = finalMoney==sum ? "Yes" : "No";
		
		System.out.println(str);
		
	} //main
}