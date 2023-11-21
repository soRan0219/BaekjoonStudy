import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static void insertion(int[] arr, long k) {
		int result = 0;
		for(int i=1; i<arr.length; i++) {
			int tmp = arr[i];
			int j;
			for(j=i; j>0 && arr[j-1]>tmp; j--) {
				arr[j] = arr[j-1];
				result++;
				
				if(result==k) {
					for(int a : arr)
						System.out.print(a + " ");
					System.out.println();
				}
			}
			
			arr[j] = tmp;
			if(j!=i) result++;
			
		}
		if(result < k) System.out.println(-1);
		
	} //insertion()
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int[] arr = new int[n];
		long k = Long.parseLong(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		insertion(arr, k);
		
	} //main()
}
