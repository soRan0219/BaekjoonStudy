import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        List<Integer> ans = new ArrayList<>();
        
        int[] supo_1 = {1, 2, 3, 4, 5};
		int[] supo_2 = {2, 1, 2, 3, 2, 4, 2, 5};
		int[] supo_3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
		
		int i = 0;
		int[] score = {0, 0, 0};
		
		while(i != answers.length) {
			if(answers[i] == supo_1[i%5]) score[0]++;
			if(answers[i] == supo_2[i%8]) score[1]++;
			if(answers[i] == supo_3[i%10]) score[2]++;
			i++;
		}
		
		int max = Math.max(score[0], Math.max(score[1], score[2]));
		
		for(int j=0; j<score.length; j++) {
			if(max == score[j]) ans.add(j+1);
		}
		
		return ans.stream().mapToInt(Integer::intValue).toArray();
    }
}