import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static char[][] stars;
	
	static void drawStar(int r, int c, int N) {
		if(N==3) {
			//k=0인 가장 작은 삼각형일 때
			stars[r][c] = '*';
			stars[r+1][c-1] = stars[r+1][c+1] = '*';
			stars[r+2][c-2] = stars[r+2][c-1] = stars[r+2][c] = stars[r+2][c+1] = stars[r+2][c+2] = '*';
			return;
		} else {
			//큰 삼각형 -> 삼각형 세개로 쪼개기
			int cut = N/2;
			drawStar(r, c, cut); //가장 위 삼각형
			drawStar(r+cut, c-cut, cut); //아래 왼쪽 삼각형
			drawStar(r+cut, c+cut, cut); //아래 오른쪽 삼각형
		}
			
	} //printStar()
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int N = s.nextInt();
		
		stars = new char[N][N*2 - 1];
		for(int i=0; i<N; i++) {
			Arrays.fill(stars[i], ' ');
		}
		
		s.close();
		
		//꼭대기에 찍히는 별 위치 -> [0][N-1]
		//N줄짜리 삼각형
		drawStar(0, N-1, N);
		
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<N; i++) {
			for(int j=0; j<2*N-1; j++) {
				sb.append(stars[i][j]);
			}
			sb.append('\n');
		}
		System.out.println(sb);
		
	} //main()

}
