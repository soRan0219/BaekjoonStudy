import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {
	//게임판 빈자리와 블록의 좌표를 저장하기 위함
	static List<List<Point>> brd = new ArrayList<>();
	static List<List<Point>> tbl= new ArrayList<>();
	
	static int[] dx = {0, 0, 1, -1};
	static int[] dy = {1, -1, 0, 0};
	
	//좌표 정렬을 위한 내부 클래스
	static class Point implements Comparable<Point> {
		int x, y;
		Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
		@Override
		public int compareTo(Point o) {
			int res = Integer.compare(this.x, o.x);
			if(res==0) res = Integer.compare(this.y, o.y);
			return res;
		}
	}
	
	static void bfs(int x, int y, int[][] square, boolean[][] visited, List<List<Point>> list) {
		visited[x][y] = true;
		Queue<Point> q = new LinkedList<>();
		q.add(new Point(x, y));
		
		//게임판 빈자리와 블록 좌표를 (0,0) 기준으로 비교하기 위함
		List<Point> sub_list = new ArrayList<>();
		sub_list.add(new Point(0, 0));
		
		while(!q.isEmpty()) {
			Point p = q.poll();
			
			for(int i=0; i<4; i++) {
				int nx = p.x + dx[i];
				int ny = p.y + dy[i];
				
				if(nx<0 || ny<0 || nx>=square.length || ny>=square.length) continue;
				
				if(!visited[nx][ny] && square[nx][ny]==1) {
					visited[nx][ny] = true;
					q.add(new Point(nx, ny));
					//(0,0)기준으로 넣어줌
					sub_list.add(new Point(nx-x, ny-y));
				}
			}
		}
		//tbl 혹은 brd에 각 도형 모양을 (0,0) 기준의 좌표List로 저장
		list.add(sub_list);
	}
	
	static boolean isRotate(List<Point> table, List<Point> board) {
		//오름차순 정렬
		Collections.sort(board);
		
		//90도씩 회전
		for(int i=0; i<4; i++) {
			//table은 회전할때마다 오름차순 정렬
			Collections.sort(table);
			
			int now_x = table.get(0).x;
			int now_y = table.get(0).y;
			
			//회전하면서 좌표가 바뀌므로 다시 (0,0)기준으로 
			for(int j=0; j<table.size(); j++) {
				table.get(j).x -= now_x;
				table.get(j).y -= now_y;
			}
			
			boolean check = true;
			//좌표 비교
			for(int j=0; j<board.size(); j++) {
				if(board.get(j).x!=table.get(j).x || board.get(j).y!=table.get(j).y) {
					check = false;
					break;
				}
			}
			
			if(check) {
				return true;
			} else {
				//90도 회전 (x,y) -> (y, -x)
				for(int j=0; j<table.size(); j++) {
					int tmp = table.get(j).x;
					table.get(j).x = table.get(j).y;
					table.get(j).y = -tmp;
				}
			}
		}
		return false;
	}
	
	static int compareBlock(List<List<Point>> t, List<List<Point>> b, int answer) {
		boolean[] visited = new boolean[b.size()];
		
		//게임판 빈공간과 블록 회전하며 비교
		for(int i=0; i<t.size(); i++) {
			for(int j=0; j<b.size(); j++) {
				//이미 채웠거나 크기가 맞지 않으면 건너뛰기
				if(visited[j] || t.get(i).size()!=b.get(j).size()) continue;
				if(isRotate(t.get(i), b.get(j))) {
					visited[j] = true;
					answer += b.get(j).size();
					break;
				}
			}
		}
		return answer;
	}
	
	static int solution(int[][] board, int[][] table) {
		int answer = 0;
		
		//board와 table의 1과 0 통일하기
		for(int i=0; i<board.length; i++) {
			for(int j=0; j<board[i].length; j++) {
				board[i][j] = board[i][j]==1 ? 0 : 1;
			}
		}
		
		//brd, tbl에 좌표 저장
		boolean[][] visited_brd = new boolean[board.length][board.length];
		boolean[][] visited_tbl = new boolean[table.length][table.length];
		
		for(int i=0; i<board.length; i++) {
			for(int j=0; j<board[i].length; j++) {
				if(board[i][j]==1 && !visited_brd[i][j]) {
					bfs(i, j, board, visited_brd, brd);
				}
				if(table[i][j]==1 && !visited_tbl[i][j]) {
					bfs(i, j, table, visited_tbl, tbl);
				}
			}
		}
		
		return compareBlock(tbl, brd, answer);
	}
	
}
