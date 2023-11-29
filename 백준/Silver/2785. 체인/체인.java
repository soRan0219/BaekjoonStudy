import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	
	static int chaining(List<Integer> chains) {
		int result = 0;
		Collections.sort(chains);
		
		while(chains.size() > 1) {
			chains.set(0, chains.get(0)-1);
			chains.remove(chains.size()-1);
			if(chains.get(0)==0) chains.remove(0);
			result++;
		}
		
		return result;
	} //chaining()
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
//		int[] chains = new int[n];
		List<Integer> chains = new ArrayList<>();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++)
			chains.add(Integer.parseInt(st.nextToken()));
		
		System.out.println(chaining(chains));
		
	} //main()
}
