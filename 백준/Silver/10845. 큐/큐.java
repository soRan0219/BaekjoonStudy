import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

class IntQueue {
	private List<Integer> que;
	private int num;
	private int front;
	private int back;
	private int capacity;
	
	public IntQueue(int len) {
		num = front = back = 0;
		capacity = len;
		que = new ArrayList<Integer>(capacity);
	}
	
	public void push(int x) {
		que.add(back++, x);
		num++;
		if(back == capacity) back = 0;
	}
	
	public int pop() {
		int x = que.get(front++);
		num--;
		if(front == capacity) front = 0;
		
		return x;
	}
	
	public int size() {
		return num;
	}
	
	public int empty() {
		if(num<=0) return 1;
		else return 0;
	}
	
	public int front() {
		if(num<=0) return -1;
		else return que.get(front);
	}
	
	public int back() {
		if(num<=0) return -1;
		else return que.get(back-1);
	}
	
} //IntQueue

public class Main {
	
	static void printQueue(String[] cmds) {
		StringBuilder sb = new StringBuilder();
		IntQueue q = new IntQueue(cmds.length);
		
		for(int i=0; i<cmds.length; i++) {
			switch(cmds[i]) {
				case "pop":
					if(q.empty()==1) sb.append(-1 + "\n");
					else sb.append(q.pop() + "\n");
					break;
				case "size":
					sb.append(q.size() + "\n");
					break;
				case "empty":
					sb.append(q.empty() + "\n");
					break;
				case "front":
					sb.append(q.front() + "\n");
					break;
				case "back":
					sb.append(q.back() + "\n");
					break;
				default:
					q.push(Integer.parseInt(cmds[i].substring(5)));
			}
		}
		
		System.out.println(sb);
	} //printQueue()
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String[] cmds = new String[n];
		
		for(int i=0; i<n; i++)
			cmds[i] = br.readLine();
		
		printQueue(cmds);
		
	} //main()
}
