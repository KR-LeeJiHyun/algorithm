import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Baek수나누기게임 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		int[] cards = new int[N];
		boolean[] visited = new boolean[1000001];
		StringTokenizer input = new StringTokenizer(br.readLine());
		for(int idx = 0; idx < N; ++idx) {
			cards[idx] = Integer.parseInt(input.nextToken());
			visited[cards[idx]] = true;
		}
		
		int[] score = new int[1000001];
		
		for(int idx = 0; idx < N; ++idx) {
			int card = cards[idx] * 2;
			while(card <= 1000000) {
				if(visited[card]) {
					++score[cards[idx]];
					--score[card];
				}
				card += cards[idx];
			}
		}
		
		StringBuilder answer = new StringBuilder();
		answer.append(score[cards[0]]);
		for(int idx = 1; idx < N; ++idx) {
			answer.append(' ');
			answer.append(score[cards[idx]]);
		}
		
		bw.write(answer.toString());
		br.close();
		bw.close();
	}

}
