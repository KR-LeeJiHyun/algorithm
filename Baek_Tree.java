import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.util.ArrayList;

public class Baek_Tree {
	
	static ArrayList<Integer> map[];
	
	public static int dfs(int node, int answer) {
		int tmp_answer = answer;
		if(!map[node].isEmpty()) {
			for(int tmp : map[node]) {
				answer += dfs(tmp, tmp_answer);
			}	
		}
		else ++answer;
		
		return answer;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int remove = Integer.parseInt(br.readLine());
		int start = 0;
		
		map = new ArrayList[N];
		for(int idx = 0; idx < N; ++idx) map[idx] = new ArrayList();
		
		for(int idx = 0; idx < N; ++idx) {
			
			int parent = Integer.parseInt(st.nextToken());
			if(parent != -1 && remove != idx) map[parent].add(idx);
			else if(parent == -1) start = idx;
		}
		
		if(start != remove) bw.write(Integer.toString(dfs(start, 0)));
		else bw.write(Integer.toString(0));
		
		br.close();
        bw.flush();
        bw.close();
	}

}
