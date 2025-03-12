import java.util.*;

class Solution {
    static class Work implements Comparable<Work> {
		int time_point, time_cost;
		
		Work(int time_point, int time_cost) {
			this.time_point = time_point;
			this.time_cost = time_cost;
		}
		
		@Override
		public int compareTo(Work o) {
			if(this.time_cost==o.time_cost) return this.time_point - o.time_point;
			return this.time_cost - o.time_cost;
		}
	}
	
	static int solution(int[][] jobs) {
		int answer = 0;
		List<Work> job_list = new ArrayList<>();
		PriorityQueue<Work> minHeap = new PriorityQueue<>();
		
		for(int [] j : jobs) {
			job_list.add(new Work(j[0], j[1]));
		}
		Collections.sort(job_list, (o1, o2) -> o2.time_point - o1.time_point);
		
		int whole_time = 0; //총 경과시간
		int working_time = 0; //개별 작업 시간
		Work current = null; //현재 작업
		
		while(true) {
			//같은 시점에 여러 개의 작업요청이 들어왔을 경우
			while(!job_list.isEmpty() && whole_time==job_list.get(job_list.size()-1).time_point) {
				minHeap.offer(job_list.remove(job_list.size()-1));
			}
			
			//작업이 없을 때
			if(current == null) {
				if(!minHeap.isEmpty()) current = minHeap.poll();
				//대기큐와 작업리스트가 모두 비었을 때 종료
				else if(job_list.isEmpty()) break;
			}
			
			++whole_time;
			
			//작업이 있을 때
			if(current != null) {
				++working_time;
				
				//작업 완료시
				if(working_time == current.time_cost) {
					answer += whole_time - current.time_point;
					current = null;
					working_time = 0;
				}
			}
		}
		
		return answer / jobs.length;
	}
}