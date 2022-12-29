import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Baek_TheLittlePrince {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		while(T > 0) {
			--T;
			StringTokenizer input = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(input.nextToken());
			int y1 = Integer.parseInt(input.nextToken());
			int x2 = Integer.parseInt(input.nextToken());
			int y2 = Integer.parseInt(input.nextToken());
			int N = Integer.parseInt(br.readLine());
			int answer = 0;
			
			for(int idx = 0; idx < N; ++idx) {
				StringTokenizer circle = new StringTokenizer(br.readLine());
				int cx = Integer.parseInt(circle.nextToken());
				int cy = Integer.parseInt(circle.nextToken());
				int r = Integer.parseInt(circle.nextToken());
				r *= r;
				int d1 = (cx - x1) * (cx - x1) + (cy - y1) * (cy - y1);
				int d2 = (cx - x2) * (cx - x2) + (cy - y2) * (cy - y2);
				
				if((d1 < r && d2 > r) || (d1 > r && d2 < r)) ++answer;
			}
			
			bw.write(String.valueOf(answer));
			bw.write('\n');
			bw.flush();
		}
		
		br.close();
		bw.close();

	}

}
