import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Baek개똥벌레 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int H = Integer.parseInt(st.nextToken());
		int[] stalagmites = new int[H];
		int[] stalactites = new int[H];
		for(int idx = 0; idx < N; ++idx) {
			int h = Integer.parseInt(br.readLine());
			if(idx % 2 == 0) {
				++stalagmites[h - 1];
			}
			else {
				++stalactites[H - h];
			}
		}
		
		for(int idx = 0; idx < H - 1; ++idx) {
			stalagmites[H - idx - 2] += stalagmites[H - idx - 1];
			stalactites[idx + 1] += stalactites[idx];
		}
		
		int answer = Integer.MAX_VALUE;
		int cnt = 0;
		for(int idx = 0; idx < H; ++idx) {
			int destroy = stalactites[idx] + stalagmites[idx];
			if(answer > destroy) {
				answer = destroy;
				cnt = 1;
			}
			else if(answer == destroy) {
				++cnt;
			}
		}
		
		bw.write(Integer.toString(answer));
		bw.write(' ');
		bw.write(Integer.toString(cnt));
		br.close();
		bw.close();

	}

}
