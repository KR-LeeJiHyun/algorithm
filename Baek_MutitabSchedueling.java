import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baek_MutitabSchedueling {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer stNK = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(stNK.nextToken());
		int K = Integer.parseInt(stNK.nextToken());
		
		boolean[] visited = new boolean[K + 1];
		int[] schedule = new int[K];
		Queue<Integer>[] q = new LinkedList[K + 1];
		for(int idx = 0; idx <= K; ++idx) q[idx] = new LinkedList<>();
		int[] multitab = new int[N];
		
		StringTokenizer stElectronic = new StringTokenizer(br.readLine());
		for(int idx = 0; idx < K; ++idx) {
			int num = Integer.parseInt(stElectronic.nextToken());
			schedule[idx] = num;
			q[num].add(idx);
		}
		
		q[0].add(-1);
		for(int idx = 1; idx <= K; ++idx) q[idx].add(101);
		
		int answer = 0;
		int cnt = 0;
		for(int idx = 0; idx < K; ++idx) {
			int num = schedule[idx];
			if(!visited[num]) {
				if(cnt == N) {
					++answer;
					int sel = 0, pos = 0;
					for(int mIdx = 0; mIdx < N; ++mIdx) {
						int mul = multitab[mIdx];
						if(q[sel].peek() < q[mul].peek()) {
							sel = mul;
							pos = mIdx;
						}
					}
					multitab[pos] = num;
					visited[sel] = false;
				}
				else multitab[cnt++] = num;
			}
			
			q[num].poll();
			visited[num] = true;
		}
		
		bw.write(Integer.toString(answer));
		br.close();
		bw.flush();
		bw.close();
		
	}

}
