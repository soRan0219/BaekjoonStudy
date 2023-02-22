import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int testCase = Integer.parseInt(br.readLine());
		
		int[] sumArr = new int[testCase];
		
		for(int i=0; i<testCase; i++) {
			String s = br.readLine();
			StringTokenizer st = new StringTokenizer(s);
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			sumArr[i] = a+b;
		}
		
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		for(int sum : sumArr) {
			bw.write(sum+"");
            bw.newLine();
		}
        bw.flush();
        bw.close();
		

	} //main

}