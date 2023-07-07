import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Baek로봇프로젝트 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String input;
		while((input = br.readLine()) != null ) {
			int x = Integer.parseInt(input) * 10_000_000;
			int n = Integer.parseInt(br.readLine());
			int[] lego = new int[n];

			for(int idx = 0; idx < n; ++idx) {
				lego[idx] = Integer.parseInt(br.readLine());
			}

			Arrays.sort(lego);
			int left = 0;
			int right = n - 1;

			while(left < right) {
				int sum = lego[left] + lego[right];
				if(sum == x) {
					break;
				}
				else if(sum < x) {
					++left;
				}
				else {
					--right;
				}
			}

			if(left < right) {
				bw.write("yes ");
				bw.write(String.valueOf(lego[left]));
				bw.write(' ');
				bw.write(String.valueOf(lego[right]));
			}
			else {
				bw.write("danger");
			}
			bw.write('\n');
		}

		br.close();
		bw.close();
	}

}
