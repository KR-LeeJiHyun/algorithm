import java.util.StringTokenizer;

public class Pro_AdInsert {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String play_time = "99:59:59";
		String adv_time = "25:00:00";
		String[] logs = {"69:59:59-89:59:59", "01:00:00-21:00:00", "79:59:59-99:59:59", "11:00:00-31:00:00"};

		solution(play_time, adv_time, logs);
	}
	
    public static String solution(String play_time, String adv_time, String[] logs) {
        String answer = "00:00:00";
        final int MAX = trans_sec(play_time) + 1;
        long[] acc_log = new long[MAX];
        
        for(String log : logs) {
    		StringTokenizer st = new StringTokenizer(log, "-");
    		++acc_log[trans_sec(st.nextToken())];
    		--acc_log[trans_sec(st.nextToken())];
    	}
        
        for(int idx = 1; idx < MAX; ++idx) acc_log[idx] += acc_log[idx - 1];
        for(int idx = 1; idx < MAX; ++idx) acc_log[idx] += acc_log[idx - 1];
        
        int ad_time = trans_sec(adv_time), max = 0;
        long max_ret = acc_log[ad_time - 1];
        
        for(int idx = ad_time; idx < MAX; ++idx) {
        	if(max_ret < acc_log[idx] - acc_log[idx - ad_time]) {
        		max_ret = acc_log[idx] - acc_log[idx - ad_time];
        		max = idx - ad_time + 1;
        	}
        }
        
        answer = get_time(max);
        return answer;
    }

	private static int trans_sec(String time) {
		int result = 0;
		final int H = 3600, M = 60;
		StringTokenizer st = new StringTokenizer(time, ":");
		result += (Integer.parseInt(st.nextToken()) * H) + (Integer.parseInt(st.nextToken()) * M) + Integer.parseInt(st.nextToken());
		return result;
	}
	
	private static String get_time(int time) {
		String result = "";
		final int H = 3600, M = 60;
		
		result += String.format("%02d",time / H) + ":";
		time %= H;
		result += String.format("%02d",time / M) + ":";
		time %= M;
		result += String.format("%02d",time);
		
		return result;
	}

}
