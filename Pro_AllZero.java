import java.util.ArrayList;
import java.util.Stack;

public class Pro_AllZero {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {-5,0,2,1,2};
		int[][] map = {{0,1},{3,4},{2,3},{0,3}};
		
		solution(a, map);
	}
	
	static ArrayList<Integer>[] map;
	static boolean[] visited;
	
	public static class Pair {
		long count;
		long weight;
		
		Pair(long count, long weight) {
			this.count = count;
			this.weight = weight;
		}
	}
	
    public static long solution(int[] a, int[][] edges) {
        long answer = -1;
        int aLen = a.length;
        visited = new boolean[aLen];
        map = new ArrayList[aLen];
        
        for(int idx = 0; idx < aLen; ++idx) {
        	map[idx] = new ArrayList<>();
        }
        
        for(int idx = 0; idx < aLen - 1; ++idx) {
        	int u = edges[idx][0], v = edges[idx][1];
        	map[u].add(v);
        	map[v].add(u);
        }
        
        Pair tmp = dfs(0, a);
        if(tmp.weight == 0) answer = tmp.count;
        
        return answer;
    }

	private static Pair dfs(int start, int[] a) {
		Pair pair = new Pair(0, 0);
		visited[start] = true;
		
		for(int idx = 0; idx < map[start].size(); ++idx) {
			int next = map[start].get(idx);
			if(!visited[next]) {
				Pair tmp = dfs(next, a);
				pair.weight += tmp.weight;
				pair.count += tmp.count;
			}
		}
		
		pair.weight += a[start];
		pair.count += Math.abs(pair.weight);
		return pair;
	}
}
