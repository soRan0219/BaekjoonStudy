import java.io.*;
import java.util.*;

public class Main {
	static int cnt;
	static Map<Integer, Integer> arrMap;
	static int[] sorted;
	
	static void swap(int[] arr, int idx1, int idx2) {
		cnt++;
		int tmp = arr[idx1];
		arr[idx1] = arr[idx2];
		arr[idx2] = tmp;
	}
	
	static void selectionSort(int[] arr, int k) {
		Arrays.sort(sorted);
		
		for(int i=arr.length-1; i>0; i--) {
			if(sorted[i] != arr[i]) {
				int idx = arrMap.get(sorted[i]);
				arrMap.replace(sorted[i], i);
				arrMap.replace(arr[i], idx);
				swap(arr, idx, i);
			}
			if(cnt == k) {
                StringBuilder sb = new StringBuilder();
				for(int a : arr)
					sb.append(a + " ");
				System.out.println(sb);
				return;
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
		sorted = new int[n];
		arrMap = new HashMap<>();
		st = new StringTokenizer(br.readLine());
		
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			sorted[i] = arr[i];
			arrMap.put(arr[i], i);
		}
		
		selectionSort(arr, k);

	}
}
