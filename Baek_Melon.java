import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Baek_Melon {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		final int LINE = 6;
		int K = Integer.parseInt(br.readLine());
		int[] melon = new int[LINE];
		int w = 0;
		int h = 0;
		int wIdx = 0;
		int hIdx = 0;
		
		for(int idx = 0; idx < LINE; ++idx) {
			StringTokenizer input = new StringTokenizer(br.readLine());
			int arrow = Integer.parseInt(input.nextToken());
			int line = Integer.parseInt(input.nextToken());
			melon[idx] = line;
			
			if((arrow == 1 || arrow == 2) && line > w) {
				w = line;
				wIdx = idx;
			}
			else if((arrow == 3 || arrow == 4) && line > h) {
				h = line;
				hIdx = idx;
			}	
		}
		
		int start = 0;
		if(Math.abs(wIdx - hIdx) == 1) start = (Math.min(wIdx, hIdx) + 3) % LINE;
		else start = 2;
		
		int answer = (w * h - melon[start] * melon[(start + 1) % LINE]) * K;
		bw.write(String.valueOf(answer));
		br.close();
		bw.close();
		
	}

}
