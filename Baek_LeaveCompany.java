import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Baek_LeaveCompany {

	public static void main(String[] args) throws NumberFormatException, IOException {
	       /*BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1);
	        int n = Integer.valueOf(br.readLine());
	        int[] t = new int[n + 1];
	        int[] p = new int[n + 1];
	        int[] d = new int[n + 2];
	        for (int i = 1; i <= n; i++) {
	            String[] line = br.readLine().split(" ");
	            t[i] = Integer.valueOf(line[0]);
	            if (n + 1 < t[i] + i) {
	                p[i] = 0;
	            } else {
	                p[i] = Integer.valueOf(line[1]);
	            }
	        }
		

	        //역순으로 dp한다.
	        d[n] = p[n];
	        for (int i = n - 1; 1 <= i; i--) {
	            if (t[i] + i - 1 <= n) {
	                //d[]는 1부터 시작하고 t[i]+i가 n+1범위까지 가므로 d[n+2]만큼 정의한다.
	                d[i] = Math.max(d[t[i] + i] + p[i], d[i + 1]);
	            } else {
	                d[i] = d[i + 1];
	            }
	        }

	        int res = d[1];
	        System.out.println(res);*/
		
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		int[] T = new int[n + 1];
		int[] P = new int[n + 1];
		
		for(int idx = 1; idx <= n; ++idx) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			T[idx] = Integer.parseInt(st.nextToken()) - 1 + idx;
			P[idx] = Integer.parseInt(st.nextToken());
		}
		
		bw.write(Integer.toString(solution(n, T, P)));
		
		br.close();
		bw.flush();
		bw.close();
	}

    public static int solution(int n, int[] T, int[] P) {
        int answer = 0;
        int[] dp = new int[n + 1];
        
        dp[0] = 0;
        
        for(int leave = 1; leave <= n; ++leave) {
        	for(int idx = 1; idx <= leave; ++idx) {
        		if(T[idx] == leave) {
        			dp[leave] = Math.max(dp[leave], P[idx] + dp[idx - 1]);
        		}
        	}
        	dp[leave] = Math.max(dp[leave], dp[leave - 1]);
        	answer = Math.max(dp[leave], answer);
        }

        return answer;
    }

}
