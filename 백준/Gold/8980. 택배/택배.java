import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N, M, C;
	
	static int getMaxBoxes(int[][] delivery) {
		int result = 0;
		
		//받는 마을 기준 오름차순 정렬
		//받는 마을 같다면 보내는 마을 기준 오름차순
		Arrays.sort(delivery, ((x, y) -> {
			if(x[1] == y[1]) {
				return x[0] - y[0];
			}
			return x[1] - y[1];
		}));
		
		//마을마다 보낼 수 있는 박수 개수 (초기용량==C)
		int[] capacities = new int[N+1];
		for(int i=1; i<capacities.length-1; i++) {
			capacities[i] = C;
		}
		
		for(int i=0; i<delivery.length; i++) {
			int minus = delivery[i][2];
			int j = delivery[i][0];
			while(j < delivery[i][1]) {
				if(minus > capacities[j]) minus = capacities[j];
				capacities[j] -= minus;
				j++;
			}
			result += minus;
		}
		
		return result;
	} //getMaxBoxes()
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(br.readLine());
		
		int[][] delivery = new int[M][3];
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int sender = Integer.parseInt(st.nextToken());
			int reciever = Integer.parseInt(st.nextToken());
			int boxes = Integer.parseInt(st.nextToken());
			
			delivery[i][0] = sender;
			delivery[i][1] = reciever;
			delivery[i][2] = boxes;
		}
		
		System.out.println(getMaxBoxes(delivery));
		
	} //main()
}
