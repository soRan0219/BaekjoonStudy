import java.util.Arrays;

class Solution {
    public long solution(int n, int[] times) {
        Arrays.sort(times);
		
		long answer = 0;
		long left = 0;
		long right = times[times.length - 1] * (long)n;
		long mid;
		
		while(left <= right) {
			mid = (left+right) / 2;
			
			long sum = 0;
			for(int t : times) sum += mid/t;
			
			if(sum < n) {
				left = mid + 1;
			} else {
				answer = mid;
				right = mid - 1;
			}
		}
		
		return answer;
    }
}