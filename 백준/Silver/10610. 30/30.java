import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Main {
	
	static void multipleOf30(String numStr) {
		Integer[] numArr = new Integer[numStr.length()];
		for(int i=0; i<numStr.length(); i++) 
			numArr[i] = Integer.parseInt(numStr.substring(i, i+1));
		
		int sum = 0;
		for(int n : numArr) 
			sum += n;
		
		if(sum%3 == 0) {
			Arrays.sort(numArr, Collections.reverseOrder());
			if(numArr[numArr.length-1] != 0) {
				System.out.println(-1);
			} else {
				for(int n : numArr)
					System.out.print(n);
			}
		} else {
			System.out.println(-1);
		}
		
		
	} //multipleOf30()
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String numStr = sc.next();
		sc.close();
		
		multipleOf30(numStr);
		
	}
}
