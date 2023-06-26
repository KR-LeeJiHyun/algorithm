import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Baek직각다각형 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		final int LEN = 1_000_001;
		final int PLUS = 500_000;
		int[] horizion = new int[LEN];
		int[] vertical = new int[LEN];
		
		int n = Integer.parseInt(br.readLine());
		int[] x = new int[n];
		int[] y = new int[n];
		
		for(int idx = 0; idx < n; ++idx) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			x[idx] = Integer.parseInt(st.nextToken()) + PLUS;
			y[idx] = Integer.parseInt(st.nextToken()) + PLUS;
		}
		
		for(int idx = 0; idx < n; ++idx) {
			int nextIdx = (idx + 1) % n;
			if(x[idx] == x[nextIdx]) {
				int min = Math.min(y[idx], y[nextIdx]);
				int max = Math.max(y[idx], y[nextIdx]);
				horizion[min] += 1;
				horizion[max] -= 1;
			}
			else {
				int min = Math.min(x[idx], x[nextIdx]);
				int max = Math.max(x[idx], x[nextIdx]);
				vertical[min] += 1;
				vertical[max] -= 1;
			}
		}
		
		int answer = Math.max(horizion[0], vertical[0]);
		for(int idx = 1; idx < LEN; ++idx) {  
			horizion[idx] += horizion[idx - 1];
			vertical[idx] += vertical[idx - 1];

			answer = Math.max(answer, horizion[idx]);
			answer = Math.max(answer, vertical[idx]);
		}
		
		bw.write(String.valueOf(answer));
		br.close();
		bw.close();
	}
	/*
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		HashSet<Integer> xSet = new HashSet();
		HashSet<Integer> ySet = new HashSet();
		
		int[] horizion = new int[n];
		int[] vertical = new int[n];
		int[] x = new int[n];
		int[] y = new int[n];
		
		for(int idx = 0; idx < n; ++idx) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			x[idx] = Integer.parseInt(st.nextToken());
			y[idx] = Integer.parseInt(st.nextToken());
			xSet.add(x[idx]);
			ySet.add(y[idx]);
		}
		
		ArrayList<Integer> xList = new ArrayList(xSet);
		ArrayList<Integer> yList = new ArrayList(ySet);
		Collections.sort(xList);
		Collections.sort(yList);
		
		for(int idx = 0; idx < n; ++idx) {
			int nextIdx = (idx + 1) % n;
			if(x[idx] == x[nextIdx]) {
				int min = Math.min(y[idx], y[nextIdx]);
				int max = Math.max(y[idx], y[nextIdx]);
				horizion[yList.indexOf(min)] += 1;
				horizion[yList.indexOf(max)] -= 1;
			}
			else {
				int min = Math.min(x[idx], x[nextIdx]);
				int max = Math.max(x[idx], x[nextIdx]);
				vertical[xList.indexOf(min)] += 1;
				vertical[xList.indexOf(max)] -= 1;
			}
		}
		
		int answer = Math.max(horizion[0], vertical[0]);
		int len = Math.max(xList.size(), yList.size());
		for(int idx = 1; idx < len; ++idx) {  
			horizion[idx] += horizion[idx - 1];
			vertical[idx] += vertical[idx - 1];

			answer = Math.max(answer, horizion[idx]);
			answer = Math.max(answer, vertical[idx]);
		}
		
		bw.write(String.valueOf(answer));
		br.close();
		bw.close();
	}
	*/
}
