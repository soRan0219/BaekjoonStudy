import java.util.*;

class Solution {
    static boolean[][] visited;
	
	//좌표 저장을 위한 Point 클래스
	//keySet 비교 위해 equals()와 hashCode() 구현
	static class Point {
		int x, y;
		
		Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
		public boolean equals(Object o) {
			Point p = (Point) o;
			if(this.x==p.x && this.y==p.y) return true;
			return false;
		}
		
		public int hashCode() {
			int prime = 31;
			int hashcode = 1;
			
			hashcode = prime * hashcode + this.x;
			hashcode = prime * hashcode + this.y;
			
			return hashcode;
		}
	}
	
	static int solution(int[] arrows) {
		int answer = 0;
		//2차원 배열 위에서 움직이기 위해 가로세로 길이와 시작점 구하기
		int width = 0, height = 0;
		int maxW = 0, minW = 0, maxH = 0, minH = 0;
		
		//오른쪽 방향으로 가면 가로길이 증가, 왼쪽 방향으로 가면 가로길이 감소
		// (위, 아래도 마찬가지로 세로길이 조절)
		//가로, 세로, 위, 아래 조절하면서 각각 max와 min값 갱신
		for(int a : arrows) {
			if(a==0 || a==1 || a==7) height++;
			maxH = Math.max(maxH, height);
			if(a==3 || a==4 || a==5) height--;
			minH = Math.min(minH, height);
			if(a==1 || a==2 || a==3) width++;
			maxW = Math.max(maxW, width);
			if(a==5 || a==6 || a==7) width--;
			minW = Math.min(minW, width);
		}
		
		//시작점 좌표값 (x, y)와 가로세로 값 구하기
		int x = maxH, y = -minW;
		width = maxW - minW + 1;
		height = maxH - minH + 1;
		
		//특정 좌표 (x, y)와 연결된 좌표들을 저장하기 위한 Map
		Map<Point, ArrayList<Point>> connect = new HashMap<>();
		connect.put(new Point(x, y), new ArrayList<>());
		
		visited = new boolean[height][width];
		visited[x][y] = true;
		
		for(int a : arrows) {
			int preX = x, preY = y;
			
			//이동방향에 따라 x, y 조절
			if(a==0 || a==1 || a==7) x--;
			if(a==3 || a==4 || a==5) x++;
			if(a==1 || a==2 || a==3) y++;
			if(a==5 || a==6 || a==7) y--;
			
			//시작지점과 옮겨진 지점 
			Point pre = new Point(preX, preY);
			Point now = new Point(x, y);
			
			//방문한 적 없는 점이면 Map에 현재 좌표 추가
			if(!connect.containsKey(now)) connect.put(now, new ArrayList<>());
			
			//방이 만들어지는 경우
			//1. 방문한 적 있으면서 지나온 경로는 아닌 경우
			if(visited[x][y] && !connect.get(now).contains(pre)) answer++;
			
			//2. 대각선으로 교차하는 경우
			if(!connect.get(now).contains(pre)) { //지나온 경로가 아니어야 함
				if(a==7 && connect.containsKey(new Point(x+1, y))) 
					if(connect.get(new Point(x+1, y)).contains(new Point(x, y+1))) answer++;
				if(a==5 && connect.containsKey(new Point(x-1, y))) 
					if(connect.get(new Point(x-1, y)).contains(new Point(x, y+1))) answer++;
				if(a==3 && connect.containsKey(new Point(x-1, y))) 
					if(connect.get(new Point(x-1, y)).contains(new Point(x, y-1))) answer++;
				if(a==1 && connect.containsKey(new Point(x, y-1))) 
					if(connect.get(new Point(x, y-1)).contains(new Point(x+1, y))) answer++;
			}
			
			if(!visited[x][y]) visited[x][y] = true;
			
			//점 연결(Map에 넣기)
			connect.get(now).add(pre);
			connect.get(pre).add(now);
		}
		
		return answer;
	}
}