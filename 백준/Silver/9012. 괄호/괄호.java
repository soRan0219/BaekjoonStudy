import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.EmptyStackException;
import java.util.Stack;

public class Main {

	static String isVPS(String par) {
		Stack<Character> pStack = new Stack<>();
		
		for(int i=0; i<par.length(); i++) {
			if(par.charAt(i) == '(') pStack.push(par.charAt(i));
			else if(par.charAt(i) == ')') {
				try{
					pStack.pop();
				} catch(EmptyStackException e) {
					return "NO\n";
				}
			}
		}
		if(pStack.isEmpty()) return "YES\n";
		else return "NO\n";
		
	} //isVPS()
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for(int i=0; i<t; i++)
			sb.append(isVPS(br.readLine()));
		
		System.out.println(sb);
		
	} //main()

}
