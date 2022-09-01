import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Baek_JewelThief {

	public static class Jewel implements Comparable<Jewel>{
		int weight;
		int price;
		
		public Jewel(int weight, int price) {
			this.weight = weight;
			this.price = price;
		}

		public int compareTo(Jewel o) {
			return this.weight - o.weight;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st_NK = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st_NK.nextToken()), K = Integer.parseInt(st_NK.nextToken()); 
		
		PriorityQueue<Jewel> jewels = new PriorityQueue<Jewel>();
		for(int idx = 0; idx < N; ++idx) {
			StringTokenizer st_jewel = new StringTokenizer(br.readLine());
			jewels.add(new Jewel(Integer.parseInt(st_jewel.nextToken()), Integer.parseInt(st_jewel.nextToken())));
		}
		
		PriorityQueue<Integer> backpacks = new PriorityQueue<>();
		for(int idx = 0; idx < K; ++idx) backpacks.add(Integer.parseInt(br.readLine()));
		
		long answer = 0;
		int cnt = 0;
		PriorityQueue<Integer> prices = new PriorityQueue<>(Collections.reverseOrder());
		while(!backpacks.isEmpty() && !jewels.isEmpty()) {
			if(jewels.peek().weight <= backpacks.peek()) prices.add(jewels.poll().price);
			else {
				++cnt;
				if(!prices.isEmpty()) answer += prices.poll();
				backpacks.poll();
			}
		}
		
		while(cnt != K && !prices.isEmpty()) {
			++cnt;
			answer += prices.poll();
		}
		
		bw.write(answer + "\n");
		br.close();
		bw.flush();
		bw.close();
		
	}

}
