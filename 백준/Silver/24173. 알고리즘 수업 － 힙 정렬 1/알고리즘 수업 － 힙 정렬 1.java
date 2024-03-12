import java.io.*;
import java.util.StringTokenizer;

//힙정렬
public class Main {
	static int N, K;
	static int cnt;
	
	static void swap(int[] a, int x, int y) {
		int tmp = a[x];
		a[x] = a[y];
		a[y] = tmp;
		if(++cnt == K) System.out.println(a[x] + " " + a[y]);
	}
	
	//최소 힙 구성
	// (최소 힙 => 부모노드 값이 자식노드 값보다 작은 힙)
	static void heapify(int[] a, int k, int n) {
		int left = 2*k;
		int right = 2*k +1;
		//가장 작은 값 부모노드로 가정
		int smaller = k;
		
		//부모와 양쪽 자식 노드 중 가장 작은 값 smaller에 저장
		if(right<=n && a[right]<a[smaller]) smaller = right;
		if(left<=n && a[left]<a[smaller]) smaller = left;
		
//		if(a[smaller] < a[k]) {
		if(smaller != k) {
			swap(a, k, smaller);
			heapify(a, smaller, n);
		}
	}
	
	static void heapSort(int[] a) {
		//부모노드와 heapify 과정에서 음수가 발생하는 것 방지하기 위해
		//원소가 1개 또는 0개일 경우 바로 리턴
		if(a.length < 2) return;
		
		//마지막 노드의 부모노드 인덱스
		int parent = N / 2;
		for(int i=parent; i>0; i--) {
			heapify(a, i, N);
		}
		
		//만들어진 최소 힙으로부터 정렬
		// => 내림차순
		for(int i=N; i>1; i--) {
			//루트노드인 1번째와 i번째 인덱스 값(최대값) 교환한 뒤
			//1 ~ i-1 까지의 부분트리에 대해 최소 힙 재구성
			swap(a, i, 1);
			heapify(a, 1, i-1);
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[N+1];
		st = new StringTokenizer(br.readLine());
		for(int i=1; i<N+1; i++)
			arr[i] = Integer.parseInt(st.nextToken());
		
		heapSort(arr);
		
		if(cnt < K) System.out.println(-1);
	}
}
