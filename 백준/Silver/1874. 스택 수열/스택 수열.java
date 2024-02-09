import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static StringBuilder sb;
	
	static void stackSeq(int[] goal) {
		Stack<Integer> stack = new Stack<>();
		
		int i = 0;
		int start = 0;
		while(i < goal.length) {
			int value = goal[i];
			
			if(value > start) {
				for(int j=start+1; j<=value; j++) {
					stack.push(j);
					sb.append("+\n");
				}
				start = value;
			} else if(stack.peek() != value) {
				sb = new StringBuilder("NO");
				return; 
			}
			
			stack.pop();
			sb.append("-\n");
			
			i++;
		}
		
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		sb = new StringBuilder();
		
		int[] sequence = new int[N];
		for(int i=0; i<N; i++)
			sequence[i] = Integer.parseInt(br.readLine());
		
		stackSeq(sequence);
		System.out.println(sb);
	}
}
