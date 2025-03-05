class Solution {
    static int answer;
	static boolean[] visited;
	
	static void dfs(int k, int[][] dungeons, int cnt) {
		answer = Math.max(answer, cnt);
		
		for(int i=0; i<dungeons.length; i++) {
			if(!visited[i] && k>=dungeons[i][0]) {
				visited[i] = true;
                k -= dungeons[i][1];
				dfs(k, dungeons, cnt+1);
				visited[i] = false;
				k += dungeons[i][1];
			}
		}
	}
	
	static int solution(int k, int[][] dungeons) {
		answer = -1;
		visited = new boolean[dungeons.length];
		
		dfs(k, dungeons, 0);
		
		return answer;
	}
}