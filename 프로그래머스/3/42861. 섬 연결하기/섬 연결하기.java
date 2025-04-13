import java.util.Arrays;

class Solution {
    static int[] parent;
	
	//Union-Find 알고리즘: 부모노드 찾기
	static int find(int a) {
		if(parent[a] == a) return a;
		return find(parent[a]);
	}
	
	//Union-Find 알고리즘: 두 노드를 하나의 집합으로 합치기
	static void union(int a, int b) {
		a = find(a);
		b = find(b);
		if(a < b) parent[b] = a;
		else parent[a] = b;
	}
	
	//Kruskal 알고리즘: 최소신장트리 구하기
	static int solution(int n, int[][] costs) {
		int answer = 0;
		parent = new int[n];
		
		for(int i=0; i<n; i++) parent[i] = i;
		Arrays.sort(costs, (o1, o2) -> Integer.compare(o1[2], o2[2]));
		
		for(int[] cost : costs) {
			if(find(cost[0]) != find(cost[1])) {
				union(cost[0], cost[1]);
				answer += cost[2];
			}
		}
		
		return answer;
	}
}