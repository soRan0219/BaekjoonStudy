import java.util.*;

class Solution {
    static boolean[][] graph;
	
	static int bfs(int n, int start) {
		boolean[] visited = new boolean[n+1];
		int cnt = 1;
		
		Queue<Integer> q = new LinkedList<>();
		q.offer(start);
		visited[start] = true;
		
		while(!q.isEmpty()) {
			int now = q.poll();
			
			for(int i=1; i<=n; i++) {
				if(graph[now][i] && !visited[i]) {
					visited[i] = true;
					q.offer(i);
					cnt++;
				}
			}
		}
		
		return Math.abs(cnt - (n-cnt));
	}
	
	static int solution(int n, int[][] wires) {
		int answer = n;
		graph = new boolean[n+1][n+1];
		
		for(int i=0; i<wires.length; i++) {
			int from = wires[i][0];
			int to = wires[i][1];
			graph[from][to] = true;
			graph[to][from] = true;
		}
		for(int i=0; i<wires.length; i++) {
			int from = wires[i][0];
			int to = wires[i][1];
			
			graph[from][to] = false;
			graph[to][from] = false;
			
			answer = Math.min(answer, bfs(n, from));
			
			graph[from][to] = true;
			graph[to][from] = true;
		}
		
		return answer;
	}
}