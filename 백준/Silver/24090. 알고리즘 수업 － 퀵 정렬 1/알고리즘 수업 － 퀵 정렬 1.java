import java.io.*;
import java.util.StringTokenizer;

public class Main {
	static int N, K;
	static int cnt;
	
	static void swap(int[] arr, int idx1, int idx2) {
		int tmp = arr[idx1];
		arr[idx1] = arr[idx2];
		arr[idx2] = tmp;
		
		if(++cnt == K) System.out.print(arr[idx1] + " " + arr[idx2]);
	}
	
	static void quickSort(int[] arr, int left, int right) {
		if(left < right) {
			int q = partition(arr, left, right);
			quickSort(arr, left, q-1);
			quickSort(arr, q+1, right);
		}
	}
	
	static int partition(int[] arr, int left, int right) {
		int pivot = arr[right];
		int i = left - 1;
		
		for(int j=left; j<right; j++) {
			if(arr[j] <= pivot) swap(arr, ++i, j);
		}
		if(i+1 != right) swap(arr, i+1, right);
		
		return i+1;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++)
			arr[i] = Integer.parseInt(st.nextToken());
		
		quickSort(arr, 0, N-1);
		if(cnt < K) System.out.println(-1);
	}
}
