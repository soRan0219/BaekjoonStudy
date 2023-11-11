import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int N, M, R;
	static List<ArrayList<Integer>> nodes = new ArrayList<>();
	static boolean[] visited;
	static List<Integer> result = new ArrayList<>();
	
	static void dfs(int r, int depth) {
		
		visited[r] = true;
		result.set(r, depth++);
		
		for(int i=nodes.get(r).size()-1; i>=0; i--) {
			if(!visited[nodes.get(r).get(i)])
				dfs(nodes.get(r).get(i), depth);
		}
		
	} //dfs()
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		
		visited = new boolean[N+1];
		
		for(int i=0; i<N+1; i++) {
			result.add(-1);
		}
		
		for(int i=0; i<N+1; i++) {
			nodes.add(new ArrayList<>());
		}
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int node = Integer.parseInt(st.nextToken());
			int close = Integer.parseInt(st.nextToken());
			
			nodes.get(node).add(close);
			nodes.get(close).add(node);
		}
		
		for(int i=0; i<N+1; i++) {
			Collections.sort(nodes.get(i));
		}
		
		int depth = 0;
		dfs(R, depth);
		
		for(int i=1; i<result.size(); i++) {
			System.out.println(result.get(i));
		}
		
	} //main()

}
