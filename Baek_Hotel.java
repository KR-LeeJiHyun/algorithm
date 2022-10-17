import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Baek_Hotel {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int C = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		HashMap<Integer, Integer> map = new HashMap();
		
		for(int idx = 0; idx < N; ++idx) {
			StringTokenizer marketing = new StringTokenizer(br.readLine());
			int price = Integer.parseInt(marketing.nextToken());
			int pop = Integer.parseInt(marketing.nextToken());
			if(map.containsKey(pop)) map.put(pop, Math.min(price, map.get(pop)));
			else map.put(pop, price);
		}
		
		int[] dp = new int[C + 1];
		
		for(int idx = 1; idx <= C; ++idx) {
			dp[idx] = Integer.MAX_VALUE;
			for(int key : map.keySet()) {
				int remain = Math.max(idx - key, 0);
				dp[idx] = Math.min(dp[idx], dp[remain] + map.get(key));
			}
		}
		
		bw.write(Integer.toString(dp[C]));
		br.close();
		bw.flush();
		bw.close();
		
		/*
		int max = 0;
		
		for(int idx = 0; idx < N; ++idx) {
			StringTokenizer marketing = new StringTokenizer(br.readLine());
			int price = Integer.parseInt(marketing.nextToken());
			int pop = Integer.parseInt(marketing.nextToken());
			if(map.containsKey(pop)) map.put(pop, Math.min(price, map.get(pop)));
			else map.put(pop, price);
			max = Math.max(max, pop);
		}
		
		int[] dp = new int[max + C + 1];
		int answer = Integer.MAX_VALUE;
		
		for(int idx = 1; idx < max + C; ++idx) {
			dp[idx] = Integer.MAX_VALUE;
			for(int key : map.keySet()) {
				if(idx - key > -1 && dp[idx - key] != Integer.MAX_VALUE) dp[idx] = Math.min(dp[idx], dp[idx - key] + map.get(key));
			}
			if(idx >= C) answer = Math.min(answer, dp[idx]);
		}
		
		bw.write(Integer.toString(answer));
		br.close();
		bw.flush();
		bw.close();
		*/

	}

}
