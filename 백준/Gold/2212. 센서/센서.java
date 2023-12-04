import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static int solution(int[] sensors, int k) {
		int sum = 0;
		
		if(k >= sensors.length) return sum;
		else {
			int[] gaps = new int[sensors.length-1];
			
			for(int i=1; i<sensors.length; i++)
				gaps[i-1] = sensors[i] - sensors[i-1];
			
			Arrays.sort(gaps);
			for(int i=0; i<gaps.length-(k-1); i++) 
				sum += gaps[i];
		}
		return sum;
	} //solution()
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int k = Integer.parseInt(br.readLine());
		int[] sensors = new int[n];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++)
			sensors[i] = Integer.parseInt(st.nextToken());
		
		Arrays.sort(sensors);
		
		System.out.println(solution(sensors, k));
		
	} //main()
}
