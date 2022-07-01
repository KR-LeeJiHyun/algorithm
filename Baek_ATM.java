import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Baek_ATM {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		PriorityQueue<Integer> times = new PriorityQueue<>();
		
		for(int idx = 0; idx < N; ++idx) times.add(Integer.parseInt(st.nextToken()));
		int result = 0, sum = 0;
		while(!times.isEmpty()) {
			sum += times.poll();
			result += sum;
		}
		
		bw.write(result + "\n");
		br.close();
		bw.flush();
		bw.close();

	}

}
