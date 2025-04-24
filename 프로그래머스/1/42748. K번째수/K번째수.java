import java.util.Arrays;

class Solution {
    	
	static void swap(int[] a, int idx1, int idx2) {
		int temp = a[idx1];
		a[idx1] =a[idx2];
		a[idx2] = temp;
	}
	
	//최대힙 구성
	static void heapify(int[] arr, int parent, int last) {
		int left, right, largest;
		
		while(parent*2+1 <= last) {
			left = parent*2 + 1;
			right = parent*2 + 2;
			largest = parent;
			
			if(left<=last && arr[left]>arr[largest]) largest = left;
			if(right<=last && arr[right]>arr[largest]) largest = right;
			
			if(largest != parent) {
				swap(arr, parent, largest);
				parent = largest;
			} 
			else {
				break;
			}
		}
	}
	
	//힙정렬
	static void heapSort(int[] arr) {
		if(arr.length <= 1) return;
		
		for(int i=arr.length/2; i>=0; i--) {
			heapify(arr, i, arr.length-1);
		}
		for(int i=arr.length-1; i>=0; i--) {
			swap(arr, 0, i);
			heapify(arr, 0, i-1);
		}
	}
	
	static int[] solution(int[] array, int[][] commands) {
		int[] answer = new int[commands.length];
		
		for(int i=0; i<commands.length; i++) {
			int[] partial = Arrays.copyOfRange(array, commands[i][0]-1, commands[i][1]);
			
			//정렬
			heapSort(partial);
			
			answer[i] = partial[commands[i][2]-1];
			System.out.println(answer[i]);
		}
		
		return answer;
	}
}