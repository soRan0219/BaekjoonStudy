import java.util.*;

public class Main {
	static char[][] stars;
	
	static void draw(int r, int c, int n) {
		if(n == 3) {
			//가장 작은 삼각형일 때
			stars[r][c] = '*';
			stars[r+1][c-1] = stars[r+1][c+1] = '*';
			stars[r+2][c-2] = stars[r+2][c-1] = stars[r+2][c] = stars[r+2][c+1] = stars[r+2][c+2] = '*';  
		} else {
			//n이 3보다 클 때
			// => 작은삼각형 3개로 쪼개기
			int cut = n/2;
			draw(r, c, cut);
			draw(r+cut, c-cut, cut);
			draw(r+cut, c+cut, cut);
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.close();
		
		stars = new char[n][2*n-1];
		for(int i=0; i<n; i++)
			Arrays.fill(stars[i], ' ');
		
		//꼭대기 별 위치: [0][n-1]
		// (2*n-1)/2 랑 n-1이랑 같음
//		draw(0, (2*n-1)/2, n);
		draw(0, n-1, n);
		
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<n; i++) {
			for(char s : stars[i])
				sb.append(s);
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
