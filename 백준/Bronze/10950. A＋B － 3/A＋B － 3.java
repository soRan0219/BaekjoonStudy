import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		int testCase = s.nextInt();
		
		int[] sum = new int[testCase];
		for(int i=0; i<testCase; i++) {
			sum[i] = s.nextInt() + s.nextInt(); 
		}
		
		for(int i=0; i<testCase; i++) {
			System.out.println(sum[i]);
		}
			
	} //main
}