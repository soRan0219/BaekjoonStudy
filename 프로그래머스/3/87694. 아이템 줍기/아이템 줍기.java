import java.util.LinkedList;
import java.util.Queue;

class Solution {
    static int answer;
	static int[][] map;
	static boolean[][] visited;
	
	static int[] dx = {0, 0, 1, -1};
	static int[] dy = {1, -1, 0, 0};
	
	//좌표와 현재까지 이동거리 저장할 내부 클래스
	static class Point {
		int x, y, distance;
		Point(int x, int y, int distance) {
			this.x = x;
			this.y = y;
			this.distance = distance;
		}
	}
	
	static void bfs(int cX, int cY, int iX, int iY) {
		visited = new boolean[102][102];
		Queue<Point> q = new LinkedList<>();
		q.offer(new Point(cX, cY, 0));
		visited[cX][cY] = true;
		
		while(!q.isEmpty()) {
			Point now = q.poll();
			
			//목표에 도달하면 바로 반환
			// (가능한 2가지 경로 중 빨리 도착하는 쪽)
			if(now.x==iX && now.y==iY) {
				answer = now.distance/2;
				return;
			}
			
			//현재 지점에서 동서남북 중 테두리 방향 따라 진행
			for(int i=0; i<4; i++) {
				int nx = now.x + dx[i];
				int ny = now.y + dy[i];
				
				if(!visited[nx][ny] && map[nx][ny]==1) {
					visited[nx][ny] = true;
					q.offer(new Point(nx, ny, now.distance+1));
				}
			}
		}
	}
	
	static int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
		answer = 0;
		//도형 크기 2배로 키우기
		map = new int[102][102];
		
		//도형 모양만큼 모두 1로 채우기
		for(int[] r : rectangle) {
			for(int i=r[0]*2; i<=r[2]*2; i++) {
				for(int j=r[1]*2; j<=r[3]*2; j++) {
					map[i][j] = 1;
				}
			}
		}
		//테두리만 1로 남기고 나머지 다 0으로 채우기
		for(int[] r : rectangle) {
			for(int i=r[0]*2+1; i<=r[2]*2-1; i++) {
				for(int j=r[1]*2+1; j<=r[3]*2-1; j++) {
					map[i][j] = 0;
				}
			}
		}
		
		bfs(characterX*2, characterY*2, itemX*2, itemY*2);
		
		return answer;
	}
}