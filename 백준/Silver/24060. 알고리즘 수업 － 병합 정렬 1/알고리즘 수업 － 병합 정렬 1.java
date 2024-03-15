import java.io.*;
import java.util.*;

//병합정렬
public class Main {
	static int N, K;
	static int cnt;
    static int[] tmp;
//	static StringBuilder sb = new StringBuilder();
	
	static void mergeSort(int[] arr, int left, int right) {
		if(left < right) {
			int mid = (left+right) / 2;
			mergeSort(arr, left, mid);
			mergeSort(arr, mid+1, right);
			merge(arr, left, mid, right);
		}
	}
	
	//arr[left..mid]와 arr[mid+1..right]을 병합하여 arr[left..right]를 정렬
	static void merge(int[] arr, int left, int mid, int right) {
		int i = left;
		int j = mid + 1;
		int t = 0;
		
		while(i<=mid && j<=right) {
			if(arr[i] <= arr[j]) tmp[t++] = arr[i++];
			else tmp[t++] = arr[j++];
		}
		//왼쪽 부분이 남은 경우
		while(i <= mid) tmp[t++] = arr[i++];
		//오른쪽 부분이 남은 경우
		while(j <= right) tmp[t++] = arr[j++];
		
		//정렬한 결과를 arr에 복사
		i = left;
		t = 0;
		while(i <= right) {
			arr[i++] = tmp[t++];
			if(++cnt == K) {
                System.out.println(arr[i-1]);
            }
			//BOJ24061
//			if(++cnt == K) {
//				for(int a : arr) 
//					sb.append(a + " ");
//				System.out.println(sb);
//			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		int[] a = new int[N];
        tmp = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++)
			a[i] = Integer.parseInt(st.nextToken());
		
		mergeSort(a, 0, N-1);
		if(cnt < K) System.out.println(-1);
	}
}
