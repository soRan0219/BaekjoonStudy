import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int[] cards;
    static StringBuilder sb = new StringBuilder();
	
	static void matchNum(int num) {
		int result = 0;
		
		int pl = 0;
		int pr = cards.length-1;
		
		while(pl <= pr) {
			int pc = (pl+pr) / 2;
			if(cards[pc] > num) {
				pr = pc-1;
			} else if(cards[pc] <= num) {
				pl = pc + 1;
				if(cards[pc] == num) {
					result = 1;
					break;
				}
			}
		}
		sb.append(result + " ");
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		cards = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i=0; i<n; i++) {
			cards[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(cards);
        
		int m = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		
		for(int i=0; i<m; i++) {
			matchNum(Integer.parseInt(st.nextToken()));
		}
		System.out.println(sb);
	}
}