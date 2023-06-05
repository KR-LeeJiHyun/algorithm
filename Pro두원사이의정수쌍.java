
public class Pro두원사이의정수쌍 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public long solution(int r1, int r2) {
        long answer = 0;
        
        for(int idx = 1; idx <= r2; ++idx) {
            int min = (int)Math.ceil(Math.sqrt((long)r1 * (long)r1 - (long)idx * (long)idx));
            int max = (int)Math.floor(Math.sqrt((long)r2 * (long)r2 - (long)idx * (long)idx));
            
            answer += max - min + 1;
        }
        
        return answer * 4;
    }

}
