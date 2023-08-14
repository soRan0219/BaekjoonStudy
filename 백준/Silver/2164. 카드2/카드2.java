import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int num = s.nextInt();
		Queue<Integer> cards = new LinkedList<>();
		
		for(int i=1; i<=num; i++) {
			cards.add(i);
		}
		
		int i = 1;
		while(!cards.isEmpty()) {
			if(cards.size()==1) {
				System.out.println(cards.poll());
			} else {
				if(i%2 != 0) {
					cards.poll();
				} else {
					int x = cards.poll();
					cards.add(x);
				}
			}
			i++;
		}
		
	}

}
