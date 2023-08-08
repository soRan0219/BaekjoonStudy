import java.util.Arrays;
import java.util.Scanner;

public class Main {
	
	static void hasCard(int[] cards, int[] comp) {
		Arrays.sort(cards);
		
		for(int c : comp) {
			int idx = Arrays.binarySearch(cards, c);
			if(idx >= 0) {
				System.out.print(1 + " ");
			} else {
				System.out.print(0 + " ");
			}
		}
	}
	
	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		int[] cards = new int[s.nextInt()];
		
		for(int i=0; i<cards.length; i++) {
			cards[i] = s.nextInt();
		}
		
		int[] comp = new int[s.nextInt()];
		
		for(int i=0; i<comp.length; i++) {
			comp[i] = s.nextInt();
		}
		
		hasCard(cards, comp);
		
	}
}
