import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Baek_Hockey {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		final int W = Integer.parseInt(st.nextToken());
		final int H = Integer.parseInt(st.nextToken());
		final int X = Integer.parseInt(st.nextToken());
		final int Y = Integer.parseInt(st.nextToken());
		int P = Integer.parseInt(st.nextToken());
		int answer = 0;
		
		while(P > 0) {
			--P;
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			if(check(W, H, X, Y, x, y)) ++answer;	
		}
		
		bw.write(String.valueOf(answer));
		br.close();
		bw.close();
		
	}

	private static boolean check(int w, int h, int x, int y, int x2, int y2) {
		int r = h/2;
		if((x2 - x) * (x2 - x) + (y2 - y - r) * (y2 - y - r) <= r*r) return true;
		else if((x2 - x - w) * (x2 - x - w) + (y2 - y - r) * (y2 - y - r) <= r*r) return true;
		else if(x2 >= x && x2 <= (x + w) && y2 >= y && y2 <= (y + h)) return true;
		return false;
	}

}
