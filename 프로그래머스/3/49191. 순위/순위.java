import java.util.*;

class Solution {
    static int[][] graph;
	
	//나보다 강한(약한) 선수의 수 구하기
	static Set<Integer> dfs(Set<Integer> set, int player, int flag) {
		for(int i=1; i<graph[player].length; i++) {
			if(graph[player][i]==flag && !set.contains(i)) {
				set.add(i);
				dfs(set, i, flag);
			}
		}
		return set;
	}
	
	static int solution(int n, int[][] results) {
		int answer = 0;
		graph = new int[n+1][n+1];
		
		for(int i=0; i<results.length; i++) {
			int winner = results[i][0];
			int loser = results[i][1];
			//나보다 약한 선수는 1, 강한 선수는 -1
			graph[winner][loser] = 1;
			graph[loser][winner] = -1;
		}
		
		for(int i=1; i<=n; i++) {
			//i번 선수보다 강한선수 Set(중복제거)
			Set<Integer> stronger = new HashSet<>();
			//i번 선수보다 약한선수 Set(중복제거)
			Set<Integer> weaker = new HashSet<>();
			//각자 몇명인지 구함
			// 만약에 1이 2를 이기고 2가 3을 이기면 1이 3보다 강하다는 것 고려
			int strong = dfs(stronger, i, -1).size();
			int weak = dfs(weaker, i, 1).size();
			
			//강한선수와 약한선수 합이 n-1과 같다면 순위를 알 수 있음
			if(strong+weak == n-1) answer++;
		}
		
		return answer;
	}
}