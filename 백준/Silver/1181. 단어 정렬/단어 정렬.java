import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		Map<String, Integer> wordMap = new HashMap<>();
		for(int i=0; i<n; i++) {
			String word = br.readLine();
			wordMap.put(word, word.length());
		}
		
		List<Map.Entry<String, Integer>> entryList = new LinkedList<>(wordMap.entrySet()); 
		
		entryList.sort(new Comparator<Map.Entry<String, Integer>>() {

			@Override
			public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {
				
				if(o1.getValue()==o2.getValue()) {
					String s1 = o1.getKey();
					String s2 = o2.getKey();
					return s1.compareTo(s2);
				} else {
					return o1.getValue() - o2.getValue();
				}
			}
			
		});
		
		for(Map.Entry<String, Integer> entry : entryList)
			System.out.println(entry.getKey());
		
	} //main()
}
