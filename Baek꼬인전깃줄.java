import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baek꼬인전깃줄 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N + 1];
		
		Arrays.fill(arr, Integer.MAX_VALUE);
		arr[0] = 0;
		int max = 0;
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int idx = 0; idx < N; ++idx) {
			int current = Integer.parseInt(st.nextToken());
			
			if(arr[max] < current) {
				arr[++max] = current;
			}
			
			else {
				int insert = -Arrays.binarySearch(arr, current) - 1;
				arr[insert] = current;
			}
		}
		
		bw.write(String.valueOf(N - max));
		br.close();
		bw.close();
	}

}
