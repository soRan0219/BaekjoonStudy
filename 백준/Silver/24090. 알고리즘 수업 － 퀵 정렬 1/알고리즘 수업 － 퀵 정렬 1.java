import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int cnt = 0;
	
	static void swap(int[] arr, int idx1, int idx2) {
		int tmp = arr[idx1];
		arr[idx1] = arr[idx2];
		arr[idx2] = tmp;
	} //swap()
	
	static void quickSort(int[] arr, int left, int right, int k) {
		
		if(left < right) {
			int q = partition(arr, left, right, k);
			quickSort(arr, left, q-1, k);
			quickSort(arr, q+1, right, k);
		}
	} //quickSort()
	
	static int partition(int[] arr, int left, int right, int k) {		
		int x = arr[right];
		int i = left - 1;
		
		for(int j=left; j<right; j++) {
			if(arr[j] <= x) {
				cnt++;
				swap(arr, ++i, j);
				
				if(cnt == k) System.out.println(arr[i] + " " + arr[j]);
			}
			
		}
		
		if(i+1 != right) {
			cnt++;			
			swap(arr, i+1, right);
			
			if(cnt == k) System.out.println(arr[i+1] + " " + arr[right]);

		}
	
		return i+1;
	} //partition()
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int arr[] = new int[Integer.parseInt(st.nextToken())];
		int k = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<arr.length; i++) 
			arr[i] = Integer.parseInt(st.nextToken());
		
		quickSort(arr, 0, arr.length-1, k);
		if(cnt < k) System.out.println(-1);
		
	} //main()
}
