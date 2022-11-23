import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Baek_Hanzo {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int answer = 0;
		int tmp = 0;
		int max = 0;
		for(int idx = 0; idx < N; ++idx) {
			int mountain = Integer.parseInt(st.nextToken());
			if(max < mountain) {
				max = mountain;
				answer = Math.max(answer, tmp);
				tmp = 0;
			}
			else ++tmp;
		}
		
		answer = Math.max(answer, tmp);
		bw.write(Integer.toString(answer));
		br.close();
		bw.close();
		
	}

}
