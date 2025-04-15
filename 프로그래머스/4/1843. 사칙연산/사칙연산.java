class Solution {
    static int calculate(int a, String op, int b) {
		if(op.equals("+")) return a + b;
		return a - b;
	}
	
//	길이 2인 a, b 구간이 있을 때 최대 최소는
//	a + b 최대: a최대, b최대
//	a + b 최소: a최소, b최소
//	a - b 최대: a최대, b최소
//	a - b 최소: a최소, b최대
//	a, b구간의 최대, 최소값을 저장하기 위해 dp[a][b][0], dp[a][b][1] 3차원 배열 사용
//	https://dev-ljw1126.tistory.com/456 설명 참고
	
	static int solution(String[] arr) {
		//1. 숫자와 연산자 따로따로 배열 만들어서 넣어주기
		int n = arr.length/2 + 1;
		int op = arr.length - n;
		int[] numbers = new int[n+1];
		String[] operators = new String[op+1];
		
		int idx1 = 1;
		int idx2 = 1;
		for(int i=0; i<arr.length; i++) {
			if(i%2 == 0) numbers[idx1++] = Integer.parseInt(arr[i]);
			else operators[idx2++] = arr[i];
		}
		
		//2. 구간별 최대, 최소값을 저장하기 위해 3차원 배열 dp 사용
		int[][][] dp = new int[n+1][n+1][2];
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=n; j++) {
				dp[i][j][0] = Integer.MAX_VALUE; //최소값
				dp[i][j][1] = Integer.MIN_VALUE; //최대값
			}
		}
		
		//2-1. 첫 자리는 자기 자신으로 초기화
		for(int i=1; i<=n; i++) {
			dp[i][i][0] = numbers[i];
			dp[i][i][1] = numbers[i];
		}
		
		//2-2. 구간(len)별 최대, 최소값 구하기
		for(int len=2; len<=n; len++) {
			//i: 구간 처음값, j: 구간 마지막값
			//k: 분할기준 ( 1-(3+5)인지 (1-3)+5인지 )
			for(int i=1; i<=n-len+1; i++) {
				int j = i + len - 1;
				for(int k=i; k<j; k++) {
					int v1 = calculate(dp[i][k][0], operators[k], dp[k+1][j][0]);
					int v2 = calculate(dp[i][k][0], operators[k], dp[k+1][j][1]);
					int v3 = calculate(dp[i][k][1], operators[k], dp[k+1][j][0]);
					int v4 = calculate(dp[i][k][1], operators[k], dp[k+1][j][1]);
					
					int min = Math.min(v1, Math.min(v2, Math.min(v3, v4)));
					int max = Math.max(v1, Math.max(v2, Math.max(v3, v4)));
					
					dp[i][j][0] = Math.min(dp[i][j][0], min);
					dp[i][j][1] = Math.max(dp[i][j][1], max);
				}
			}
		}
		
		//3. 1부터 n(마지막 숫자)의 구간 중 최대값 반환
		return dp[1][n][1];
	}
}