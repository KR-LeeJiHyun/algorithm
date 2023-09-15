import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class Baek소수의연속합 {
	
	static boolean primes[];
	static int N;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		N = Integer.parseInt(br.readLine());
		primes = new boolean[N + 1];
		isPrime();
		Queue<Integer> q = new LinkedList<>();
		int loop = 0;
		int answer = 0;
		for(int prime = 2; prime <= N; prime += 2) {
			if(!primes[prime]) {
				while(loop > 0) {
					--loop;
					int num = q.poll();
					if(num + prime < N) {
						q.add(num + prime);
					}
					else if(num + prime == N) {
						++answer;
					}
				}
				if(prime < N) {
					q.add(prime);
				}
				else if(prime == N) {
					++answer;
				}
				loop = q.size();
				if(prime == 2) {
					prime = 1;
				}
			}
		}
		
		bw.write(String.valueOf(answer));
		br.close();
		bw.close();
	}

	private static void isPrime() {
        primes[0] = primes[1] = true;
        
        for(int i=2; i*i<=N; i++){
            if(!primes[i]){
            	for(int j=i*i; j<=N; j+=i) primes[j] = true;                
            }        
        }
	}

}
