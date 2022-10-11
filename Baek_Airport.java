import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Baek_Airport {
	
	static int[] parents;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int G = Integer.parseInt(br.readLine());
		int P = Integer.parseInt(br.readLine());
		parents = new int[G + 1];
		
		for(int idx = 1; idx <= G; ++idx) parents[idx] = idx;
		int answer = 0;
		
		while(P != 0) {
			--P;
			int airplane = Integer.parseInt(br.readLine());
			int parent = find(airplane);
			
			if(parent == 0) break;
			++answer;
			union(parent, parent - 1);
		}
		
		bw.write(Integer.toString(answer));
		br.close();
		bw.flush();
		bw.close();
		
	}

	private static void union(int x, int y) {
		int parentX = find(x);
		int parentY = find(y);
		
		if(parentX != parentY) parents[parentX] = parentY;
		
	}

	private static int find(int airplane) {
		if(parents[airplane] == airplane) return airplane;
		return parents[airplane] = find(parents[airplane]);
	}

}
