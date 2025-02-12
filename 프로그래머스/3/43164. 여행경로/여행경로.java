class Solution {
    String answer;
	boolean[] visited;
	
	public void dfs(String[][] tickets, String path, String key, int depth) {
		if(depth == visited.length) {
			answer = answer.compareTo(path)>0 ? path : answer;
			return;
		}
		
		for(int i=0; i<tickets.length; i++) {
			if(tickets[i][0].equals(key) && !visited[i]) {
				visited[i] = true;
				dfs(tickets, path + " " + tickets[i][1], tickets[i][1], depth+1);
				visited[i] = false;
			}
		}
	}
	
	public String[] solution(String[][] tickets) {
		answer = "J";
		visited = new boolean[tickets.length];
		
		dfs(tickets, "ICN", "ICN", 0);
		
		return answer.split(" ");
	}
}