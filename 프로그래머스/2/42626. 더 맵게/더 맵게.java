import java.util.PriorityQueue;

class Solution {
    public int solution(int[] scoville, int k) {
        int answer = 0;
                
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for(int s : scoville) minHeap.offer(s);
        
        while(minHeap.size()>=2 && k>minHeap.peek()) {
            int min = minHeap.poll();
            int second_min = minHeap.poll() * 2;
            
            minHeap.offer(min + second_min);
            answer++;            
        }
        
        if(!minHeap.isEmpty() && minHeap.peek()<k) return -1;
        
        return answer;
    }
}