import java.util.Arrays;

class Solution {
    public int solution(int[] citations) {
        Arrays.sort(citations);
        
        int n = citations.length;
        
        int h_idx = 0;
        for(int i=0; i<=citations[n-1]; i++) {
        	int cnt = 0;
        	for(int j=0; j<n; j++) {
        		if(citations[j] >= i) {
        			cnt = n - j;
        			break;
        		}
        	}
        	if(cnt >= i) {
        		boolean flag = true;
        		for(int j=0; j<n-cnt; j++) {
        			if(citations[j] > i) {
        				flag = false;
        				break;
        			}
        		}
        		if(flag) h_idx = i;
        	}
        }
        
        return h_idx;
    }
}