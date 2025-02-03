import java.util.LinkedList;
import java.util.Queue;

class Solution {
    static int answer;
    static Queue<Integer> que;
    public int solution(int bridge, int weight, int[] trucks) {
        answer = 1;
        que = new LinkedList<>();
        
        for(int i=0; i<bridge-1; i++) que.offer(0);
        
        int sum = trucks[0];
        que.offer(trucks[0]);
        int i = 1;
        
        while(!que.isEmpty()) {
        	sum -= que.poll();
        	answer++;
        	
        	if(i < trucks.length) {
        		if((sum+trucks[i]) <= weight) {
        			que.offer(trucks[i]);
        			sum += trucks[i];
        			i++;
        		} else {
        			que.offer(0);
        		}
        	}
        }
        
        return answer;
    }
}