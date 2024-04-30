import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        
        Map<String, Integer> closet = new HashMap<>();
        
        for(int i=0; i<clothes.length; i++) {
        	if(!closet.containsKey(clothes[i][1])) closet.put(clothes[i][1], 0);
        	closet.put(clothes[i][1], closet.get(clothes[i][1])+1);
        }
        
        Set<String> set = closet.keySet();
        Iterator<String> it = set.iterator();
        
        while(it.hasNext()) {
        	answer *= closet.get(it.next()) + 1;
        }
        
        return answer - 1;
    }
}