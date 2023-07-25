import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Baek문자열잘라내기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer stRC = new StringTokenizer(br.readLine());
		int R = Integer.parseInt(stRC.nextToken());
		int C = Integer.parseInt(stRC.nextToken());
		StringBuilder[] sb = new StringBuilder[C];
		
		for(int idx = 0; idx < C; ++idx) {
			sb[idx] = new StringBuilder();
		}
		
		for(int row = 0; row < R; ++row) {
			String input = br.readLine();
			for(int col = 0; col < C; ++col) {
				sb[col].append(input.charAt(col));
			}
		}
		
		int left = 0;
		int right = R - 1;
		int answer = 0;
		
		while(left <= right) {
			int mid = (left + right) / 2;
			HashSet<String> set = new HashSet<>();
			for(int idx = 0; idx < C; ++idx) {
				String com = sb[idx].substring(mid);
				if(set.contains(com)) break;
				set.add(sb[idx].substring(mid));
			}
			if(set.size() < C) {
				right = mid - 1;
			}
			else {
				left = mid + 1;
				answer = mid;
			}
		}
		
		bw.write(String.valueOf(answer));
		br.close();
		bw.close();
	}

}
