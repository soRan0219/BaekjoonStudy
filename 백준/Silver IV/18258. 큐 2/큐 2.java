import java.io.*;
import java.util.*;

class numQueue {
	private List<Integer> queue;
	private int first, last;
	private int size;
	private int cap;
	
	public numQueue(int len) {
		first = last = size = 0;
		cap = len;
		queue = new ArrayList<Integer>(cap);
	}
	
	public void push(int num) {
		queue.add(last++, num);
		size++;
		if(last == cap) last = 0;
	}
	
	public int pop() {
		int x = size<=0 ? -1 : queue.get(first++);
		if(size > 0) size--;
		if(first == cap) first = 0;
		
		return x;
	}
	
	public int size() {
		return size;
	}
	
	public int empty() {
		return size<=0 ? 1 : 0;
	}
	
	public int front() {
		return size<=0 ? -1 : queue.get(first);
	}
	
	public int back() {
		return size<=0 ? -1 : queue.get(last-1);
	}
}

public class Main {
	static StringBuilder sb;
	static numQueue q;
	
	static void printResult(String cmd) {
		int k = 0;
		if(cmd.length()>4 && cmd.substring(0, 4).equals("push")) {
			k = Integer.parseInt(cmd.substring(5));
			cmd = cmd.substring(0, 4);
		}
		
		switch(cmd) {
			case "push" : q.push(k); break;
			case "pop" : sb.append(q.pop() + "\n"); break;
			case "size" : sb.append(q.size() + "\n"); break;
			case "empty" : sb.append(q.empty() + "\n"); break;
			case "front" : sb.append(q.front() + "\n"); break;
			case "back" : sb.append(q.back() + "\n"); break;
		}
		
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		sb = new StringBuilder();
		q = new numQueue(n);
		
		for(int i=0; i<n; i++) 
			printResult(br.readLine());
		
		System.out.println(sb);
	}
}
