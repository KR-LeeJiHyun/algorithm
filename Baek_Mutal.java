import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baek_Mutal {
	
	//bfs
	static final int MAX = 60;
	
	static class SCV {
		int first;
		int second;
		int third;
		int cnt;
		
		public SCV(int first, int second, int third, int cnt) {
			this.first = first;
			this.second = second;
			this.third = third;
			this.cnt = cnt;
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		boolean[][][] visited = new boolean[MAX + 1][MAX + 1][MAX + 1];
		int first = 0, second = 0, third = 0;
		if(N == 3) {
			first = Integer.parseInt(st.nextToken());
			second = Integer.parseInt(st.nextToken());
			third = Integer.parseInt(st.nextToken());
		}
		else if(N == 2) {
			first = Integer.parseInt(st.nextToken());
			second = Integer.parseInt(st.nextToken());
		}
		else first = Integer.parseInt(st.nextToken());
		
		Queue<SCV> q = new LinkedList<>();
		q.add(new SCV(first, second, third, 0));
		visited[first][second][third] = true;
		
		while(!q.isEmpty()) {
			SCV scv = q.poll();
			if(scv.first == 0 && scv.second == 0 && scv.third == 0) {
				bw.write(Integer.toString(scv.cnt));
				br.close();
				bw.flush();
				bw.close();
				return;
			}
			else {
				int nextF9 = Math.max(scv.first - 9, 0);
				int nextS9 = Math.max(scv.second - 9, 0);
				int nextT9 = Math.max(scv.third - 9, 0);
				int nextF3 = Math.max(scv.first - 3, 0);
				int nextS3 = Math.max(scv.second - 3, 0);
				int nextT3 = Math.max(scv.third - 3, 0);
				int nextF1 = Math.max(scv.first - 1, 0);
				int nextS1 = Math.max(scv.second - 1, 0);
				int nextT1 = Math.max(scv.third - 1, 0);
				
				if(!visited[nextF9][nextS3][nextT1]) {
					visited[nextF9][nextS3][nextT1] = true;
					q.add(new SCV(nextF9, nextS3, nextT1, scv.cnt + 1));
				}
				
				if(!visited[nextF9][nextS1][nextT3]) {
					visited[nextF9][nextS1][nextT3] = true;
					q.add(new SCV(nextF9, nextS1, nextT3, scv.cnt + 1));
				}
				
				if(!visited[nextF3][nextS9][nextT1]) {
					visited[nextF3][nextS9][nextT1] = true;
					q.add(new SCV(nextF3, nextS9, nextT1, scv.cnt + 1));
				}
				
				if(!visited[nextF1][nextS9][nextT3]) {
					visited[nextF1][nextS9][nextT3] = true;
					q.add(new SCV(nextF1, nextS9, nextT3, scv.cnt + 1));
				}
				
				if(!visited[nextF1][nextS3][nextT9]) {
					visited[nextF1][nextS3][nextT9] = true;
					q.add(new SCV(nextF1, nextS3, nextT9, scv.cnt + 1));
				}
				
				if(!visited[nextF3][nextS1][nextT9]) {
					visited[nextF3][nextS1][nextT9] = true;
					q.add(new SCV(nextF3, nextS1, nextT9, scv.cnt + 1));
				}
			}
		}
	}
	
	//dfs
	/*
	static int[][][] dp = new int[MAX + 1][MAX + 1][MAX + 1];

	public static void main(String[] args) throws NumberFormatException, IOException {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		dp[0][0][0] = 1;
		StringTokenizer st = new StringTokenizer(br.readLine());
		int first = 0, second = 0, third = 0;
		if(N == 3) {
			first = Integer.parseInt(st.nextToken());
			second = Integer.parseInt(st.nextToken());
			third = Integer.parseInt(st.nextToken());
		}
		else if(N == 2) {
			first = Integer.parseInt(st.nextToken());
			second = Integer.parseInt(st.nextToken());
		}
		else first = Integer.parseInt(st.nextToken());
		
		dfs(first, second, third);
		
		bw.write(Integer.toString(dp[first][second][third] - 1));
		br.close();
		bw.flush();
		bw.close();
		
	}

	private static void dfs(int first, int second, int third) {
		if(dp[first][second][third] != 0) return;
		
		dfs(Math.max(first - 9, 0), Math.max(second - 3, 0), Math.max(third - 1, 0));
		dp[first][second][third] = dp[Math.max(first - 9, 0)][Math.max(second - 3, 0)][Math.max(third - 1, 0)] + 1;
		
		dfs(Math.max(first - 9, 0), Math.max(second - 1, 0), Math.max(third - 3, 0));
		dp[first][second][third] = Math.min(dp[first][second][third], dp[Math.max(first - 9, 0)][Math.max(second - 1, 0)][Math.max(third - 3, 0)] + 1);
		
		dfs(Math.max(first - 3, 0), Math.max(second - 9, 0), Math.max(third - 1, 0));
		dp[first][second][third] = Math.min(dp[first][second][third], dp[Math.max(first - 3, 0)][Math.max(second - 9, 0)][Math.max(third - 1, 0)] + 1);
		
		dfs(Math.max(first - 1, 0), Math.max(second - 9, 0), Math.max(third - 3, 0));
		dp[first][second][third] = Math.min(dp[first][second][third], dp[Math.max(first - 1, 0)][Math.max(second - 9, 0)][Math.max(third - 3, 0)] + 1);
		
		dfs(Math.max(first - 1, 0), Math.max(second - 3, 0), Math.max(third - 9, 0));
		dp[first][second][third] = Math.min(dp[first][second][third], dp[Math.max(first - 1, 0)][Math.max(second - 3, 0)][Math.max(third - 9, 0)] + 1);
		
		dfs(Math.max(first - 3, 0), Math.max(second - 1, 0), Math.max(third - 9, 0));
		dp[first][second][third] = Math.min(dp[first][second][third], dp[Math.max(first - 3, 0)][Math.max(second - 1, 0)][Math.max(third - 9, 0)] + 1);
	}
	*/

}
