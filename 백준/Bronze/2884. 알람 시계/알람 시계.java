import java.util.Scanner;

public class Main {
	public static String setAlarm(int h, int m) {
		if(m < 45) {
			h = h==0 ? 23 : h-1;
			m = 60 - (45-m);
		} else {
			m -= 45;
		} //if-else
		return h + " " + m;
	} //setAlarm
	
	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		String time = s.nextLine();
		int h = Integer.parseInt(time.split(" ")[0]);
		int m = Integer.parseInt(time.split(" ")[1]);
		
		System.out.print(setAlarm(h, m));
	
		
	} //main
}