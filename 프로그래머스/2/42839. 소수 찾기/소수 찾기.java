import java.util.*;

class Solution {
    static boolean[] visited;
	static Set<Integer> set;
	
	static void dfs(String numbers, int depth, String now) {
		if(depth == numbers.length()) return;
		
		for(int i=0; i<numbers.length(); i++) {
			if(!visited[i]) {
				visited[i] = true;
				set.add(Integer.parseInt(now + numbers.charAt(i)));
				dfs(numbers, depth+1, now+numbers.charAt(i));
				visited[i] = false;
			}
		}
	}
	
	static boolean isPrime(int n) {
		if(n < 2) return false;
		
		for(int i=2; i<=Math.sqrt(n); i++) {
			if(n%i == 0) return false;
		}
		
		return true;
	}
	
	public static int solution(String numbers) {
		int len = numbers.length(); 
		visited = new boolean[len];
		set = new HashSet<>();
		
        int answer = 0;
        String arr[] = new String[len];
        
        for(int i=0; i<len; i++) arr[i] = String.valueOf(numbers.charAt(i));
        
        dfs(numbers, 0, "");
        
        for(int n : set) {
        	if(isPrime(n)) answer++;
        }
        
        return answer;
    }
}