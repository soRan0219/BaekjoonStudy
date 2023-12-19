import java.util.Scanner;
import java.util.Stack;

public class Main {
	
	static int getPieces(String par) {
		int result = 0;
		Stack<Character> parStack = new Stack<>();
		
		char pre = ' ';
		for(int i=0; i<par.length(); i++) {
			char now = par.charAt(i);
			if(now == '(') {
				parStack.push(now);
			} else {
				parStack.pop();
				if(pre == '(') result += parStack.size();
				else if(pre == ')') result++;
			}
			if(i>0) pre = now;
		}
		
		return result;
	} //getPieces()
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String parenthesis = sc.next();
		sc.close();
		
		System.out.println(getPieces(parenthesis));
		
	} //main()
}
