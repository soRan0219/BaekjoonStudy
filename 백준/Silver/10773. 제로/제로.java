import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int size = Integer.parseInt(br.readLine());
		
		Stack<Integer> s = new Stack<>();
		
		for(int i=0; i<size; i++) {
			int data = Integer.parseInt(br.readLine());
			if(data == 0) {
				s.pop();
			} else {
				s.push(data);
			}
		}
		
		Iterator it = s.iterator();
		int sum = 0;
		
		while(it.hasNext()) {
			sum += (int)it.next();
		}
		System.out.println(sum);
		
	}

}
