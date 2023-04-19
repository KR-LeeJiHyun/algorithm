import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Baek최대공약수하나빼기 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		int[] lgcd = new int[N];
		int[] rgcd = new int[N];
		int answer = -1;
		int K = 0;
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int idx = 0; idx < N; ++idx) {
			arr[idx] = Integer.parseInt(st.nextToken());
		}
		
		lgcd[0] = arr[0];
		rgcd[N - 1] = arr[N - 1];
		
		for(int idx = 1; idx < N; ++idx) {
			lgcd[idx] = getGcd(lgcd[idx - 1], arr[idx]);
		}
		
		for(int idx = N - 2; idx > -1; --idx) {
			rgcd[idx] = getGcd(rgcd[idx + 1], arr[idx]);
		}
		
		int gcd = rgcd[1];
		if(arr[0] % gcd != 0 && answer < gcd) {
			answer = gcd;
			K = arr[0];
		}
		gcd = lgcd[N - 2];
		if(arr[N - 1] % gcd != 0 && answer < gcd) {
			answer = gcd;
			K = arr[N - 1];
		}
		
		for(int sel = 1; sel < N - 1; ++sel) {
			gcd = getGcd(lgcd[sel - 1], rgcd[sel + 1]);
			if(arr[sel] % gcd != 0 && answer < gcd) {
				answer = gcd;
				K = arr[sel];
			}
		}
		
		
		if(answer != -1) {
			StringBuilder sb = new StringBuilder();
			sb.append(answer);
			sb.append(' ');
			sb.append(K);
			bw.write(sb.toString());
		}
		else {
			bw.write(String.valueOf(answer));
		}
		br.close();
		bw.close();

	}

	private static int getGcd(int a, int b) {
		int n = 0;
		while(b != 0) {
			n = a % b;
			a = b;
			b = n;
		}
		return a;
	}
	
	/*for(int sel = 0; sel < N; ++sel) {
	int gcd = 0;
	if(sel == 0) {
		gcd = arr[1];
	}
	else {
		gcd = arr[0];
	}
	int k = arr[sel];
	for(int idx = 1; idx < N; ++idx) {
		if(k % gcd == 0) {
			break;
		}
		if(idx != sel) {
			gcd = getGcd(gcd, arr[idx]);
		}
	}
	if(k % gcd != 0) {
		if(answer < gcd) {
			answer = gcd;
			K = k;
		}
	}
}
*/

}
