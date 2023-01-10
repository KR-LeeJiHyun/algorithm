import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Baek_CrossLine2 {

	static class Coordinate {

		long x;
		long y;

		public Coordinate(long x, long y) {
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		Coordinate A = new Coordinate(Long.parseLong(st.nextToken()), Long.parseLong(st.nextToken()));
		Coordinate B = new Coordinate(Long.parseLong(st.nextToken()), Long.parseLong(st.nextToken()));

		st = new StringTokenizer(br.readLine());
		Coordinate C = new Coordinate(Long.parseLong(st.nextToken()), Long.parseLong(st.nextToken()));
		Coordinate D = new Coordinate(Long.parseLong(st.nextToken()), Long.parseLong(st.nextToken()));

		long temp1 = CCW(A, B, C);
		long temp2 = CCW(A, B, D);
		long temp3 = CCW(C, D, A);
		long temp4 = CCW(C, D, B);
		
		int answer = 0;
		
		//한점 공유
 		if((A.x == C.x && A.y == C.y) || (A.x == D.x && A.y == D.y) || (B.x == C.x && B.y == C.y) || (B.x == D.x && B.y == D.y)) answer = 1;
		
		//2점 일직선
		if(((temp1 < 0 && temp2 > 0) || (temp1 > 0 && temp2 < 0)) && ((temp3 < 0 && temp4 > 0) || (temp3 > 0 && temp4 < 0))) answer = 1;
		
 		//3점 일직선(한점 공유 제외)
 		if(temp1 == 0 || temp2 == 0) {
 			if(temp3 < 0 && temp4 > 0) answer = 1;
 			if(temp3 > 0 && temp4 < 0) answer = 1;
 		}
 		if(temp3 == 0 || temp4 == 0) {
 			if(temp1 < 0 && temp2 > 0) answer = 1;
 			if(temp1 > 0 && temp2 < 0) answer = 1;
 		}
		
		//4점 일직선
 		if(temp1 == 0 && temp2 == 0 && temp3 == 0 && temp4 == 0) {
 			if(A.x == B.x) {
 				if(A.y <= C.y && A.y >= D.y) answer = 1;
 				if(A.y >= C.y && A.y <= D.y) answer = 1;
 				if(B.y <= C.y && B.y >= D.y) answer = 1;
 				if(B.y >= C.y && B.y <= D.y) answer = 1;
 				if(C.y <= A.y && C.y >= B.y) answer = 1;
 				if(C.y >= A.y && C.y <= B.y) answer = 1;
 				if(D.y <= A.y && D.y >= B.y) answer = 1;
 				if(D.y >= A.y && D.y <= B.y) answer = 1;
 			}
 			else {
 				if(A.x <= C.x && A.x >= D.x) answer = 1;
 				if(A.x >= C.x && A.x <= D.x) answer = 1;
 				if(B.x <= C.x && B.x >= D.x) answer = 1;
 				if(B.x >= C.x && B.x <= D.x) answer = 1;
 				if(C.x <= A.x && C.x >= B.x) answer = 1;
 				if(C.x >= A.x && C.x <= B.x) answer = 1;
 				if(D.x <= A.x && D.x >= B.x) answer = 1;
 				if(D.x >= A.x && D.x <= B.x) answer = 1;
 			}
 		}
 		
		bw.write(String.valueOf(answer));
		br.close();
		bw.close();

	}

	private static long CCW(Coordinate A, Coordinate B, Coordinate C) {
		return (B.x - A.x) * (C.y - A.y) - (C.x - A.x) * (B.y - A.y);
	}

}
