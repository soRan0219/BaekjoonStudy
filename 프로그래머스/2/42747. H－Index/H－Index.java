import java.util.Arrays;

class Solution {
    public int solution(int[] citations) {
        int n = citations.length;
        Arrays.sort(citations);
        
        int h_idx = 0;
        
        for(int i=0; i<n; i++) {
        	if(citations[i] > 1) {
        		for(int j=1; j<=citations[i]; j++) {
        			if(j<=n-i) h_idx = Math.max(j, h_idx);
        		}
        	}
        }
        
        return h_idx;
    }
}