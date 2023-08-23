import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baek주식 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		int C = 0;
		StringBuilder result = new StringBuilder();
		while(C < T) {
			++C;
			result.append("Case #");
			result.append(C);
			result.append('\n');
			
			StringTokenizer input = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(input.nextToken());
			int K = Integer.parseInt(input.nextToken());
			int[] arr = new int[K];
			int len = 0;
			input = new StringTokenizer(br.readLine());
			
			arr[0] = Integer.parseInt(input.nextToken());
			for(int idx = 1; idx < N; ++idx) {
				if(len + 1 == K) break;
				int price = Integer.parseInt(input.nextToken());
				if(arr[len] < price) {
					arr[++len] = price;
				}
				else {
					int fidx = Arrays.binarySearch(arr, 0, len, price);
					if(fidx < 0) {
						fidx = -fidx -1;
					}
					arr[fidx] = price;
				}
			}
			
			if(len + 1 == K) {
				result.append(1);
			}
			else {
				result.append(0);
			}
			result.append('\n');
		}
		
		bw.write(result.toString());
		br.close();
		bw.close();
	}
}
