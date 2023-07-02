import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baek사냥꾼 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer stMNL = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(stMNL.nextToken());
		int N = Integer.parseInt(stMNL.nextToken());
		int L = Integer.parseInt(stMNL.nextToken());
		
		int[] gun = new int[M];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int idx = 0; idx < M; ++idx) {
			gun[idx] = Integer.parseInt(st.nextToken());
		}
		int answer = 0;
		
		Arrays.sort(gun);
		for(int idx = 0; idx < N; ++idx) {
			StringTokenizer coor = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(coor.nextToken());
			int y = Integer.parseInt(coor.nextToken());
			
			if(y > L) continue;
			
			int lower = x + y - L;
			int upper = x - y + L;
			int left = 0;
			int right = M - 1;
			
			while(left <= right) {
				int mid = (left + right) / 2;
				if(lower <= gun[mid] && gun[mid] <= upper) {
					++answer;
					break;
				}
				else if(upper < gun[mid]) {
					right = mid - 1;
				}
				else {
					left = mid + 1;
				}
			}
		}
		
		bw.write(String.valueOf(answer));
		br.close();
		bw.close();
	}

}
