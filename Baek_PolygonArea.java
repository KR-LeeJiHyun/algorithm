import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.StringTokenizer;

public class Baek_PolygonArea {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		long[] x = new long[N + 1];
		long[] y = new long[N + 1];
		for(int idx = 1; idx <= N; ++idx) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			x[idx] = Integer.parseInt(st.nextToken());
			y[idx] = Integer.parseInt(st.nextToken());
		}
		
		long a = 0;
		long b = 0;
		
		for(int idx = 1; idx <= N; ++idx) {
			int next = idx + 1;
			if(next == N + 1) next = 1;
			a += (x[idx] * y[next]);
			b += (y[idx] * x[next]);
		}
		
		double result = (double)Math.abs(a - b) / 2.0;
		NumberFormat f = new DecimalFormat("0.0");
		bw.write(f.format(result));
		br.close();
		bw.close();
		
	}

}
