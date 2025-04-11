import java.util.*;

class Solution {
    public String solution(String number, int k) {
        StringBuilder answer = new StringBuilder();
		Stack<Character> stack = new Stack<>();
        int len = number.length() - k;
		
		for(int i=0; i<number.length(); i++) {
			char now = number.charAt(i);
			while(!stack.isEmpty() && k>0 && stack.peek()<now) {
				stack.pop();
				k--;
			}
			stack.push(now);
		}
		
		while(!stack.isEmpty()) {
			answer.append(stack.pop());
		}
		
		return answer.reverse().substring(0, len);
    }
}