import java.util.Arrays;

public class Pro_HIndex {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] citations = {3, 4, 5, 11, 15, 16, 17, 18, 19, 20};
		solution(citations);
	}
	
    public static int solution(int[] citations) {
        int answer = 0;
        
        int[] cnt = new int[10001];
        
        for(int citation : citations) {
        	++cnt[citation];
        }
        
        int hMore = citations.length;
        for(int h = 0; h <= 1000; ++h) {
        	if(h <= hMore) answer = h;
        	else break;
        	
        	hMore -= cnt[h];
        }
        
        return answer;
    }

}
