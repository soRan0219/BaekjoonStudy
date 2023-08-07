import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		//배열 생성
		Scanner scanner = new Scanner(System.in);
		List<Integer> list = new ArrayList<>();
		int size = scanner.nextInt();
		
		for(int i=0; i<size; i++) {
			list.add(scanner.nextInt());
		}
		scanner.close();
		
		//정렬
		Collections.sort(list);
		
		int cnt = 0;
		List<Integer> cntArr = new ArrayList<>();
		for(int i=0; i<size; i++) {
			cnt = 0;
			for(int j=list.get(i); j<list.get(i)+5; j++) {
				if(list.contains(j))
					cnt++;
			}
			cntArr.add(cnt);
		}
		
		System.out.println(5 - Collections.max(cntArr));
		
		
	}
}