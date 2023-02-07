
public class Pro_PointDraw {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public long solution(int k, int d) {
        long answer = 0;
        long dis = (long)d * (long)d;
        long cdis = 0;
        for(int a = 0; a <= d; a += k) {
            cdis = dis - (long)a * (long)a;
            int b = (int)Math.sqrt(cdis);
            answer += b / k + 1;
        }
        
        return answer;
    }

}
