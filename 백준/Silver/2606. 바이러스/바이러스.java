import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static List<ArrayList<Integer>> computers = new ArrayList<>();
	
	static int getInfected(int num) {
		boolean[] visited = new boolean[N+1];
		Queue<Integer> que = new LinkedList<Integer>();
		int result = 0;
		
		que.add(num);
		visited[num] = true;
		
		while(!que.isEmpty()) {
			int infected = que.poll();
			for(int i=0; i<computers.get(infected).size(); i++) {
				int next = computers.get(infected).get(i);
				if(!visited[next]) {
					que.add(next);
					visited[next] = true;
					result++;
				}
			}
		}
		
		return result;
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		
		for(int i=0; i<N+1; i++)
			computers.add(new ArrayList<Integer>());
		
		for(int i=0; i<m; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n1 = Integer.parseInt(st.nextToken());
			int n2 = Integer.parseInt(st.nextToken());
			
			computers.get(n1).add(n2);
			computers.get(n2).add(n1);
		}
		
		System.out.println(getInfected(1));
	}
}
