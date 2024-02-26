import java.io.*;
import java.util.*;

class Tomato {
	int x, y;
	
	public Tomato(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class Main {
	static int M, N;
	static int[][] box;
	static Queue<Tomato> q = new LinkedList<Tomato>();
	static int[] dx = {1, -1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	
	static void bfs() {
		while(!q.isEmpty()) {
			Tomato start = q.poll();
			for(int i=0; i<4; i++) {
				int newX = start.x + dx[i];
				int newY = start.y + dy[i];
				
				if((newX>=0 && newX<N) && (newY>=0 && newY<M)) {
					if(box[newX][newY] == 0) {
						q.add(new Tomato(newX, newY));
						box[newX][newY] = box[start.x][start.y] + 1;
					}
				}
			}
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()); 
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		box = new int[N][M];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine()); 
			for(int j=0; j<M; j++) {
				box[i][j] = Integer.parseInt(st.nextToken());
				if(box[i][j] == 1) q.add(new Tomato(i, j));
			}
		}
		
		bfs();
		
		boolean ripen = true;
		int max = -1;
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(box[i][j] == 0) ripen = false;
				max = Math.max(max, box[i][j]);
			}
		}
		
		if(ripen) System.out.println(max-1);
		else System.out.println(-1);
		
	}
}
