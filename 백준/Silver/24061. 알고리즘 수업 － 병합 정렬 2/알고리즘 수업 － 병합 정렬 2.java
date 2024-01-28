import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N, K;
	static int cnt;
	static int[] sorted;
	static StringBuilder sb;
	
	static void mergeSort(int[] arr, int left, int right) {
		if(left < right) {
			int mid = (left+right) / 2;
			mergeSort(arr, left, mid);
			mergeSort(arr, mid+1, right);
			merge(arr, left, mid, right);
		}
	}
	
	//부분 리스트 병합하여 전체 리스트를 정렬된 상태로 만들기
	//부분 리스트들은 이미 정렬된 상태
	static void merge(int[] arr, int left, int mid, int right) {
		int i = left;
		int j = mid + 1;
		int t = 0;
		
		while(i<=mid && j<=right) {
			if(arr[i] <= arr[j]) {
				//24060
//				if(++cnt == K) {
//					System.out.println(arr[i]);
//					return;
//				}
				sorted[t++] = arr[i++];
			} else {
				//24060
//				if(++cnt == K) {
//					System.out.println(arr[j]);
//					return;
//				}
				sorted[t++] = arr[j++];
			}
		}
		
		//왼쪽 배열 부분이 남은 경우
		while(i <= mid) {
			//24060
//			if(++cnt == K) {
//				System.out.println(arr[i]);
//				return;
//			}
			
			sorted[t++] = arr[i++];
		}
		//오른쪽 배열 부분이 남은 경우
		while(j <= right) {
			//24060
//			if(++cnt == K) {
//				System.out.println(arr[j]);
//				return;
//			}

			sorted[t++] = arr[j++];
		}
		
		//결과를 arr에 저장
		i = left;
		t = 0;
		while(i <= right) {
			arr[i++] = sorted[t++];
            //24061
			if(++cnt==K) {
				for(int a : arr)
					sb.append(a + " ");
				System.out.println(sb);
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		sb = new StringBuilder();
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		int[] arr = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++)
			arr[i] = Integer.parseInt(st.nextToken());
		sorted = Arrays.copyOf(arr, N);
		
		mergeSort(arr, 0, N-1);
		if(cnt < K) System.out.println(-1);
	}
}
