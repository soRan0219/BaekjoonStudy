import java.util.Scanner;

public class Main {

	static String cookT(int h, int m, int cook) {
        // m + cook = 60 * (1 ~ 16)
        int hour = (m+cook)/60;
		if(60*1 <= (m+cook) && (m+cook) <= 60*16) {
			// h + ((m+cook)/60) >= 24 -> h -= 24 
			if( h + hour >= 24) {
				h -= 24;
			}
			switch(hour) {
				case 1: h += 1; break;
				case 2: h += 2; break;
				case 3: h += 3; break;
				case 4: h += 4; break;
				case 5: h += 5; break;
				case 6: h += 6; break;
				case 7: h += 7; break;
				case 8: h += 8; break;
				case 9: h += 9; break;
				case 10: h += 10; break;
				case 11: h += 11; break;
				case 12: h += 12; break;
				case 13: h += 13; break;
				case 14: h += 14; break;
				case 15: h += 15; break;
				case 16: h += 16; break;
			}
			m = (m+cook) % 60;
		} else if((m+cook) > 60*16) {
            if(h+hour >= 24) {
                h -= 24;
            }
            h += hour;
            m = (m+cook) % 60;
        }
        else {
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