class Solution {
    	
	static void swap(int[] a, int idx1, int idx2) {
		int temp = a[idx1];
		a[idx1] =a[idx2];
		a[idx2] = temp;
	}
	
	static int partition(int[] a, int left, int right) {
		int pivot = a[right];
		int i = left - 1;
		
		for(int j=left; j<right; j++) {
			if(a[j] <= pivot) swap(a, ++i, j);
		}
		if(i+1 != right) swap(a, i+1, right);
		
		return i+1;
	}
	
	static void quickSort(int[] a, int left, int right) {
		if(left < right) {
			int q = partition(a, left, right);
			quickSort(a, left, q-1);
			quickSort(a, q+1, right);
		}
	}
    
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
		
		for(int i=0; i<commands.length; i++) {
			int start = commands[i][0] - 1;
			int last = commands[i][1] - 1;
			
			int[] tmp = new int[last-start+1];
			for(int j=0; j<tmp.length; j++) {
				tmp[j] = array[j+start];
			}
			
			if(tmp.length > 0) quickSort(tmp, 0, tmp.length-1);
			
			int idx = commands[i][2] - 1;
			answer[i] = tmp[idx];
		}
        return answer;
    }
}