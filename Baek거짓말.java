import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baek거짓말 {

	public static void main(String[] args) throws IOException {

		final int LEN = 51;

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer input = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(input.nextToken());
		int M = Integer.parseInt(input.nextToken());

		boolean[] tPeople = new boolean[LEN];
		input = new StringTokenizer(br.readLine());
		int cnt = Integer.parseInt(input.nextToken());

		if(cnt != 0) {
			while(cnt > 0) {
				--cnt;
				tPeople[Integer.parseInt(input.nextToken())] = true;
			}
			
			boolean[][] map = new boolean[LEN][LEN];
			boolean[] visited = new boolean[LEN];
			Queue<Integer> q = new LinkedList<>();
			int party = 0;
			int roop = M;
			while(roop > 0) {
				--roop;
				++party;
				input = new StringTokenizer(br.readLine());
				cnt = Integer.parseInt(input.nextToken());
				while(cnt > 0) {
					--cnt;
					int people = Integer.parseInt(input.nextToken());
					if(tPeople[people] && !visited[party]) {
						visited[party] = true;
						q.add(party);
					}
					map[people][party] = true;
				}
			}
			
			while(!q.isEmpty() && M > 0) {
				--M;
				party = q.poll();
				for(int idx = 1; idx < LEN; ++idx) {
					if(map[idx][party]) {
						for(int sIdx = 1; sIdx < LEN; ++sIdx) {
							if(map[idx][sIdx] && !visited[sIdx]) {
								visited[sIdx] = true;
								q.add(sIdx);
							}	
						}
					}
				}
			}
		}
		
		bw.write(String.valueOf(M));
		bw.close();
		br.close();
	}

}
