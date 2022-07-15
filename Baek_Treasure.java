import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Baek_Treasure {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		
		PriorityQueue<Integer> A = new PriorityQueue<>() , B = new PriorityQueue<>(new Comparator<Integer>(){
			public int compare(Integer o1, Integer o2) {
				return o2 - o1;
			}
		});
		
		StringTokenizer stA = new StringTokenizer(br.readLine());
		for(int idx = 0; idx < N; ++idx) A.add(Integer.parseInt(stA.nextToken()));
		
		StringTokenizer stB = new StringTokenizer(br.readLine());
		for(int idx = 0; idx < N; ++idx) B.add(Integer.parseInt(stB.nextToken()));
		
		int answer = 0;
		
		while(!A.isEmpty()) {
			int a = A.poll(), b = B.poll();
			answer += a * b;
		}
		
		bw.write(answer + "\n");
		br.close();
		bw.flush();
		bw.close();
		
	}

}
