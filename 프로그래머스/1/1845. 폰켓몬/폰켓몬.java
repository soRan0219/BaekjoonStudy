import java.util.*;

class Solution {
    public int solution(int[] nums) {
    	Set<Integer> pokemons = new HashSet<>();
    	
    	for(int n : nums) pokemons.add(n);
    	
    	if(nums.length/2 > pokemons.size()) return pokemons.size();
    	else return nums.length/2;
    }
}