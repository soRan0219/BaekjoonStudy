class Solution {
    static int answer;
	static char[] vowels = {'A', 'E', 'I', 'O', 'U'};
	static boolean[][] visited;
	static boolean found;
	
	static void dfs(String target, StringBuilder now, int depth) {
		if(now.toString().equals(target)) {
			found = true;
			return;
		}
		
		if(depth == 5) return;
		
		for(int i=0; i<vowels.length; i++) {
			if(found) break;
			
			if(!visited[depth][i]) {
				visited[depth][i] = true;
				answer++;
				
				dfs(target, now.append(vowels[i]), depth+1);
				visited[depth][i] = false;
				now.deleteCharAt(now.length()-1);
			}
		}
	}
	
	static int solution(String word) {
		answer = 0;
		visited = new boolean[5][5];
		StringBuilder now = new StringBuilder("");
		
		dfs(word, now, 0);
		
		return answer;
	}
}