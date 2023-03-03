import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		int[][] arr1 = new int[n][m];
		
		for(int i=0; i<arr1.length; i++) {
			for(int j=0; j<arr1[i].length; j++) {
				arr1[i][j] = sc.nextInt();
			}
		}
		
		int[][] arr2 = new int[n][m];
		
		for(int i=0; i<arr2.length; i++) {
			for(int j=0; j<arr2[i].length; j++) {
				arr2[i][j] = sc.nextInt();
			}
		}
		
		int[][] result = new int[n][m];
		
		for(int i=0; i<arr2.length; i++) {
			for(int j=0; j<arr2[i].length; j++) {
				result[i][j] = arr1[i][j] + arr2[i][j];
				System.out.print(result[i][j] + " ");
			}
			System.out.println();
		}
		
		

	} //main
}
