import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Baek_Sequence {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer stNK = new StringTokenizer(br.readLine());
		
		int N, K;
		N = Integer.parseInt(stNK.nextToken());
		K = Integer.parseInt(stNK.nextToken());
		
		int[] temps = new int [N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int idx = 0; idx <N; ++idx) {
			temps[idx] = Integer.parseInt(st.nextToken());
		}
		
		int start = 0, end = start + K, max = -1000000000;
		
		int tmp = 0;
		for(int idx = start; idx < end; ++idx) {
			tmp += temps[idx];
		}
		
		if(tmp > max) max = tmp;
		
		while(end < N) {
			tmp -= temps[start];
			tmp += temps[end];
			++start;
			++end;
			if(tmp > max) max = tmp;
		}
		
		bw.write(Integer.toString(max));
		
		br.close();
        bw.flush();
        bw.close();
	}

}
