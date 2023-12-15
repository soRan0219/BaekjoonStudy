import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	
	static void printCommands(String[] cmd) {
		Stack<Integer> stack = new Stack<>();
		
		for(int i=0; i<cmd.length; i++) {
			
			switch(cmd[i]) {
				case "pop": 
					if(!stack.isEmpty()) System.out.println(stack.pop());
					else System.out.println(-1);
					break;
				case "size": System.out.println(stack.size()); break;
				case "empty":
					if(stack.isEmpty()) System.out.println(1);
					else System.out.println(0);
					break;
				case "top": 
					if(!stack.isEmpty()) System.out.println(stack.peek());
					else System.out.println(-1);
					break;
				default:
					stack.push(Integer.parseInt(cmd[i].substring(5)));
			}
			
		} //for
		
	} //printCommands()
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String[] commands = new String[n];
		
		for(int i=0; i<n; i++)
			commands[i] = br.readLine();
		
		printCommands(commands);
		
	} //main()
}
