import java.util.Arrays;
import java.util.Scanner;

public class Main {
	
	static int getSteps(int[] arr, int m) {
		int result = 0;
		
		Arrays.sort(arr);
		for(int i=0; i<arr.length && arr[i]<0; i+=m) {
			result += Math.abs(arr[i]) * 2;
		}
		for(int i=arr.length-1; i>=0 && arr[i]>0; i-=m) {
			result += Math.abs(arr[i]) * 2;
		}
		
		int first = Math.abs(arr[0]);
		int last = Math.abs(arr[arr.length-1]);
		result -= Math.max(first, last);
		
		return result;
	} //getSteps()
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[] locations = new int[n];
		
		for(int i=0; i<n; i++)
			locations[i] = sc.nextInt();
		
		sc.close();
		
		System.out.println(getSteps(locations, m));
		
	} //main()
}
