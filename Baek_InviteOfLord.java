import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baek_InviteOfLord {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] trees = new int[N];
		for(int idx = 0; idx < N; ++idx) trees[idx] = Integer.parseInt(st.nextToken());
		int k = 2;
		int answer = 0;
		Arrays.sort(trees);
		for(int idx = N - 1; idx > -1; --idx) answer = Math.max(answer, trees[idx] + k++);
		bw.write(Integer.toString(answer));
		br.close();
		bw.flush();
		bw.close();

	}

}
