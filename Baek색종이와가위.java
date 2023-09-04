import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Baek색종이와가위 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer input = new StringTokenizer(br.readLine());
		long n = Long.parseLong(input.nextToken());
		long k = Long.parseLong(input.nextToken());
		
		long left = n / 2;
		if(n % 2 != 0) ++left;
		long right = n;
		String answer = "NO";
		while(left <= right) {
			long mid = (left + right) / 2;
			long cnt = (mid + 1) * (n - mid + 1);
			if(cnt == k) {
				answer = "YES";
				break;
			}
			else if(cnt > k) {
				left = mid + 1;
			}
			else {
				right = mid - 1;
			}
		}
		
		bw.write(answer);
		br.close();
		bw.close();
	}

}
