import java.util.StringTokenizer;
import java.util.ArrayList;

public class Pro_ThanksTraffic {
	
	public static int solution(String[] lines) {
        int answer = 0;
        ArrayList<Long> start_list = new ArrayList(), end_list = new ArrayList();
        
        for(String req : lines) {
        	StringTokenizer st = new StringTokenizer(req);
        	st.nextToken();
        	
        	StringTokenizer time = new StringTokenizer(st.nextToken(), ":");
        	long res_time = (long)(Double.parseDouble(time.nextToken()) * 3600 * 1000);
        	res_time += Double.parseDouble(time.nextToken()) * 60 * 1000;
        	res_time += Double.parseDouble(time.nextToken()) * 1000;
        	
        	end_list.add(res_time);
        	
        	String process_time = st.nextToken();
        	long S = (long)(Double.parseDouble(process_time.substring(0, process_time.length() - 1)) * 1000);
        	
        	long req_time = res_time - S + 1;
        	start_list.add(req_time);
        }
        
        
        for(int idx = 0; idx < end_list.size() - 1; ++idx) {
        	int new_answer = 1;
        	long end = end_list.get(idx);
        	for(int s_idx = idx + 1; s_idx <start_list.size(); ++s_idx) {
        		long start = start_list.get(s_idx);
        		if(start - end < 1000) ++new_answer;
        		//break하면 안됨 => 시작시간으로 정렬 되있지 않고 완료시간이므로 끝까지 가봐야 알 수 있다.
        	}
        	if(answer < new_answer) answer =new_answer;
        }
        
        return answer;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] lines = {
				"2016-09-15 20:59:57.421 0.351s",
				"2016-09-15 20:59:58.233 1.181s",
				"2016-09-15 20:59:58.299 0.8s",
				"2016-09-15 20:59:58.688 1.041s",
				"2016-09-15 20:59:59.591 1.412s",
				"2016-09-15 21:00:00.464 1.466s",
				"2016-09-15 21:00:00.741 1.581s",
				"2016-09-15 21:00:00.748 2.31s",
				"2016-09-15 21:00:00.966 0.381s",
				"2016-09-15 21:00:02.066 2.62s"
		};
		
		System.out.println(solution(lines));
	}

}
