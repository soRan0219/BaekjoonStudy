import java.util.Scanner;

public class Main {
	
	static int prize(int d1, int d2, int d3) {
		int p = 0;
		if(d1==d2 && d2==d3) {
			p = 10000 + d1*1000;
		} else if(d1==d2 || d2==d3 || d1==d3) {
			p = 1000 + (d1==d2 ? d1*100 : (d2==d3 ? d2*100 : d3*100));
		} else {
			p = Math.max(d1, Math.max(d2, d3))*100;
		}
		
		return p;
	}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int d1 = s.nextInt();
		int d2 = s.nextInt();
		int d3 = s.nextInt();
		
		System.out.println(prize(d1, d2, d3));

	} //main
}
