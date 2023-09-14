import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;
import java.util.StringTokenizer;

public class Baek가장긴증가하는부분수열5 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		ArrayList<Integer>[] list = new ArrayList[N];
		ArrayList<Integer> seq = new ArrayList();
		StringTokenizer input = new StringTokenizer(br.readLine());
		int num = Integer.parseInt(input.nextToken());
		arr[0] = num;
		seq.add(num);
		list[0] = new ArrayList();
		list[0].add(0);
		for(int idx = 1; idx < N; ++idx) {
			num = Integer.parseInt(input.nextToken());
			arr[idx] = num;
			list[idx] = new ArrayList();
			int fIdx = 0;
			if(seq.get(seq.size() - 1) < num) {
				fIdx = seq.size();
				seq.add(num);
			}
			else {
				fIdx = Collections.binarySearch(seq, num);
				if(fIdx < 0) {
					fIdx = -(fIdx + 1);
				}
				seq.set(fIdx, num);
			}
			
			list[fIdx].add(idx);
		}
		
		int size = seq.size();
		int prev = Integer.MAX_VALUE;
		Stack<Integer> stack = new Stack();
		for(int idx = size - 1; idx > -1; --idx) {
			int fIdx = Collections.binarySearch(list[idx], prev);
			if(fIdx < 0) {
				fIdx = -(fIdx + 2);
			}
			prev = list[idx].get(fIdx);
			stack.add(prev);
		}
		
		StringBuilder answer = new StringBuilder();
		answer.append(size);
		answer.append('\n');
		while(!stack.isEmpty()) {
			answer.append(arr[stack.pop()]);
			answer.append(' ');
		}
		
		bw.write(answer.toString());
		br.close();
		bw.close();
	}

}
