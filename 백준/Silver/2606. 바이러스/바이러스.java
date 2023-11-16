import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int nodes, conn;
	static List<ArrayList<Integer>> computers = new ArrayList<>();
	static boolean[] visited;
	
	static void virus(int start) {
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(start);
		visited[start] = true;
		
		while(!q.isEmpty()) {
			int now = q.poll();
			
			for(int n : computers.get(now)) {
				if(!visited[n]) {
					q.add(n);
					visited[n] = true;
				}
			}
			
		} //while
		
		int result = 0;
		for(int i=0; i<visited.length; i++) {
			if(visited[i]) result++;
		}
		
		System.out.println(result-1);
	} //virus()
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		nodes = Integer.parseInt(br.readLine());
		visited = new boolean[nodes+1];
		
		for(int i=0; i<nodes+1; i++) {
			computers.add(new ArrayList<Integer>());
		}
		
		conn = Integer.parseInt(br.readLine());
		for(int i=0; i<conn; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int node = Integer.parseInt(st.nextToken());
			int close = Integer.parseInt(st.nextToken());
			
			computers.get(node).add(close);
			computers.get(close).add(node);
		}
		
		virus(1);
		
	} //main()

}
