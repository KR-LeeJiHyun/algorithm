import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Baek_Rectangle {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		final int MAX = 5;
		int[] x = new int[MAX];
		int[] y = new int[MAX];
		int T = 4;
		
		while(T-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int idx = 1; idx < MAX; ++idx) {
				x[idx] = Integer.parseInt(st.nextToken());
				y[idx] = Integer.parseInt(st.nextToken());
			}
			
			boolean xRange = getRange(x);
			boolean yRange = getRange(y);
			
			if(!xRange || !yRange) bw.write('d');
			else if((x[1] == x[4] && y[1] == y[4]) || (x[1] == x[4] && y[2] == y[3]) || (x[2] == x[3] && y[2] == y[3]) || (x[2] == x[3] && y[1] == y[4])) bw.write('c');
			else if(((x[1] == x[4] || x[2] == x[3]) && yRange) || ((y[1] == y[4] || y[2] == y[3]) && xRange)) bw.write('b');
			else bw.write('a');
			bw.write('\n');
		}
		
		br.close();
		bw.close();

	}

	private static boolean getRange(int[] p) {
		if(p[1] > p[4] || p[2] < p[3]) return false;
		else return true;
	}

}
