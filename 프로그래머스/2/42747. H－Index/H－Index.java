import java.util.Arrays;

class Solution {
    public int solution(int[] citations) {
        int n = citations.length;
        Arrays.sort(citations);
        
        int h_idx = 0;
        
        for(int i=0; i<=citations[n-1]; i++) {
        	
        	for(int j=0; j<n; j++) {
        		if(citations[j] >= i && n-j >= i) {
        			if(j>0 && citations[j-1] <= i) {
        				h_idx = i;
        				break;
        			} else if(j == 0) {
                        h_idx = i;
                        break;
                    }
        		}
        	
        	}
        }
        
        return h_idx;
    }
}