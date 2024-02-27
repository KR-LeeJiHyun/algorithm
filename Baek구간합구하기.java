import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Baek구간합구하기 {
	
	static int N;
	static int M;
	static long[] arr;
	static long[] sum;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer input = new StringTokenizer(br.readLine());
		N  = Integer.parseInt(input.nextToken());
		M  = Integer.parseInt(input.nextToken()) + Integer.parseInt(input.nextToken());
		arr = new long[N + 1];
		sum = new long[N * 4 + 1];
		for(int idx = 1; idx <= N; ++idx) arr[idx] = Long.parseLong(br.readLine());
		init(1, N, 1);
		
		StringBuilder answer = new StringBuilder();
		
		for(int idx = 0; idx < M; ++idx) {
			input = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(input.nextToken());
			int b = Integer.parseInt(input.nextToken());
			long c = Long.parseLong(input.nextToken());
			
			if(a == 1) {
				long diff = c - arr[b];
				arr[b] = c;
				update(1, N, b, 1, diff);
			}
			else {
				answer.append(find(1, N, b, (int)c, 1));
				answer.append('\n');
				
			}
		}
		
		bw.write(answer.toString());
		br.close();
		bw.close();
	}

	private static long find(int start, int end, int b, int c, int node) {
		if(start > c || end < b) return 0;
		if(start >= b && end <= c) return sum[node];
		int mid = (start + end) / 2;
		int left = node * 2;
		int right = left + 1;
		return find(start, mid, b, c, left) + find(mid + 1, end, b, c, right);
	}

	private static void update(int start, int end, int b, int node, long diff) {
		if(b < start || b > end) return;
		else if(b >= start && b <= end) sum[node] += diff;
		if(start == end) return;
		int mid = (start + end) / 2;
		int left = node * 2;
		int right = left + 1;
		update(start, mid, b, left, diff);
		update(mid + 1, end, b, right, diff);
	}

	private static long init(int start, int end, int node) {
		if(start == end) return sum[node] = arr[start];
		int mid = (start + end) / 2;
		int left = node * 2;
		int right = left + 1;
		return sum[node] = init(start, mid, left) + init(mid + 1, end, right);
	}

}
