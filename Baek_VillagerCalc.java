import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Baek_VillagerCalc {

	static boolean [][] map;
	static boolean []visited;
	static int n, m, start, dest, answer = -1;
	
	public static int solution(int loc, int count) {
		visited[loc] = true;
		int tmp_answer = answer;
		if(loc != dest) {
			for(int idx = 1; idx < n+1; ++idx) {
				if(!visited[idx] && map[loc][idx]) tmp_answer = solution(idx, count + 1);
				if(tmp_answer < answer || answer == -1) answer = tmp_answer;
			}
		}
		else answer = count;
		
		return answer;
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		n = Integer.parseInt(br.readLine());
		map = new boolean[n+1][n+1];
		visited = new boolean[n+1];
		
		StringTokenizer st_sd = new StringTokenizer(br.readLine());
		
		start = Integer.parseInt(st_sd.nextToken());
		dest = Integer.parseInt(st_sd.nextToken());
		m = Integer.parseInt(br.readLine());
		
		
		for(int idx = 0; idx < m; ++idx) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken()), y = Integer.parseInt(st.nextToken());
			map[x][y] = true;
			map[y][x] = true;
		}
		
		
		
		bw.write(Integer.toString(solution(start, 0)) + "\n");
		
		br.close();
        bw.flush();
        bw.close();
	}

}
