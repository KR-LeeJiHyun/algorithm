
public class Pro_BaseStatiation {

	public static void main(String[] args) {
		int n = 17, w = 2;
		int[] stations = {9};
		
		solution(n, stations, w);
	}
	
    public static int solution(int n, int[] stations, int w) {
        int answer = 0, max = w * 2 + 1;
        int prev = 1;
        for(int idx = 0; idx < stations.length; ++idx) {
        	int start = stations[idx] - w, end = stations[idx] + w;
        	if(start > prev) answer += Math.ceil((double)(start - prev) / (double)max);
        	prev = end + 1;
        }
        if(n >= prev) answer += Math.ceil((double)(n - prev + 1) / (double)max);
      
        return answer;
    }
}