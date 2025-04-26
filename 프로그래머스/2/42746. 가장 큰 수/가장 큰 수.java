import java.util.Arrays;

class Solution {
    public String solution(int[] numbers) {
		StringBuilder answer = new StringBuilder();
		
		String[] strArr = new String[numbers.length];
		for(int i=0; i<numbers.length; i++) strArr[i] = numbers[i] + "";
		
		Arrays.sort(strArr, (s1, s2) -> (s2+s1).compareTo(s1+s2));
		for(String s : strArr) answer.append(s);
		
		return answer.charAt(0)=='0' ? "0" : answer.toString();
    }
}