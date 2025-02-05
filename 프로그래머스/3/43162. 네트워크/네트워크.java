import java.util.LinkedList;
import java.util.Queue;

public class Solution {
	static boolean[] visited;
	
	static int solution(int n, int[][] computers) {
		int answer = 0;
		visited = new boolean[computers.length];
		
		for(int i=0; i<n; i++) {
			if(!visited[i]) {
				bfs(n, i, computers);
				answer++;
			}
		}
		
		return answer;
	}
	
	static void bfs(int n, int idx, int[][] computers) {
		Queue<Integer> que = new LinkedList<Integer>();
		
		que.offer(idx);
		visited[idx] = true;
		
		while(!que.isEmpty()) {
			int now = que.poll();
			
			for(int i=0; i<n; i++) {
				if(!visited[i] && computers[now][i]==1) {
					que.offer(i);
					visited[i] = true;
				} 
			}
		}
		
	}
}
