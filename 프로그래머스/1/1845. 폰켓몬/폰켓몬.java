import java.util.*;

class Solution {
    public int solution(int[] nums) {
    	Set<Integer> pokemons = new HashSet<>();
    	
    	for(int n : nums) pokemons.add(n);
    	
    	return nums.length/2>pokemons.size() ? pokemons.size() : nums.length/2;
    }
}