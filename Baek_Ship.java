import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Baek_Ship {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		StringTokenizer stCrain = new StringTokenizer(br.readLine());
		Integer[] crains = new Integer[N];
		for(int idx = 0; idx < N; ++idx) crains[idx] = Integer.parseInt(stCrain.nextToken());

		Arrays.sort(crains, (i1, i2) -> i2 - i1);

		int M = Integer.parseInt(br.readLine());
		StringTokenizer stBox = new StringTokenizer(br.readLine());
		ArrayList<Integer> boxes = new ArrayList<Integer>();
		for(int idx = 0; idx < M; ++idx) {
			int box = Integer.parseInt(stBox.nextToken());
			boxes.add(box);
		}

		Collections.sort(boxes, Collections.reverseOrder());

		int answer = 0;
		if(boxes.get(0) <= crains[0]) {
			while(!boxes.isEmpty()) {
				int bIdx = 0;
				for(int idx = 0; idx < N;) {
					if(bIdx == boxes.size()) break;
					else if(crains[idx] >= boxes.get(bIdx)) {
						boxes.remove(bIdx);
						++idx;
					}
					else ++bIdx;
				}
				++answer;
			}
		}
		else answer = -1;

		bw.write(Integer.toString(answer));
		br.close();
		bw.flush();
		bw.close();

	}
}
