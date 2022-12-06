import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Baek_AppleGame {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer stNM = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(stNM.nextToken());
		int M = Integer.parseInt(stNM.nextToken());
		int j = Integer.parseInt(br.readLine());
		
		int bucket = 1;
		int answer = 0;
		for(int idx = 0; idx < j; ++idx) {
			int current = Integer.parseInt(br.readLine());
			if(current < bucket) {
				answer += bucket - current;
				bucket = current;
			}
			else if(bucket + M - 1 < current) {
				answer += current - (bucket + M - 1);
				bucket = current - M + 1;
			}
		}
		
		bw.write(Integer.toString(answer));
		br.close();
		bw.close();

	}

}
