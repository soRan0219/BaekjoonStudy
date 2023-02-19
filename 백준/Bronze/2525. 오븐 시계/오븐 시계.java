import java.util.Scanner;

public class Main {

	static String cookT(int h, int m, int cook) {
        // m + cook = 60 * (1 ~ 16)
        int hour = (m+cook)/60;
	if(60 <= (m+cook)) {
		// h + ((m+cook)/60) >= 24 -> h -= 24 
		if( h + hour >= 24) {
			h -= 24;
		}
		h += hour;
		m = (m+cook) % 60;
	} else {
		m = m + cook;
	}
		
	return h + " " + m;
		
	} //cookT
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int h = sc.nextInt();
		int m = sc.nextInt();
		int cook = sc.nextInt();
		
		System.out.println(cookT(h, m, cook));

	} //main
}
