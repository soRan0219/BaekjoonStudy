import java.util.*;

public class Main {
	static int N;
	static Queue<Integer> queue;
	
	static void getJosephus(int k) {
		StringBuilder sb = new StringBuilder();
		sb.append("<");
		
		int i = 1;
		while(!queue.isEmpty()) {
			if(i != k) {
				queue.add(queue.poll());
				i++;
			} else {
				if(queue.size()==1) sb.append(queue.poll() + ">");
				else sb.append(queue.poll() + ", ");
				i = 1;
			}
		}
		System.out.println(sb);
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		int k = sc.nextInt();
		sc.close();
		
		queue = new LinkedList<Integer>();
		for(int i=1; i<=N; i++)
			queue.add(i);
		
		getJosephus(k);
	}
}
