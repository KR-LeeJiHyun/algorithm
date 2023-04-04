import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Baek두배열의합 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		long answer = 0;
		int T = Integer.parseInt(br.readLine());
		int N = Integer.parseInt(br.readLine());
		StringTokenizer stA = new StringTokenizer(br.readLine());
		int[] A = new int[N];
		
		for(int idx = 0; idx < N; ++idx) {
			A[idx] = Integer.parseInt(stA.nextToken());
			if(idx != 0) {
				A[idx] += A[idx - 1];
			}
		}
		
		HashMap<Integer, Integer> aMap = new HashMap<>();
		for(int idx = 0; idx < N; ++idx) {
			aMap.put(A[idx], aMap.getOrDefault(A[idx], 0) + 1);
			for(int sIdx = idx + 1; sIdx < N; ++sIdx) {
				aMap.put(A[sIdx] - A[idx], aMap.getOrDefault(A[sIdx] - A[idx], 0) + 1);
			}
		}
		
		int M = Integer.parseInt(br.readLine());
		StringTokenizer stB = new StringTokenizer(br.readLine());
		int[] B = new int[M];
		
		for(int idx = 0; idx < M; ++idx) {
			B[idx] = Integer.parseInt(stB.nextToken());
			if(idx != 0) {
				B[idx] += B[idx - 1];
			}
		}
		
		HashMap<Integer, Integer> bMap = new HashMap<>();
		for(int idx = 0; idx < M; ++idx) {
			bMap.put(B[idx], bMap.getOrDefault(B[idx], 0) + 1);
			for(int sIdx = idx + 1; sIdx < M; ++sIdx) {
				bMap.put(B[sIdx] - B[idx], bMap.getOrDefault(B[sIdx] - B[idx], 0) + 1);
			}
		}
		
		for(int aKey : aMap.keySet()) {
			int bKey = T - aKey;
			if(bMap.containsKey(bKey)) {
				answer += (long)aMap.get(aKey) * (long)bMap.get(bKey);
			}
		}
		
		bw.write(Long.toString(answer));
		br.close();
		bw.close();

	}

}
