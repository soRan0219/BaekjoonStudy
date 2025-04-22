import java.util.*;

class Solution {
    static boolean[] visited;
	static List<List<Integer>> graph;
	
	static void bfs(int[] depth) {
		Queue<Integer> q = new LinkedList<>();
		q.add(1);
		visited[1] = true;
		depth[1] = 0;
		
		while(!q.isEmpty()) {
			int now = q.poll();
			
			for(int i=0; i<graph.get(now).size(); i++) {
				int next = graph.get(now).get(i);
				if(!visited[next]) {
					visited[next] = true;
					q.add(next);
					depth[next] = depth[now] + 1;
				}
			}
		}
	}
	
	static int solution(int n, int[][] vertex) {
		int answer = 0;
		visited = new boolean[n+1];
				
		graph = new ArrayList<>();
		for(int i=0; i<=n; i++) graph.add(new ArrayList<Integer>());
		
		for(int i=0; i<vertex.length; i++) {
			graph.get(vertex[i][0]).add(vertex[i][1]);
			graph.get(vertex[i][1]).add(vertex[i][0]);
		}
		
		for(List<Integer> g : graph) Collections.sort(g);;
		
		int[] depth = new int[n+1];
		bfs(depth);
		
		int max = Arrays.stream(depth).max().getAsInt();
		for(int d : depth) {
			if(d == max) answer++;
		}
		
		return answer;
	}
}