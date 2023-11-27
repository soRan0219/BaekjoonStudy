import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String S = sc.next();
		String P = sc.next();
		
		sc.close();
		
		int copy = 0;
		int p_idx = 0;
		
		for(int i=0; i<P.length(); i++) {
			if(S.indexOf(P.substring(p_idx, i+1)) != -1) continue;
			copy++;
			p_idx = i;
		}
		
		System.out.println(copy+1);
		
	} //main()
}
