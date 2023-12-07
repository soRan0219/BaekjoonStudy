import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	static int search(String doc, String word) {
		int cnt = 0;
		
		while(doc.indexOf(word) >= 0) {
			cnt++;
			doc = doc.substring(doc.indexOf(word)+word.length());
		}
		
		return cnt;
	} //search()
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		String doc = br.readLine();
		String word = br.readLine();
		
		System.out.println(search(doc, word));
		
	} //main()
}
