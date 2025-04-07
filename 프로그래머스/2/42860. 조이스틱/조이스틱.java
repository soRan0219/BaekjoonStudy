class Solution {
    public int solution(String name) {
        int len = name.length();
		int up_down = 0;
		int left_right = len - 1;
        
        for(int i=0; i<len; i++) {
			char now = name.charAt(i);
			up_down += Math.min(now - 'A', 26 - (now-'A'));
			
			if(i<len-1 && name.charAt(i+1)=='A') {
				int end = i+1;
				while(end<len && name.charAt(end)=='A') end++;
				left_right = Math.min(left_right, (i*2) + (len-end));
				left_right = Math.min(left_right, (len-end)*2 + i);
			}
		}
		
		return up_down + left_right;
    }
}