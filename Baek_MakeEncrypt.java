import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baek_MakeEncrypt {

	static StringBuilder answer = new StringBuilder();
	static char[] alphabet;
	static boolean[] visited;
	static int L;
	static int C;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer stLC = new StringTokenizer(br.readLine());
		L = Integer.parseInt(stLC.nextToken());
		C = Integer.parseInt(stLC.nextToken());

		StringTokenizer input = new StringTokenizer(br.readLine());
		alphabet = new char[C];
		visited = new boolean[C];
		for(int idx = 0; idx < C; ++idx) alphabet[idx] = input.nextToken().charAt(0);
		Arrays.sort(alphabet);
		makeEncrypt(new StringBuilder(), 0, 0, 0);

		bw.write(answer.toString());
		br.close();
		bw.close();

	}

	private static void makeEncrypt(StringBuilder sb, int cIdx, int gather, int consonant) {

		if(sb.length() == L && gather > 0 && consonant > 1) {
			answer.append(sb);
			answer.append('\n');
			return;
		}

		for(int idx = cIdx; idx < C; ++idx) {
			if(!visited[idx]) {
				visited[idx] = true;
				sb.append(alphabet[idx]);
				if(alphabet[idx] == 'a' || alphabet[idx] == 'e' || alphabet[idx] == 'i' || alphabet[idx] == 'o' || alphabet[idx] == 'u') ++gather;
				else ++consonant;
				makeEncrypt(sb, idx + 1, gather, consonant);
				if(alphabet[idx] == 'a' || alphabet[idx] == 'e' || alphabet[idx] == 'i' || alphabet[idx] == 'o' || alphabet[idx] == 'u') --gather;
				else --consonant;
				sb.deleteCharAt(sb.length() - 1);
				visited[idx] = false;
			}
		}

	}

}
