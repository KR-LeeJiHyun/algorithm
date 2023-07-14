import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Baek세수의합 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		int[] U = new int[N];
		
		for(int idx = 0; idx < N; ++idx) {
			U[idx] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(U);
		int[] plus = new int[(N + 1) * N / 2];
		int idx = 0;
		
		for(int x = 0; x < N; ++x) {
			for(int y = x; y < N; ++y) {
				plus[idx++] = U[x] + U[y];
			}
		}
		
		Arrays.sort(plus);
		
		for(int k = N - 1; k > -1; --k) {
			for(int z = k - 1; z > -1; --z) {
				int find = Arrays.binarySearch(plus, U[k] - U[z]);
				if(find > -1) {
					bw.write(String.valueOf(U[k]));
					br.close();
					bw.close();
					return;
				}
			}
		}
		
		br.close();
		bw.close();
	}

}
