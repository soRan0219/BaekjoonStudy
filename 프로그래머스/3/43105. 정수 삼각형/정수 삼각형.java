class Solution {
    public int solution(int[][] triangle) {
        int answer = 0;
		int[][] dp = new int[triangle.length][triangle.length];
		
		//우선 dp에 triangle이랑 같은 위치에 같은 값 채우기
		for(int i=0; i<triangle.length; i++) {
			for(int j=0; j<triangle[i].length; j++) dp[i][j] = triangle[i][j];
		}
		
		//바닥(dp의 마지막 행)까지 가는 경로 중 최대값을 저장
		for(int i=1; i<triangle.length; i++) {
			for(int j=0; j<=i; j++) {
				//꼭지점은 끝부분만 쭉 더하면 됨(j가 0이거나 i와 같은 경우)
				//가운데는 대각선 위 값 중 큰값을 더하기
				if(j == 0) dp[i][j] += dp[i-1][j];
				else if(j == i) dp[i][j] += dp[i-1][j-1];
				else dp[i][j] += Math.max(dp[i-1][j-1], dp[i-1][j]);
			}
		}
		
		//바닥(dp 마지막 행)에 있는 수 중 가장 큰 수
		for(int i=0; i<dp[triangle.length-1].length; i++) answer = Math.max(answer, dp[triangle.length-1][i]);
		
		return answer;
    }
}