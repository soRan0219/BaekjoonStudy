import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static int getMaxMeetings(int[][] meetings) {
		int result = 1;
		
		Arrays.sort(meetings, ((x, y) -> {
			if(x[1] == y[1])
				return x[0] - y[0];
			return x[1] - y[1];
		}));
		
		int endTime = meetings[0][1];
		for(int i=1; i<meetings.length; i++) {
			if(meetings[i][0] < endTime) continue;
			result++;
			endTime = meetings[i][1];
		}
		
		return result;
	} //getMaxMeetings()
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[][] meetings = new int[n][2];
		
		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			meetings[i][0] = Integer.parseInt(st.nextToken());
			meetings[i][1] = Integer.parseInt(st.nextToken());
		}
		
		System.out.println(getMaxMeetings(meetings));
		
	} //main()
}
