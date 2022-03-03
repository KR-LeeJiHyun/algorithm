import java.util.ArrayList;

public class Preo_IntegerTriangle {

    public int solution(int[][] triangle) {
        int answer = 0;
        int len = triangle.length;
        ArrayList<Integer>[] dp = new ArrayList[len];
        
        for(int idx = 0; idx < len; ++idx) {
        	dp[idx] = new ArrayList<>();
        }
        
        dp[0].add(triangle[0][0]);
        answer = triangle[0][0];
        
        for(int dep = 1; dep < len; ++dep) {
        	for(int idx = 0; idx <= dep; ++idx) {
        		int candi_front = 0, candi_up = 0;
        		//Àü
        		if(idx != 0) candi_front = dp[dep - 1].get(idx - 1);
        		//À§
        		if(idx != dep) candi_up =  dp[dep - 1].get(idx);
        		
        		int tmp_answer = Math.max(candi_front, candi_up) + triangle[dep][idx];
        		dp[dep].add(tmp_answer);
        		if(tmp_answer > answer) answer =tmp_answer;
        	}
        }
        
        return answer;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] triangle = {{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}};
	}

}
