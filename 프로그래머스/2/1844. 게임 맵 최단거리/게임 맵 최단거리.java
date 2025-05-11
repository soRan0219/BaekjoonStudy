import java.util.LinkedList;
import java.util.Queue;

class Solution {
    static int answer;
	static int n, m;
	
	static boolean[][] visited;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, 1, -1};
	
	static void bfs(int[][] maps, int idx1, int idx2) {
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] {idx1, idx2, 1});
		visited[idx1][idx2] = true;
		
		while(!q.isEmpty()) {
			int now[] = q.poll();
			idx1 = now[0];
			idx2 = now[1];
			int count = now[2];
						
			//if(idx1==0 && idx2==0) {
            if(idx1==n-1 && idx2==m-1) {
				answer = count;
				break;
			}
			
			for(int i=0; i<dx.length; i++) {
				int x = idx1 + dx[i];
				int y = idx2 + dy[i];
								
				if(x>=0 && x<n && y>=0 && y<m) {
					if(!visited[x][y] && maps[x][y]==1) {
						visited[x][y] = true;
						q.offer(new int[] {x, y, count+1});
					}
				}
			}
			
		}
	}
    public int solution(int[][] maps) {
        answer = -1;
        n = maps.length;
		m = maps[0].length;
		visited = new boolean[n][m];
		
		//bfs(maps, n-1, m-1);
        bfs(maps, 0, 0);
        
        return answer;
    }
}