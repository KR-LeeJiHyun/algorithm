
public class Pro덧칠하기 {

	public static void main(String[] args) {
		int n = 8;
		int m = 4;
		int[] section = {2, 3, 6};
		
		Pro덧칠하기 S = new Pro덧칠하기();
		S.solution(n, m, section);
	}
	
    public int solution(int n, int m, int[] section) {
        int answer = 0;
        final int LEN = section.length;
        for(int idx = 0; idx < LEN;) {
        	int roll = m + section[idx];
        	++answer;
        	while(idx < LEN && section[idx] < roll) {
        		++idx;
        	}
        }
        
        return answer;
    }

}
