import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[] lans;
	
	//upper bound로 n-1개의 랜선이 나오는 최소길이 구한 후 1 빼주기
	//              (== n개 랜선 나오는 최대길이)
	static long getMaxLen(long max, int n) {
		//입력되는 랜선의 길이가 최대 2^31-1이므로 long 타입
		//(max에 +1하면 2^31)
		long pl = 0;
		//pc가 0이 되지 않도록 pr에 max+1 할당
		long pr = max + 1;
		
		while(pl < pr) {
			//랜선의 길이
			long pc = (pl+pr) / 2;
			
			//랜선의 개수
			long cnt = 0;
						
			for(int i=0; i<lans.length; i++)
				cnt += lans[i]/pc;
						
			if(cnt < n) pr = pc;
			else pl = pc + 1;
			
		}
		
		//upper bound로 구했기 때문에 1 빼줘야 함
		return pl - 1;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int k = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		
		lans = new int[k];
		long max = 0;
		for(int i=0; i<k; i++) {
			lans[i] = Integer.parseInt(br.readLine());
			max = Math.max(lans[i], max);
		}
		
		System.out.println(getMaxLen(max, n));
	}
}
