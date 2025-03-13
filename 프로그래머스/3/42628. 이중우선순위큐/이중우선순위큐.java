import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        int[] answer = new int[2];
		PriorityQueue<Integer> minHeap = new PriorityQueue<>();
		PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
		
		for(String o : operations) {
			String[] op = o.split(" ");
			
			if(op[0].equals("I")) {
				minHeap.offer(Integer.parseInt(op[1]));
				maxHeap.offer(Integer.parseInt(op[1]));
			} else {
				if(minHeap.isEmpty() || maxHeap.isEmpty()) continue;
				if(op[1].equals("-1")) {
					int min = minHeap.poll();
					maxHeap.remove(min);
				} else {
					int max = maxHeap.poll();
					minHeap.remove(max);
				}
			}
		}
		
		if(!minHeap.isEmpty() || !maxHeap.isEmpty()) {
			answer[0] = maxHeap.peek();
			answer[1] = minHeap.peek();
		}
        return answer;
    }
}