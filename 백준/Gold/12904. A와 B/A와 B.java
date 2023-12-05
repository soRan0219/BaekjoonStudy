import java.util.Scanner;

public class Main {
	
	static void solution(String s, String t) {
		StringBuffer origin = new StringBuffer(s);
		StringBuffer result = new StringBuffer(t);
				
		while(origin.length() != result.length()) {
			if(result.charAt(result.length()-1) == 'A') {
				result = new StringBuffer(result.substring(0, result.length()-1));
			} else if(result.charAt(result.length()-1) == 'B') {
				result = new StringBuffer(result.substring(0, result.length()-1));
				result = result.reverse();
			}
		}
		
		if(origin.toString().equals(result.toString())) System.out.println(1);
		else System.out.println(0);
		
	} //solution()
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		String t = sc.next();
		sc.close();
		
		solution(s, t);
		
	} //main()
}
