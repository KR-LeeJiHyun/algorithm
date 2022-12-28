import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Baek_Turret {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		while(T > 0) {
			--T;
			StringTokenizer input = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(input.nextToken());
			int y1 = Integer.parseInt(input.nextToken());
			int r1 = Integer.parseInt(input.nextToken());
			int x2 = Integer.parseInt(input.nextToken());
			int y2 = Integer.parseInt(input.nextToken());
			int r2 = Integer.parseInt(input.nextToken());
			
			int dis = (x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2);
			int minus = (r1 - r2) * (r1 - r2);
			int plus = (r1 + r2) * (r1 + r2);
			int answer = 0;
			if(dis == 0 && minus == 0) answer = -1;
			else if(minus < dis && dis < plus) answer = 2;
			else if(minus == dis || dis == plus) answer = 1;
			
			sb.append(answer).append('\n');
		}
		
		bw.write(sb.toString());
		br.close();
		bw.close();

	}

}
