import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        ArrayList<Integer> list = new ArrayList<>();
        
        Queue<Integer> que = new LinkedList<Integer>();
        for(int i=0; i<progresses.length; i++) {
        	int n = (100-progresses[i])/speeds[i];
        	int completion = (100-progresses[i])%speeds[i]==0 ? n : n+1;
        	
        	que.add(completion);
        }
        
        int deployment = 1;
        int max = que.poll();
        
        while(!que.isEmpty()) {
        	int next = que.poll();
        	
        	if(max<next) {
        		list.add(deployment);
        		deployment = 1;
                max = next;
        	} else {
        		deployment++;
        	}
        }
        list.add(deployment);
        
        return list.stream()
        		.mapToInt(Integer::intValue)
        		.toArray();
    }
}