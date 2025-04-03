import java.util.*;

class Solution {
    
    public int getRemovedRocks(int distance, int[] rocks, int mid) {
		int cnt = 0;
		int start = 0;
		int end = distance;
		
		for(int i=0; i<rocks.length; i++) {
			if(rocks[i]-start < mid) {
				cnt++;
				continue;
			}
			start = rocks[i];
		}
		
		if(end-start < mid) cnt++;
		
		return cnt;
	}
    
    public int solution(int distance, int[] rocks, int n) {
        int answer = 0;
        Arrays.sort(rocks);
		
		int left = 1;
		int right = distance;
		
		while(left <= right) {
			int mid = (left+right) / 2;
			
			if(getRemovedRocks(distance, rocks, mid) <= n) {
				left = mid + 1;
				answer = mid;
			} else {
				right = mid - 1;
			}
		}
        return answer;
    }
}