import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Baek곱셈 {
	
	static long A;
	static int B;
	static long C;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer input = new StringTokenizer(br.readLine());
		
		A = Integer.parseInt(input.nextToken());
		B = Integer.parseInt(input.nextToken());
		C = Integer.parseInt(input.nextToken());
		
		bw.write(String.valueOf(divide(B)));
		br.close();
		bw.close();
	}

	private static long divide(int B) {
		if(B == 1) return A % C;
		long result = divide(B / 2);
		if(B % 2 == 0) return result * result % C;
		else return result * result % C * A % C;
		
	}

}
