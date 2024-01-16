import java.io.*;
import java.util.StringTokenizer;

public class Main {
	
	static void swap(int[] arr, int idx1, int idx2) {
		int tmp = arr[idx1];
		arr[idx1] = arr[idx2];
		arr[idx2] = tmp;
	}
	
	static void selectionSort(int[] arr, int k) {
		int cnt = 0;
		
		for(int i=arr.length-1; i>0; i--) {
			int max = i;
			int j;
			for(j=i-1; j>=0; j--) {
				max = arr[max]>arr[j] ? max : j;
			}
			if(arr[i] != arr[max]) {
				cnt++;
				swap(arr, i, max);
				if(cnt == k) {
					System.out.println(arr[max] + " " + arr[i]);
					return;
				}
			}
		}
		System.out.println(-1);
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[n];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++)
			arr[i] = Integer.parseInt(st.nextToken());
		
		selectionSort(arr, k);
	}
}
