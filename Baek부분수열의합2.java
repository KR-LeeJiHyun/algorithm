import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Baek부분수열의합2 {
	
	static int STANDARD = 2_000_000;
	static int N;
	static int S;
	static int[] arr;
	static int[] counts = new int[STANDARD * 2 + 1];
	static long answer = 0l;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer stNS = new StringTokenizer(br.readLine());
		N = Integer.parseInt(stNS.nextToken());
		S = Integer.parseInt(stNS.nextToken());
		arr = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int idx = 0; idx < N; ++idx) {
			arr[idx] = Integer.parseInt(st.nextToken());
		}
		
		halfSubset(0, 0);
		halfAndMatchSubset(N / 2, 0);
		
		if(S == 0) {
			--answer;
		}
		bw.write(String.valueOf(answer));
		br.close();
		bw.close();
	}
	
	private static void halfAndMatchSubset(int idx, int sum) {
		if(idx == N) {
			int target = S - sum + STANDARD;
			if(target > -1 && target <= STANDARD * 2) {
				answer += counts[target];
			}
			return;
		}
		halfAndMatchSubset(idx + 1, sum);
		halfAndMatchSubset(idx + 1, sum + arr[idx]);
	}

	private static void halfSubset(int idx, int sum) {
		if(idx == N / 2) {
			counts[sum + STANDARD]++;
			return;
		}
		halfSubset(idx + 1, sum);
		halfSubset(idx + 1, sum + arr[idx]);
	}
	
	/*
	static int N;
	static int S;
	static int LEN1;
	static int LEN2;
	static int[] arr1;
	static int[] arr2;
	static ArrayList<Integer>[] sub;
	static long answer = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer stNS = new StringTokenizer(br.readLine());
		N = Integer.parseInt(stNS.nextToken());
		S = Integer.parseInt(stNS.nextToken());
		LEN1 = N / 2;
		LEN2 = N - LEN1;
		arr1 = new int[LEN1];
		arr2 = new int[LEN2];
		sub = new ArrayList[2];
		sub[0] = new ArrayList();
		sub[1] = new ArrayList();
		answer = 0;
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int idx = 0; idx < N; ++idx) {
			if(idx < N / 2) {
				arr1[idx] = Integer.parseInt(st.nextToken());
			}
			else {
				arr2[idx - (N / 2)] = Integer.parseInt(st.nextToken());
			}
		}
		
		dfs(0, 0);
		dfs2(0, 0);
		
		Collections.sort(sub[1]);
		
		for(int idx = 0; idx < sub[0].size(); ++idx) {
			int target = S - sub[0].get(idx);
			int dleft = 0;
			int dright = sub[1].size() - 1;
			int d = -1;
			while(dleft <= dright) {
				int mid = (dleft + dright) / 2;
				
				if(target <= sub[1].get(mid)) {
					d = mid;
					dright = mid - 1;
				}
				else if(target > sub[1].get(mid)) {
					dleft = mid + 1;
				}
			}
			
			int uleft = 0;
			int uright = sub[1].size() - 1;
			int u = -1;
			while(uleft <= uright) {
				int mid = (uleft + uright) / 2;
				
				if(target < sub[1].get(mid)) {
					uright = mid - 1;
				}
				else if(target >= sub[1].get(mid)) {
					u = mid;
					uleft = mid + 1;
				}
			}
			
			if(u != -1 && d != -1) answer += u - d + 1;
		}
		
		bw.write(String.valueOf(answer));
		br.close();
		bw.close();
	}

	private static void dfs2(int idx, int sum) {
		if(idx < LEN2) {
			if(sum + arr2[idx] == S) {
				++answer;
			}
			sub[1].add(sum + arr2[idx]);
			dfs2(idx + 1, sum);
			dfs2(idx + 1, sum + arr2[idx]);
		}
		
	}

	private static void dfs(int idx, int sum) {
		if(idx < LEN1) {
			if(sum + arr1[idx] == S) {
				++answer;
			}
			sub[0].add(sum + arr1[idx]);
			dfs(idx + 1, sum);
			dfs(idx + 1, sum + arr1[idx]);
		}
	}
*/

}
