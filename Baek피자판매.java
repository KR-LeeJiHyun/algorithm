import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Baek피자판매 {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int target = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int[] pA = new int[A * 2];
        int[] pB = new int[B * 2];
        
        int[] aSum = new int[Math.max(target, Math.max(A, B) * 1000) + 1]; 

        int sum = 0;
        for(int idx = 0; idx < A; ++idx) {
            pA[idx] = Integer.parseInt(br.readLine());
            pA[idx + A] = pA[idx];
            sum += pA[idx];
        }
        
        ++aSum[0];
        ++aSum[sum];
        for(int start = 0; start < A; ++start) {
        	int preSum = pA[start];
        	++aSum[preSum];
        	int END = start + A - 1;
        	for(int end = start + 1; end < END; ++end) {
        		preSum += pA[end];
        		++aSum[preSum];
        	}
        }

        int answer = 0;
        sum = 0;
        for(int idx = 0; idx < B; ++idx) {
            pB[idx] = Integer.parseInt(br.readLine());
            pB[idx + B] = pB[idx];
            sum += pB[idx];
        }
        
        for(int start = 0; start < B; ++start) {
        	int preSum = 0;
        	int END = start + B - 1;
        	for(int end = start; end < END; ++end) {
        		preSum += pB[end];
        		if(target - preSum > -1) {
        			answer += aSum[target - preSum];
        		}
        	}
        }
        
        if(target - sum > -1) {
			answer += aSum[target - sum];
		}
        answer += aSum[target];

        bw.write(String.valueOf(answer));
        br.close();
        bw.close();
    }
}