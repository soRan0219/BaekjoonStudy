import java.io.*;
import java.util.*;

class TomatoLoc {
	int x, y, z;
	
	public TomatoLoc(int x, int y, int z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
}

public class Main {
	static int M, N, H;
	static int[][][] box;
	static Queue<TomatoLoc> q = new LinkedList<>();
	static int[] dx = {0, 0, 0, 0, 1, -1};
	static int[] dy = {0, 0, 1, -1, 0, 0};
	static int[] dz = {1, -1, 0, 0, 0, 0};
	
	static void bfs() {
		while(!q.isEmpty()) {
			TomatoLoc pre = q.poll();
			for(int i=0; i<6; i++) {
				int newX = pre.x + dx[i];
				int newY = pre.y + dy[i];
				int newZ = pre.z + dz[i];
				
				if((newX>=0 && newX<N) && (newY>=0 && newY<M) && (newZ>=0 && newZ<H)) {
					if(box[newZ][newX][newY] == 0) {
						q.add(new TomatoLoc(newX, newY, newZ));
						box[newZ][newX][newY] = box[pre.z][pre.x][pre.y] + 1;
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
		H = Integer.parseInt(st.nextToken());
		box = new int[H][N][M];
		
		for(int i=0; i<H; i++) {
			for(int j=0; j<N; j++) {
				st = new StringTokenizer(br.readLine());
				for(int k=0; k<M; k++) {
					box[i][j][k] = Integer.parseInt(st.nextToken());
					if(box[i][j][k] == 1) q.add(new TomatoLoc(j, k, i));
				}
			}
		}
		
		bfs();
		
		boolean ripen = true;
		int max = -1;
		for(int i=0; i<H; i++) {
			for(int j=0; j<N; j++) {
				for(int k=0; k<M; k++) {
					if(box[i][j][k] == 0) ripen = false;
					max = Math.max(max, box[i][j][k]);
				}
			}
		}
		
		if(ripen) System.out.println(max-1);
		else System.out.println(-1);
	}
}
