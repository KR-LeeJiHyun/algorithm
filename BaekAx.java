import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BaekAx {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		double A = Double.parseDouble(st.nextToken());
		double B = Double.parseDouble(st.nextToken());
		double C = Double.parseDouble(st.nextToken());
		
		double left = 0.0;
		double right = 100000.0;
		double answer = 0;
		
		while(left <= right) {
			double mid = (left + right) / 2.000000000;
			double result = A * mid + B * Math.sin(mid);
			
			if(Math.abs(result - C) <= 0.000000001) {
				answer = mid;
				break;
			}
			else if(result < C) {
				left = mid + 0.0000000000000000000000000000000000000000001;
			}
			else {
				right = mid - 0.0000000000000000000000000000000000000000001;
			}
		}
		
		bw.write(String.format("%.40f", answer));
		br.close();
		bw.close();

	}

}
