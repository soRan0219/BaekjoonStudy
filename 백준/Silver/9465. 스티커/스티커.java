import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[][] stickers;
	static int[][] dp;
	
	static int getMaxScore(int[][] arr) {
		dp[0][1] = arr[0][1];
		dp[1][1] = arr[1][1];
		
		for(int i=2; i<=arr[0].length-1; i++) {
			dp[0][i] = Math.max(dp[1][i-1], dp[1][i-2]) + arr[0][i];
			dp[1][i] = Math.max(dp[0][i-1], dp[0][i-2]) + arr[1][i];
		}
		
		return Math.max(dp[0][arr[0].length-1], dp[1][arr[0].length-1]);
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for(int i=0; i<t; i++) {
			int n = Integer.parseInt(br.readLine());
			stickers = new int[2][n+1];
			dp = new int[2][n+1];
			
			for(int j=0; j<2; j++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int k=1; k<=n; k++) {
					stickers[j][k] = Integer.parseInt(st.nextToken());
				}
			}
			sb.append(getMaxScore(stickers) + "\n");
		}
		
		System.out.println(sb);
	}
}
