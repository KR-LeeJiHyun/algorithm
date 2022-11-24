import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Baek_MilkFestival {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		final int MILKNUM = 3;
		int N = Integer.parseInt(br.readLine());
		int milk = 0;
		int answer = 0;
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int idx = 0; idx < N; ++idx) {
			if(milk == Integer.parseInt(st.nextToken())) {
				milk = (milk + 1) % MILKNUM;
				++answer;
			}
		}
		
		bw.write(Integer.toString(answer));
		br.close();
		bw.close();
		
	}

}
