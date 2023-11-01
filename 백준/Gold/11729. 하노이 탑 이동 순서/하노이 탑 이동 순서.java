import java.util.Scanner;

public class Main {
	static int count;
	static StringBuilder sb = new StringBuilder();
	
	static void move(int no, int start, int end) {
		if(no > 1) {
			move(no-1, start, 6-start-end);
		}
//		System.out.printf("원반 [%d]를 %d번 기둥에서 %d번 기둥으로\n", no, start, end);
		sb.append(start + " " + end + "\n");
		
		if(no > 1) {
			move(no-1, 6-start-end, end);
		}
		count++;
	} //move()
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int no = s.nextInt();
		s.close();
		
		move(no, 1, 3);
		System.out.println(count);
		System.out.println(sb);
		
	} //main()

}
