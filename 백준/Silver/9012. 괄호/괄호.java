import java.io.*;
import java.util.*;

public class Main {

	static String isVPS(String gwal) {
		Stack<Character> stack = new Stack<>();
		
		for(int i=0; i<gwal.length(); i++) {
			if(gwal.charAt(i) == '(') {
				stack.push(gwal.charAt(i));
			} else if(gwal.charAt(i) == ')') {
				try {
					stack.pop();
				} catch(EmptyStackException e) {
					return "NO";
				}
			}
		}
		
		if(!stack.isEmpty()) return "NO";
		else return "YES";
		
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<t; i++) {
			sb.append(isVPS(br.readLine()) + "\n");
		}
		
		System.out.println(sb);
	} //main()

}
