import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	
	//lowerBound: 찾는 값보다 같거나 큰 첫번째 요소의 인덱스 반환
	static int lowerBound(List<Integer> data, int key) {
		int pl = 0;
		int pr = data.size();
		
		while(pr > pl) {
			int pc = (pl+pr) / 2;
			
			if(data.get(pc) >= key) {
				pr = pc;
			} else {
				pl = pc + 1;
			}
		} 		
		return pr;
	}
	
	//upperBound: 찾는 값보다 큰 첫번째 요소의 인덱스 반환
	static int upperBound(List<Integer> data, int key) {
		int pl = 0;
		int pr = data.size();
		
		while(pr > pl) {
			int pc = (pl+pr) / 2;
			
			if(data.get(pc) <= key) {
				pl = pc + 1;
			} else {
				pr = pc;
			}
		} 
		
		return pr;
	}
	
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		List<Integer> cards = new ArrayList<>();
		int cSize = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<cSize; i++) {
			cards.add(Integer.parseInt(st.nextToken()));
		}
		
		Collections.sort(cards);
		
		int cpSize = Integer.parseInt(br.readLine());
		
		st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
		for(int i=0; i<cpSize; i++) {
			int c = Integer.parseInt(st.nextToken());
			sb.append((upperBound(cards, c) - lowerBound(cards, c)) + " ");
		}
        System.out.print(sb);
		
		
	}
}
