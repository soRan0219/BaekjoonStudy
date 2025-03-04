import java.util.*;

class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        
        List<List<Integer>> resList = getDivisor(yellow);
		
		for(int i=0; i<resList.size(); i++) {
			int width = resList.get(i).get(1) + 2;
			int height = resList.get(i).get(0) + 2;
			
			if(width*height == brown+yellow) {
				answer[0] = width;
				answer[1] = height;
				break;
			}
		}
        
        return answer;
    }
    
    //약수 구하기
	List<List<Integer>> getDivisor(int n) {
		List<List<Integer>> list = new ArrayList<>();
		
		for(int i=1; i<=Math.sqrt(n); i++) {
			if(n%i == 0) {
				List<Integer> sub = new ArrayList<>();
				sub.add(i);
				sub.add(n/i);
				list.add(sub);
			}
		}
		
		return list;
	}
}