import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Baek사이클게임 {
	
	static int[] parents;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer input = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(input.nextToken());
		int m = Integer.parseInt(input.nextToken());
		parents = new int[n];
		for(int idx = 1; idx < n; ++idx) {
			parents[idx] = idx;
		}
		
		int answer = 0;
		for(int turn = 1; turn <= m; ++turn) {
			input = new StringTokenizer(br.readLine());
			int f = Integer.parseInt(input.nextToken());
			int s = Integer.parseInt(input.nextToken());
			int fp = find(f);
			int sp = find(s);
			
			if(fp == sp) {
				answer = turn;
				break;
			}
			
			union(fp, sp);
		}
		
		bw.write(String.valueOf(answer));
		br.close();
		bw.close();

	}

	private static void union(int fp, int sp) {
		if(fp > sp) {
			int tmp = fp;
			fp = sp;
			sp = tmp;
		}
		
		parents[sp] = fp;
	}

	private static int find(int num) {
		if(parents[num] == num) return num;
		return find(parents[num]);
	}

}
