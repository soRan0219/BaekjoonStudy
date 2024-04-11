import java.util.HashMap;
import java.util.Map;

class Solution {
    public int solution(int[] nums) {
    	int mons = nums.length / 2;
    	Map<Integer, Integer> map = new HashMap<>();
    	
        for(int i=0; i<nums.length; i++) {
        	if(map.containsKey(nums[i])) map.put(nums[i], map.get(nums[i])+1);
        	else map.put(nums[i], 1);
        }
        
        if(map.size() < mons) return map.size();
        else return mons;
    }
}