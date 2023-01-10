import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Baek_AC {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		
		while(T > 0) {
			--T;
			String command = br.readLine();
			int size = Integer.parseInt(br.readLine());
			String input = br.readLine();
			input = input.replace("[", "");
			input = input.replace("]", "");
			boolean reverse = false;
			boolean error = false;
			Deque<Integer> deque = new ArrayDeque<>();
			StringTokenizer st = new StringTokenizer(input, ",");
			while(st.hasMoreElements()) deque.add(Integer.parseInt(st.nextToken()));
			for(int idx = 0; idx < command.length(); ++idx) {
				if(command.charAt(idx) == 'R') reverse = !reverse;
				else {
					if(size == 0) {
						error = true;
						break;
					}
					
					if(reverse) deque.removeLast();
					else deque.remove();
					--size;
				}
			}
			if(error) bw.write("error");
			else {
				bw.write('[');
				if(reverse) {
					while(!deque.isEmpty()) {
						bw.write(String.valueOf(deque.removeLast()));
						if(!deque.isEmpty()) bw.write(',');
					}
				}
				else {
					while(!deque.isEmpty()) {
						bw.write(String.valueOf(deque.remove()));
						if(!deque.isEmpty()) bw.write(',');
					}
				}
				bw.write(']');
			}
			bw.write('\n');
		}
		
		br.close();
		bw.flush();
		bw.close();

	}

}
