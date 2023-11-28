import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static void editTab(int[] arr, int[] answer) {
		int result = 0;
		int pre = answer[0] - arr[0];
        
        if(arr.length==1) result = pre;
		for(int i=1; i<arr.length; i++) {
			int diff = answer[i] - arr[i];
			
			if(pre * diff >= 0) {
				//둘 다 양수거나 둘 다 음수 -> 절대값 가장 큰 수까지 같이 묶어서 실행
				if(Math.abs(pre) >= Math.abs(diff)) {
					//절대값 감소하면 넘김
					result += Math.abs(pre) - Math.abs(diff);
				}
				
			} else {
				//둘이 부호 다름 -> 앞에까지만 묶어서
				result += Math.abs(pre);
			}
			pre = diff;
			
		} //for
		
        result += Math.abs(pre);
		System.out.println(result);
	} //editTab()
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int[] tabs = new int[n];
		int[] correctTabs = new int[n];
		
		for(int i=0; i<n; i++) 
			tabs[i] = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++)
			correctTabs[i] = Integer.parseInt(st.nextToken());
		
		editTab(tabs, correctTabs);
		
	} //main()
}
