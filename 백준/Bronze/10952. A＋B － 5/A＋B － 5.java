import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		ArrayList<Integer> sumA = new ArrayList<>();
		
		String s = br.readLine();
		StringTokenizer st = new StringTokenizer(s);
		
		int num1 = Integer.parseInt(st.nextToken());
		int num2 = Integer.parseInt(st.nextToken());

		while(num1 != 0) {
			sumA.add(num1 + num2);
			
			s = br.readLine();
			st = new StringTokenizer(s);
			
			num1 = Integer.parseInt(st.nextToken());
			num2 = Integer.parseInt(st.nextToken());
		}
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		Iterator<Integer> it = sumA.iterator();
		
		while(it.hasNext()) {
			bw.write(it.next() + "\n");
		}
		
		bw.flush();
		bw.close();
		

	} //main
}