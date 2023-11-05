import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int exchg;
	
	static void swap(int[] a, int idx1, int idx2) {
		int t = a[idx1];
		a[idx1] = a[idx2];
		a[idx2] = t;
	} //swap()
	
	static void selectionSort(int[] a, int len, int k) {
		for(int i=len-1; i>0; i--) {
			int max = i;
			for(int j=i; j>=0; j--) {
				if(a[max] < a[j]) {
					max = j;
				}
			}
			if(max != i) {
				swap(a, i, max);
				if(++exchg == k) System.out.println(a[max] + " " + a[i]);
			}
		}
		if(exchg < k) System.out.println(-1);
	} //selectionSort()
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int len = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[len];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<len; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		selectionSort(arr, len, k);
		
	} //main()

}
