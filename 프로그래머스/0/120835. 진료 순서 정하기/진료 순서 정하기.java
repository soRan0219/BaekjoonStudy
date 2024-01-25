import java.util.*;
import java.io.*;

class Solution {
    public int[] solution(int[] emergency) {
        int len = emergency.length;
        int[] copy = Arrays.copyOf(emergency, len);
        Arrays.sort(copy);
        
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<len; i++) {
            map.put(copy[i], len-i);
        }
        
        int[] answer = new int[len];
        
        for(int i=0; i<len; i++) {
            answer[i] = map.get(emergency[i]);
        }
        
        return answer;
    }
}