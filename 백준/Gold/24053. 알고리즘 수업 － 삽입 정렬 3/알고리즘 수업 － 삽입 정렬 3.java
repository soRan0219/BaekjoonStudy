import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static void insertion(int[] arr, int[] comp) {
		
		for(int i=1; i<arr.length; i++) {
			int tmp = arr[i];
			int j;
			for(j=i; j>0 && arr[j-1]>tmp; j--) {
				arr[j] = arr[j-1];
				
				if(Arrays.compare(arr, comp)==0) {
					System.out.println(1);
					return;
				}
				
			}
			
			arr[j] = tmp;
			
			if(Arrays.compare(arr, comp)==0) {
				System.out.println(1);
				return;
			}
		}
		System.out.println(0);
	} //insertion()
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int[] arr = new int[n];
		int[] comp = new int[n];
		
		int i = 1;
		while(i<3) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++) {
				if(i==1) arr[j] = Integer.parseInt(st.nextToken());
				if(i==2) comp[j] = Integer.parseInt(st.nextToken());
			}
			i++;
		}
		
		insertion(arr, comp);
		
	} //main()
}
