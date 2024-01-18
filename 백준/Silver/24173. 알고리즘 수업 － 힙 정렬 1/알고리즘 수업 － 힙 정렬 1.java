import java.io.*;
import java.util.StringTokenizer;

public class Main {
	static int cnt, K;
	
	static void swap(int[] arr, int idx1, int idx2) {
		int tmp = arr[idx1];
		arr[idx1] = arr[idx2];
		arr[idx2] = tmp;
		
		if(++cnt == K) System.out.println(arr[idx1] + " " + arr[idx2]);
	}
	
	//최소 힙 구성
	static void heapify(int[] arr, int parent, int last) {
		//양쪽 자식노드 인덱스 구하기
		int left = 2*parent;
		int right = 2*parent + 1;
		//가장 작은 값은 부모노드로 가정
		int smaller = parent;
		
		//자식노드 인덱스가 배열 끝의 인덱스를 넘지 않으면서
		//가장 작은 값(부모노드)보다 자식노드가 더 작은 경우 
		//가장 작은 인덱스인 smaller에 해당하는 인덱스 저장
		if(left<=last && arr[left]<arr[smaller]) smaller = left;
		if(right<=last && arr[right]<arr[smaller]) smaller = right;
		
		//smaller와 parent가 일치하지 않는다는 것은
		//현재 부모노드보다 작은 값이 자식노드 중에 있다는 것
		// => 자리 바꿔주고 바뀐 부모의 서브트리 다시 검사
		if(smaller != parent) {
			swap(arr, parent, smaller);
			heapify(arr, smaller, last);
		}
	}
	
	static void heapSort(int[] arr, int n) {
		int size = arr.length;
		
		//부모노드와 heapify 과정에서 음수가 발생하는 것을 방지하기 위해
		//원소가 1개 또는 0개일 경우 바로 리턴
		if(size < 2) return;
		
		//마지막 노드의 부모노드 인덱스
		int parent = n/2;
		
		//최소 힙 만들기
		for(int i=parent; i>=1; i--)
			heapify(arr, i, n);
		
		//만들어진 최소 힙으로부터 정렬
		for(int i=n; i>1; i--) {
			//루트노드인 1번째와 i번째 인덱스 값 교환한 뒤
			//1 ~ i-1 까지의 부분트리에 대해 최소 힙을 만족하도록 재구성
			swap(arr, i, 1);
			heapify(arr, 1, i-1);
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[n+1];
		st = new StringTokenizer(br.readLine());
		for(int i=1; i<n+1; i++)
			arr[i] = Integer.parseInt(st.nextToken());
		
		heapSort(arr, n);
		if(cnt < K) System.out.println(-1);
	}
}
