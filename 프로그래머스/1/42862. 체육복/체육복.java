import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        Arrays.sort(lost);
		Arrays.sort(reserve);
		
		List<Integer> lostList = new ArrayList<>();
		for(int l : lost) lostList.add(l);
		
		List<Integer> reserveList = new ArrayList<>();
		for(int r : reserve) reserveList.add(r);
		
		for(int i=0; i<lostList.size(); i++) {
			for(int j=0; j<reserveList.size(); j++) {
				if(lostList.get(i) == reserveList.get(j)) {
					lostList.remove(i);
					reserveList.remove(j);
					i--;
					break;
				}
			}
		}
		int answer = n - lostList.size();
		
		for(int i=0; i<reserveList.size(); i++) {
			for(int j=0; j<lostList.size(); j++) {
				if(lostList.get(j)==reserveList.get(i)-1 || lostList.get(j)==reserveList.get(i)+1) {
					answer++;
					lostList.remove(j);
					break;
				}
			}
		}
		
		return answer;
    }
}