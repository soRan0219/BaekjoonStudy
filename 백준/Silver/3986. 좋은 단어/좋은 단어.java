import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	
	static int rightwords(String[] words) {
		
		int result = 0;
		
		for(String w : words) {
			Stack<Character> s = new Stack<>();
			for(int i=0; i<w.length(); i++) {
				if(s.empty()) {
					s.push(w.charAt(i));
				} else {
					if(w.charAt(i)==s.peek()) {
						s.pop();
					} else {
						s.push(w.charAt(i));
					}
				}
			}
			if(s.empty())
				result++;
		}
		
		return result;
	} //rightwords()
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] words = new String[Integer.parseInt(br.readLine())];
		
		for(int i=0; i<words.length; i++) {
			words[i] = br.readLine();
		}
		System.out.println(rightwords(words));
		
	} //main()

}
