import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baek오름세 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringBuilder answer = new StringBuilder();
		String input;
		while((input = br.readLine()) != null) {
			int N = Integer.parseInt(input.trim());
			int len = 0;
			StringTokenizer st = new StringTokenizer(br.readLine());
			int[] arr = new int[N + 1];
			Arrays.fill(arr, Integer.MAX_VALUE);
			arr[0] = 0;
			for(int idx = 0; idx < N; ++idx) {
				int num = Integer.parseInt(st.nextToken());
				if(arr[len] < num) {
					arr[++len] = num;
				}
				else {
					int inIdx = Arrays.binarySearch(arr, num);
					if(inIdx < 0) {
						inIdx = -inIdx - 1; 
					}
					arr[inIdx] = num;
				}
			}
			answer.append(len);
			answer.append('\n');
		}
		
		bw.write(answer.toString());
		br.close();
		bw.close();
	}

}
