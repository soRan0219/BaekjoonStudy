import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        
        //의상 개수만 쓰므로 숫자로 저장
        Map<String, Integer> closet = new HashMap<>();
        
        for(String[] c : clothes) {
        	int num = closet.containsKey(c[1]) ? closet.get(c[1]) : 0;
        	closet.put(c[1], ++num);
        }
        
        Set<String> keys = closet.keySet();
        Iterator<String> it = keys.iterator();
        while(it.hasNext()) answer *= closet.get(it.next()) + 1;
        
        return answer -1;
    }
}