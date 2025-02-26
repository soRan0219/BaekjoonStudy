import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        List<Integer> answer = new ArrayList<>();
        Map<String, Integer> totalPlay = new HashMap<>();
        
        for(int i=0; i<genres.length; i++) {
        	totalPlay.put(genres[i], totalPlay.getOrDefault(genres[i], 0) + plays[i]);
        }
        
        List<String> keyList_total = new ArrayList<>(totalPlay.keySet());
        Collections.sort(keyList_total, (v1, v2) -> totalPlay.get(v2).compareTo(totalPlay.get(v1)));
        
        Iterator<String> it = keyList_total.iterator();
        
        while(it.hasNext()) {
        	Map<Integer, Integer> music = new HashMap<>();
        	String genre = it.next();
        	
        	for(int i=0; i<genres.length; i++) {
        		if(genre.equals(genres[i])) music.put(i, plays[i]);
        	}
        	
        	List<Integer> keyList_music = new ArrayList<>(music.keySet());
        	Collections.sort(keyList_music, (v1, v2) -> music.get(v2).compareTo(music.get(v1)));
        	
        	for(int j=0; j<keyList_music.size()&&j<2; j++) answer.add(keyList_music.get(j));
        }
        
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}