import java.util.StringTokenizer;

public class Pro_JustNowSong {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String m = "ABC";
		String[] musicinfos = {"12:00,12:14,HELLO,C#DEFGAB", "13:00,13:05,WORLD,ABCDEF"};
		solution(m, musicinfos);
	}
	
    public static String solution(String m, String[] musicinfos) {
        String answer = "(None)";
        int max = 0;
        m = trans_song(m);
        for(int idx = 0; idx < musicinfos.length; ++idx) {
        	StringTokenizer st = new StringTokenizer(musicinfos[idx], ",");
        	String start = st.nextToken(), end = st.nextToken(), title = st.nextToken();
        	StringBuilder sb = new StringBuilder(trans_song(st.nextToken()));
        	int runTime = trans_min(start, end);
        	int sIdx = 0;
        	while(sb.length() < runTime) {
        		sb.append(sb.charAt(sIdx));
        		++sIdx;
        	}
        	if(sb.length() > runTime) sb.delete(runTime, sb.length());
        	int check = sb.indexOf(m);
        	if(check != -1 && max < runTime) {
        		answer = title;
        		max = runTime;
        	}
        }
        
        return answer;
    }

	private static String trans_song(String m) {
		m = m.replace("C#", "1");
		m = m.replace("D#", "2");
		m = m.replace("F#", "3");
		m = m.replace("G#", "4");
		m = m.replace("A#", "5");
		return m;
	}

	private static int trans_min(String start, String end) {
		StringTokenizer stStart = new StringTokenizer(start, ":"), stEnd = new StringTokenizer(end, ":");
		int result = (Integer.parseInt(stEnd.nextToken()) * 60 + Integer.parseInt(stEnd.nextToken())) - (Integer.parseInt(stStart.nextToken()) * 60 + Integer.parseInt(stStart.nextToken()));
		return result;
	}

}
