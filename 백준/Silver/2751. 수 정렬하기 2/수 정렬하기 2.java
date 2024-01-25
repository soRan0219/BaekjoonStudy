import java.io.*;

public class Main {
	
	static void insertionSort(int[] arr, int start, int last, int gap) {
		
		for(int i=start+gap; i<=last; i+=gap) {
			int tmp = arr[i];
			int j;
			for(j=i-gap; j>=start && arr[j]>tmp; j-=gap) {
				arr[j+gap] = arr[j];
			}
			arr[j+gap] = tmp;
		}
		
	}
	
	static void shellSort(int[] arr, int n) {
		int gap = n/2;
		
		while(gap > 0) {
			//gap은 홀수로 하는게 좋다고 함
			if(gap%2 == 0) gap++;
			
			//부분리스트의 개수는 gap과 같음
			//각 부분리스트 삽입정렬 수행
			for(int i=0; i<gap; i++) insertionSort(arr, i, n-1, gap);
			
			gap /= 2;
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		shellSort(arr, n);
		
		StringBuilder sb = new StringBuilder();
		for(int a : arr)
			sb.append(a + "\n");
		
		System.out.println(sb);
	}
}
