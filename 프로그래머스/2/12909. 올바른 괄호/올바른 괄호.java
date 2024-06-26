import java.util.*;

class Solution {
    boolean solution(String s) {
        char[] charArr = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        
        if(charArr[0] == ')') return false;
        stack.add(charArr[0]);
        
        for(int i=1; i<charArr.length; i++) {
        	if(charArr[i] == '(') {
        		stack.add(charArr[i]);
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