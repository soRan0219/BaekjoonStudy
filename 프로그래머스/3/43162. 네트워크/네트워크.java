import java.util.LinkedList;
import java.util.Queue;

public class Solution {
	static boolean[] visited;
	
	static int solution(int n, int[][] computers) {
		int answer = 0;
		visited = new boolean[computers.length];
		
		for(int i=0; i<n; i++) {
			if(!visited[i]) {
				bfs(i, computers);
				answer++;
			}
		}
		
		return answer;
	}
	
	static void bfs(int idx, int[][] computers) {
		Queue<int[]> que = new LinkedList<>();
		
		que.offer(computers[idx]);
		visited[idx] = true;
		
		while(!que.isEmpty()) {
			int[] now = que.poll();
			
			for(int i=0; i<now.length; i++) {
				if(!visited[i] && now[i]==1) {
					que.offer(computers[i]);
					visited[i] = true;
				} 
			}
		}
		
	}
}
