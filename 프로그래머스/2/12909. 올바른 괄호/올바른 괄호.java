import java.util.*;

class Solution {
    boolean solution(String s) {
        char[] charArr = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        
        for(char c : charArr) {
        	if(c == '(') {
        		stack.add(c);
        	} else {
        		try {
        			stack.pop();
        		} catch(EmptyStackException e) {
        			return false;
        		}
        	}
        }
        
        return stack.isEmpty();
    }
}