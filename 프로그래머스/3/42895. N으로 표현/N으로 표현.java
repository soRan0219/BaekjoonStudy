import java.util.*;

class Solution {
    static void unionSet(Set<Integer> union, Set<Integer> aSet, Set<Integer> bSet) {
		for(int a : aSet) {
			for(int b : bSet) {
				union.add(a + b);
				union.add(a - b);
				union.add(a * b);
				if(b != 0) union.add(a / b);
			}
		}
	}
	
	static int solution(int N, int number) {
		List<Set<Integer>> setList = new ArrayList<>();
		for(int i=0; i<9; i++) setList.add(new HashSet<>());
		setList.get(1).add(N);
		
		if(number == N) return 1;
		
		for(int i=2; i<9; i++) {
			for(int j=1; j<=i/2; j++) {
				unionSet(setList.get(i), setList.get(j), setList.get(i-j));
				unionSet(setList.get(i), setList.get(i-j), setList.get(j));
			}
			String n = "";
			for(int j=0; j<i; j++) n += N;
			setList.get(i).add(Integer.parseInt(n));
			
			for(int num : setList.get(i)) {
				if(num == number) return i;
			}
		}
		
		return -1;
	}
}