import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, M, x, y;
	static int cells[][];
	static int cleaned;
	
	//북, 동, 남, 서 순으로 행, 열 좌표이동
	static int dx[] = {-1, 0, 1, 0};
	static int dy[] = {0, 1, 0, -1};
	
	static void clean(int x, int y, int dir) {
		
		cells[x][y] = -1;
		
		//반시계 방향으로 탐색
		for(int i=0; i<4; i++) {
			dir = (dir+3) % 4; //반시계(왼쪽) 방향으로 방향 바꾸기
			int nx = x + dx[dir];
			int ny = y + dy[dir];
			
			//청소 안된 곳 있으면 청소하기
			if(nx>=0 && ny>=0 && nx<N && ny <M && cells[nx][ny]==0) {
				cleaned++;
				clean(nx, ny, dir);
				return; //return 없으면 복귀 도중 뒤로 가서 다른 곳 청소할 수 있음
			}
		}
		
		//후진
		int d = (dir+2) % 4;
		int bx = x + dx[d];
		int by = y + dy[d];
		if(bx>=0 && by>=0 && bx<N && by<M && cells[bx][by]!=1) {
			clean(bx, by, dir); //후진이니까 방향은 그대로
		}
		
	} //clean()
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		cells = new int[N][M];
		
		st = new StringTokenizer(br.readLine());
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		int dir = Integer.parseInt(st.nextToken());
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				cells[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		cleaned = 1;
		
		clean(x, y, dir);
		System.out.println(cleaned);
		
	} //main()

}
