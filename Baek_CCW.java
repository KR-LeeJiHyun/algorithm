import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Baek_CCW {
	
	static final int CNT = 3;
	static final int XY = 2;
	static final int X = 0;
	static final int Y = 1;
	
	//벡터의 외적 CCW 사용
	//우리는 오른손 좌표계를 사용하므로 반시계일 때 양수, 시계일 때 음수가 나온다.(?)
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		

		int[][] P = new int[CNT][XY];
		for(int idx = 0; idx < CNT; ++idx) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			P[idx][X] = Integer.parseInt(st.nextToken());
			P[idx][Y] = Integer.parseInt(st.nextToken());
		}
		
		int result = calc(P);
		int answer = 0;
		if(result > 0) answer = 1;
		else if(result < 0) answer = -1;
		else answer = 0;
		
		bw.write(String.valueOf(answer));
		br.close();
		bw.close();

	}

	private static int calc(int[][] P) {
		return (P[1][X] - P[0][X])*(P[2][Y] - P[0][Y]) - (P[2][X] - P[0][X])*(P[1][Y] - P[0][Y]);
	}

}
