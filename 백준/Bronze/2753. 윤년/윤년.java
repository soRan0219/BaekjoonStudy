import java.util.Scanner;

public class Main {

	static short isLeapYear(int year) {
		if((year%4==0 && year%100!=0) || year%400==0) {
			return 1;
		}
		return 0;
	}
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		int year = s.nextInt();
		
		System.out.println(isLeapYear(year));

	} //main

}
