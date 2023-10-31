import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int whiteNum;
	static int blueNum;
	
	static void getNums(int[][] papers) {
		
		int size = papers.length * papers.length;
		int sum = 0;
		
		for(int i=0; i<papers.length; i++) {
			for(int j=0; j<papers[i].length; j++) {
				sum += papers[i][j];
			}
		}
		
		if(sum == size) {
			blueNum++;
		} else if(sum == 0) {
			whiteNum++;
		} else {
			int half = papers.length / 2;
			if(half >= 1) {
				int[][] sub1 = new int[half][half];
				int[][] sub2 = new int[half][half];
				int[][] sub3 = new int[half][half];
				int[][] sub4 = new int[half][half];
				
				for(int i=0; i<half; i++) {
					for(int j=0; j<half; j++) {
						sub1[i][j] = papers[i][j];
					}
				}
				for(int i=0; i<half; i++) {
					for(int j=half; j<papers.length; j++) {
						sub2[i][j-half] = papers[i][j];
					}
				}
				for(int i=half; i<papers.length; i++) {
					for(int j=0; j<half; j++) {
						sub3[i-half][j] = papers[i][j];
					}
				}
				for(int i=half; i<papers.length; i++) {
					for(int j=half; j<papers.length; j++) {
						sub4[i-half][j-half] = papers[i][j];
					}
				}
				
				getNums(sub1);
				getNums(sub2);
				getNums(sub3);
				getNums(sub4);
			}
			
		} //if-else
		
	} //getNums()
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int size = Integer.parseInt(br.readLine());
		
		int[][] papers = new int[size][size];
		
		for(int i=0; i<papers.length; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<papers[i].length; j++) {
				papers[i][j] = Integer.parseInt(st.nextToken());
			}
		} //for
		
		getNums(papers);
		
		System.out.println(whiteNum);
		System.out.println(blueNum);
		
	} //main()
}
