class Solution {
    int answer;
    boolean[] visited;
    
    public boolean checkWords(String a, String b) {
		int match = 0;
		for(int i=0; i<a.length(); i++) {
			if(a.charAt(i) == b.charAt(i)) match++;
		}
		
		if(match == a.length()-1) return true;
		return false;
	}
    
    public void dfs(int count, String begin, String target, String[] words) {
		if(begin.equals(target)) {
			answer = Math.min(answer, count);
		}
		
		for(int i=0; i<words.length; i++) {
			if(visited[i] || !checkWords(begin, words[i]) || answer<=count) continue;
			
			visited[i] = true;
			dfs(count+1, words[i], target, words);
			visited[i] = false;
		}
		
	}
    
    public int solution(String begin, String target, String[] words) {
        answer = Integer.MAX_VALUE;
		visited = new boolean[words.length];
		dfs(0, begin, target, words);
		
		return answer==Integer.MAX_VALUE ? 0 : answer;
    }
}