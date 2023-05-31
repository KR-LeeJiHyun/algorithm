import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baek모기 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		int[] starts = new int[N];
		int[] ends = new int[N];
		
		for(int idx = 0; idx < N; ++idx) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			starts[idx] = Integer.parseInt(st.nextToken());
			ends[idx] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(starts);
		Arrays.sort(ends);
		
		int mos = 0;
		int max = 0;
		int tmin = 0;
		int tmax = 0;
		int sIdx = 0;
		int eIdx = 0;
		boolean maxflag = false;
		
		while(eIdx < N) {
			if(sIdx < N) {
				if(starts[sIdx] == ends[eIdx]) {
					++sIdx;
					++eIdx;
					continue;
				}
				else if(starts[sIdx] < ends[eIdx]) {
					++mos;
					++sIdx;
				}
				else {
					--mos;
					++eIdx;
				}
			}
			else {
				--mos;
				++eIdx;
			}
			
			if(mos > max) {
				max = mos;
				tmin = starts[sIdx - 1];
				maxflag = true;
			}
			else if(mos < max && maxflag) {
				tmax = ends[eIdx - 1];
				maxflag = false;
			}
		}
		
		StringBuilder sb = new StringBuilder();
		sb.append(max);
		sb.append('\n');
		sb.append(tmin);
		sb.append(' ');
		sb.append(tmax);
		bw.write(sb.toString());
		br.close();
		bw.close();

	}

}
