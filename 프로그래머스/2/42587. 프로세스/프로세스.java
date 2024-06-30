import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        
        PriorityQueue<Integer> pQue = new PriorityQueue<>(Collections.reverseOrder());
        for(int p : priorities) {
        	pQue.add(p);
        }
        
        while(!pQue.isEmpty()) {
        	for(int i=0; i<priorities.length; i++) {
        		if(priorities[i] == pQue.peek()) {
        			pQue.poll();
        			answer++;
        			if(i == location) return answer;
        		}
        	}
        }
        
        return answer;
    }
}