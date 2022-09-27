import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Baek_Cupboard {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int fOpen = Integer.parseInt(st.nextToken()), sOpen = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(br.readLine());
		int[] targets = new int[K];
		for(int idx = 0; idx < K; ++idx) targets[idx] = Integer.parseInt(br.readLine());
		
		bw.write(Integer.toString(open(0, fOpen, sOpen, 0, targets)));
		br.close();
		bw.flush();
		bw.close();
		
	}

	private static int open(int idx, int fOpen, int sOpen, int result, int[] targets) {
		if(idx == targets.length) return result;
		
		int target = targets[idx];
		int moveFOpen = Math.abs(target - fOpen), moveSOpen = Math.abs(target - sOpen);
		
		return Math.min(open(idx + 1, target, sOpen, result + moveFOpen, targets), open(idx + 1, fOpen, target, result + moveSOpen, targets));
	}

}
