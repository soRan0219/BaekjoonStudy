import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static List<ArrayList<Integer>> family = new ArrayList<>();
	static boolean[] visited;
	
	static int getChonsu(int x, int y, int d) {
		int result = -1;
		visited[x] = true;
		
		if(x == y) {
			return d;
		} else { //x != y
			for(int f : family.get(x)) {
				if(!visited[f]) {
					result = getChonsu(f, y, d+1);
					if(result != -1) break;
				}
			}
			return result;
		}
		
	} //getChonsu()
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(br.readLine());
		
		visited = new boolean[N+1];
		for(int i=0; i<N+1; i++) {
			family.add(new ArrayList<>());
		}
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int node = Integer.parseInt(st.nextToken());
			int close = Integer.parseInt(st.nextToken());
			
			family.get(node).add(close);
			family.get(close).add(node);
		}
		
		for(int i=0; i<N+1; i++) {
			Collections.sort(family.get(i));
		}
		
		int d = 0;
		System.out.println(getChonsu(x, y, d));
		
	} //main()

}
