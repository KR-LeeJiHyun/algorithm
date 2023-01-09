import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Baek_CrossLine {
	
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
		int r1 = 0;
		long temp1 = CCW(A, B, C);
		long temp2 = CCW(A, B, D);
		if((temp1 < 0 && temp2 > 0) || (temp2 < 0 && temp1 > 0)) r1 = -1;
		
		int r2 = 0;
		temp1 = CCW(C, D, A);
		temp2 = CCW(C, D, B);
		if((temp1 < 0 && temp2 > 0) || (temp2 < 0 && temp1 > 0)) r2 = -1;
		
		if(r1 < 0 && r2 < 0) bw.write('1');
		else bw.write('0');
		
		br.close();
		bw.close();
	}

	private static long CCW(Coordinate A, Coordinate B, Coordinate C) {
		return (B.x - A.x) * (C.y - A.y) - (C.x - A.x) * (B.y - A.y);
	}

}
