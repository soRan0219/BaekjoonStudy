import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, M, R;
	static boolean visited[];
	static List<ArrayList<Integer>> nodes = new ArrayList<>();
	
	static void getDepth(int r) {
		Queue<Integer> queue = new LinkedList<Integer>();
		int[] depth = new int[N+1];
		Arrays.fill(depth, -1);
		
		queue.add(r);
		visited[r] = true;
		depth[r] = 0;
		
		while(!queue.isEmpty()) {
			int now = queue.poll();
			
			for(int i=0; i<nodes.get(now).size(); i++) {
				int next = nodes.get(now).get(i);
				if(!visited[next]) {
					queue.add(next);
					visited[next] = true;
					depth[next] = depth[now] + 1;
				}
			}
		} //while
		
		for(int i=1; i<depth.length; i++) {
			System.out.println(depth[i]);
		}
	} //getDepth()
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		
		visited = new boolean[N+1];
		for(int i=0; i<N+1; i++) {
			nodes.add(new ArrayList<Integer>());
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
		
		getDepth(R);
		
	} //main()

}
