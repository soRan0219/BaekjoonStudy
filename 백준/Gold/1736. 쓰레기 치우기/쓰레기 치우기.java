import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n;
    static int m;
    static int trash;
    static int[][] room;
    
	static void clean(int x, int y) {
		
        if(x==n-1 && y==m-1) {
            if(room[x][y] == 1) {
                trash--;
                room[x][y] = 0;
            }
            return ;
        }
        
		for(int i=x; i<n; i++) {
			for(int j=y; j<m; j++) {
                if(room[i][j] == 1) {
                    trash--;
                    room[i][j] = 0;
                    clean(i, j);
                    return ;
                }
			}
		} //for
		
	} //clean()
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		room = new int[n][m];
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<m; j++) {
				room[i][j] = Integer.parseInt(st.nextToken());
                if(room[i][j] == 1) trash++;
			}
		}
		
        int result = 0;
        while(trash > 0) {
            result++;
            if(room[0][0] == 1) {
                trash--;
                room[0][0] = 0;
            }
            clean(0, 0);
        }
		
        System.out.println(result);
	} //main()
}
