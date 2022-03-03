import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Baek_Bucket {
	
	static int A, B, C;
	static boolean[][] visited = new boolean[201][201];
	static boolean[] answer = new boolean[201];
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		solution(0, 0, C);
		
		for(int idx = 0; idx < 201; ++idx) {
			if(answer[idx]) bw.write(Integer.toString(idx) + " ");
		}
		
		br.close();
        bw.flush();
        bw.close();
	}
	
	public static void solution(int cA, int cB, int cC) {
		if(visited[cC][cB]) {
			return;
		}
		
		if(cA == 0) {
			answer[cC] = true;
		}
		
		visited[cC][cB] = true;
		
	    // a -> b
	    if (cA + cB > B) {
	        solution((cA + cB) - B, B, cC);
	    } else {
	        solution(0, cA + cB, cC);
	    }
	    // b -> a
	    if (cB + cA > A) {
	    	solution(A, (cB + cA) - A, cC);
	    } else {
	    	solution(cB + cA, 0, cC);
	    }
	    // c -> a
	    if (cC + cA > A) {
	    	solution(A, cB, (cC + cA) - A);
	    } else {
	    	solution(cC + cA, cB, 0);
	    }
	    // c -> b
	    if (cC + cB > B) {
	    	solution(cA, B, (cC + cB) - B);
	    } else {
	    	solution(cA, cC + cB, 0);
	    }
	    // b -> c, a -> c
	    // a + b = c 이기 때문에, c가 넘칠 일이 없다.
	    solution(cA, 0, cB + cC);
	    solution(0, cB, cA + cC);
		
	}
}
