import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	
	//찾는 값보다 같거나 큰 첫번째 요소 인덱스
	static int lowerBound(List<Integer> list, int key) {
		int pl = 0;
		int pr = list.size();
		
		while(pl < pr) {
			int pc = (pl+pr) / 2;
			
			if(list.get(pc) >= key) pr = pc;
			else pl = pc +1;
		}
		
		return pr;
	}
	
	//찾는 값보다 큰 첫번째 요소 인덱스
	static int upperBound(List<Integer> list, int key) {
		int pl = 0;
		int pr = list.size();
		
		while(pl < pr) {
			int pc = (pl+pr) / 2;
			
			if(list.get(pc) <= key) pl = pc + 1;
			else pr = pc;
		}
		
		return pr;
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		List<Integer> cards = new ArrayList<>();
		
		for(int i=0; i<n; i++) {
			cards.add(Integer.parseInt(st.nextToken()));
		}
		Collections.sort(cards);
		
		int m = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<m; i++) {
			int key = Integer.parseInt(st.nextToken());
			int isExist = upperBound(cards, key)-lowerBound(cards, key)==0 ? 0 : 1;
			sb.append(isExist + " ");
		}
		
		System.out.println(sb);
	}
}
