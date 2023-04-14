import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Baek수들의합4 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer stNK = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(stNK.nextToken());
		int K = Integer.parseInt(stNK.nextToken());
		
		long answer = 0;
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[N + 1];
		HashMap<Integer, Integer> map = new HashMap<>();
		
		for(int idx = 1; idx <= N; ++idx) {
			arr[idx] = Integer.parseInt(st.nextToken()) + arr[idx - 1];
			if(arr[idx] == K) {
				++answer;
			}
			answer += map.getOrDefault(arr[idx] - K, 0);
			map.put(arr[idx], map.getOrDefault(arr[idx], 0) + 1);
		}
		
		bw.write(String.valueOf(answer));
		br.close();
		bw.close();
	}

}
