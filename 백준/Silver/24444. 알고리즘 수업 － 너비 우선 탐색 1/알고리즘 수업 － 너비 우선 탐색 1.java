import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, M, R;
	static boolean visited[];
	static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
	
	static void bfs(int r) {
		Queue<Integer> queue = new LinkedList<>();
		int cnt = 0;
		int result[] = new int[N+1];
		queue.add(r);
		visited[r] = true;
		result[r] = ++cnt;
		
		while(!queue.isEmpty()) {
			int now = queue.poll();
			
			for(int i=0; i<graph.get(now).size(); i++) {
				int next = graph.get(now).get(i);
				if(!visited[next]) {
					queue.add(next);
					visited[next] = true;
					result[next] = ++cnt;
				}
			}
		} //while
		
		for(int i=1; i<result.length; i++) {
			System.out.println(result[i]);
		}
	} //bfs()
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		
		visited = new boolean[N+1];
		for(int i=0; i<N+1; i++) {
			graph.add(new ArrayList<>());
		}
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			
			graph.get(start).add(end);
			graph.get(end).add(start);
		}
		for(int i=0; i<N; i++) {
			Collections.sort(graph.get(i));
		}
		
		bfs(R);
		
	} //main()

}
