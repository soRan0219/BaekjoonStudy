import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[][] arr = new int[9][9];
		
		for(int i=0; i<arr.length; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<arr[i].length; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int max = arr[0][0];
		int maxRow = 0, maxCol = 0;
		
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr[i].length; j++) {
				if(max > arr[i][j]) {
					max = max;
				} else {
					max = arr[i][j];
					maxRow = i+1;
					maxCol = j+1;
				} //if-else
			} //for
		} //for
		
		bw.write(max + "\n");
		bw.write(maxRow + " " + maxCol);
		bw.flush();
		bw.close();

	} //main
}