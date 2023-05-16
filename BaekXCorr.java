import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BaekXCorr {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		long[] prefixX = new long[N];
		int[] xIdx = new int[N];
		for(int idx = 0; idx < N; ++idx) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			xIdx[idx] = Integer.parseInt(st.nextToken());
			prefixX[idx] = Long.parseLong(st.nextToken());
		}
		
		for(int idx = 1; idx < N; ++idx) {
			prefixX[idx] += prefixX[idx - 1];
		}
		
		int M = Integer.parseInt(br.readLine());
		long[] y = new long[M];
		int[] yIdx = new int[M];
		for(int idx = 0; idx < M; ++idx) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			yIdx[idx] = Integer.parseInt(st.nextToken());
			y[idx] = Long.parseLong(st.nextToken());
		}
		
		int a = Integer.parseInt(br.readLine());
		int b = Integer.parseInt(br.readLine());
		
		long answer = 0;
		
		for(int idx = 0; idx < M; ++idx) {
			int yPos = yIdx[idx]; 
			int xStart = Arrays.binarySearch(xIdx, yPos - b);
			int xEnd = Arrays.binarySearch(xIdx, yPos - a);
			if(xStart < 0) {
				xStart = Math.abs(xStart) - 1;
			}
			if(xEnd < 0) {
				xEnd = Math.abs(xEnd) - 2;
			}
			
			if(xEnd < 0) {
				continue;
			}
			
			if(xStart != 0) {
				answer += (prefixX[xEnd] - prefixX[xStart - 1]) * y[idx];
			}
			else {
				answer += prefixX[xEnd] * y[idx];
			}
		}
		
		
		bw.write(String.valueOf(answer));
		br.close();
		bw.close();
	}

}
