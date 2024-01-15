import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int insertionSort(int[] arr, int k) {
		int cnt = 0;
		
		for(int i=1; i<arr.length; i++) {
			int loc = i - 1;
			int newItem = arr[i];
			
			while(0<=loc && newItem<arr[loc]) {
				arr[loc+1] = arr[loc];
				cnt++;
				if(cnt == k) return arr[loc+1];
				loc--;
			}
			if(loc+1 != i) {
				arr[loc+1] = newItem;
				cnt++;
			}
			if(cnt == k) return arr[loc+1];
		}
		
		return -1;
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
		
		System.out.println(insertionSort(arr, k));
		
	}
}
