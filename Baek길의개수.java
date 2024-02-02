import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Baek길의개수 {
    static final int MOD = 1000003;
    static final int UNIT = 5;
    static int L;
    static int N;
    static int S;
    static int E;
    static long T;
    static long[][] A;
    static long[][] answer;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        S = Integer.parseInt(input[1]);
        E = Integer.parseInt(input[2]);
        T = Long.parseLong(input[3]);
        L = UNIT * N + 1;
        A = new long[L][L];
        answer = new long[L][L];
        for(int idx = 1; idx < L; ++idx) answer[idx][idx] = 1;
        
        for(int row = 1; row <= N; ++row) {
        	String s = br.readLine();
        	for(int col = 0; col < N; ++col) {
        		int w = s.charAt(col) - '0';
        		if(w >= 1) {
        			A[row * UNIT][(col + 1) * UNIT - w + 1] = 1;
        		}
        	}
        	for(int col = 1; col < UNIT; ++col) {
        		A[(row - 1) * UNIT + col][(row - 1) * UNIT + col + 1] = 1;
        	}
        }
        
        pow();
        bw.write(String.valueOf(answer[S * UNIT][E * UNIT]));
        br.close();
        bw.close();
    }

	private static void pow() {
		while(T > 0) {
			if(T % 2 == 1) answer = mul(answer, A);
			T /= 2;
			A = mul(A, A);
		}
	}

	private static long[][] mul(long[][] m1, long[][] m2) {
		long[][] result = new long[L][L];
		for(int row = 1; row < L; ++row) {
			for(int col = 1; col < L; ++col) {
				for(int com = 1; com < L; ++com) {
					result[row][col] += m1[row][com] * m2[com][col];
					result[row][col] %= MOD;
				}
			}
		}
		return result;
	}
}