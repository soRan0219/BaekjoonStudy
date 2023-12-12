import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static int N;
	
	static long getMinDissatis(int[] expected) {
		Arrays.sort(expected);
		
		long dissatisfaction = 0;
		int[] grades = new int[N];
		
		int elem = 1;
		for(int i=0; i<N; i++) {
			grades[i] = elem++;
			dissatisfaction += Math.abs(expected[i] - grades[i]);
		}
		
		return dissatisfaction;
	} //getMinDissatis()
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		int[] expected = new int[N];
		
		for(int i=0; i<N; i++)
			expected[i] = Integer.parseInt(br.readLine());
		
		System.out.println(getMinDissatis(expected));
		
	} //main()

}
