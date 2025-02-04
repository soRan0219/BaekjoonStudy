class Solution {
    public int[] solution(int[] prices) {
		int[] answer = new int[prices.length];
		
		int notDrop = 1;
		
		for(int i=0; i<prices.length; i++) {
			
			for(int j=i+1; j<prices.length; j++) {
				
				if(j==prices.length-1 || prices[i]>prices[j]) {
					answer[i] = notDrop;
					notDrop = 1;
					break;
				} else if(prices[i] <= prices[j]) {
					notDrop++;
				}
				
			}
			
		}
		
		return answer;
    }
}