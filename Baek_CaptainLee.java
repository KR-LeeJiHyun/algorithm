import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class Baek_CaptainLee {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		int[] dp = new int[N + 1];
		dp[1] = 1;
		int triangle = 1;
		int tetrahedron = 1;
		int cnt = 2;
		ArrayList<Integer> list = new ArrayList();
		list.add(1);

		while((tetrahedron + triangle + cnt) <= N) {
			triangle = triangle + cnt++;
			tetrahedron += triangle;
			dp[tetrahedron] = 1;
			list.add(tetrahedron);
		}


		for(int idx = 2; idx <= N; ++idx) {
			if(dp[idx] != 1) {
				dp[idx] = Integer.MAX_VALUE;
				for(int sIdx = 0; sIdx < list.size(); ++sIdx) {
					int tet = list.get(sIdx);
					if(idx < tet) break;
					dp[idx] = Math.min(dp[idx], dp[idx - tet] + 1);
				}
			}
		}

		bw.write(Integer.toString(dp[N]));
		br.close();
		bw.close();

	}

}
