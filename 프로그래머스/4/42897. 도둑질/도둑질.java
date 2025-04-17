class Solution {
    public int solution(int[] money) {
        int len = money.length;
		//원형이므로 첫집을 터는 경우와 막집을 터는 경우로 구분
		int[] dp_first = new int[len];
		int[] dp_last = new int[len];
		
		dp_first[0] = money[0];
		dp_first[1] = money[0];
		
		dp_last[0] = 0;
		dp_last[1] = money[1];
		
		for(int i=2; i<len; i++) {
			//현재(i번째) 집을 터는 경우와 털지 않는 경우 중 큰값
			dp_first[i] = Math.max(dp_first[i-1], money[i]+dp_first[i-2]);
			dp_last[i] = Math.max(dp_last[i-1], money[i]+dp_last[i-2]);
		}
		
		return Math.max(dp_first[len-2], dp_last[len-1]);
    }
}