import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	static int N, M, R;
	static List<ArrayList<Integer>> nodes = new ArrayList<>();
	static boolean[] visited;
	
	static void dfs(int r) {
		Stack<Integer> stack = new Stack<>();
		int cnt = 0;
		int result[] = new int[N+1];
		
		stack.push(r);
		
		while(!stack.isEmpty()) {
			int now = stack.pop();
			if(!visited[now])
				result[now] = ++cnt;
			visited[now] = true;
			
			for(int i=nodes.get(now).size()-1; i>=0; i--) {
				int next = nodes.get(now).get(i);
				
				if(!visited[next]) {
					stack.push(next);
				}
			}
		} //while
		
		for(int i=1; i<result.length; i++) {
			System.out.println(result[i]);
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
		
		dfs(R);
		
	} //main()

}
