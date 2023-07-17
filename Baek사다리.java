import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Baek사다리 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		double x = Double.parseDouble(st.nextToken());
		double y = Double.parseDouble(st.nextToken());
		double c = Double.parseDouble(st.nextToken());
		
		double left = 0;
		double right = Math.min(x, y);
		double answer = 0;
		
		while(left <= right) {
			double mid = (left + right) / 2;
			double h1 = Math.sqrt(Math.pow(x, 2) - Math.pow(mid, 2));
			double h2 = Math.sqrt(Math.pow(y, 2) - Math.pow(mid, 2));
			double result = (h1 * h2) / (h1 + h2);
			
			if(Math.abs(result - c) <= 0.001) {
				answer = mid;
				break;
			}
			else if(result > c) {
				left = mid;
			}
			else {
				right = mid;
			}
		}
		
		bw.write(String.format("%.3f", answer));
		br.close();
		bw.close();
	}

}
