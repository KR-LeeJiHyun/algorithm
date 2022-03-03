import java.util.Queue;
import java.util.LinkedList;

public class Pro_Delivery {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int N = 6, K = 4;
		int[][] road = {{1,2,1},{1,3,2},{2,3,2},{3,4,3},{3,5,2},{3,5,3},{5,6,1}};
		
		solution(N, road, K);
	}
	
    public static int solution(int N, int[][] road, int K) {
        int answer = 1;
        
        int[][] map = new int[N + 1][N + 1];
        int[] visited = new int[N + 1];
        
        for(int idx = 0; idx < road.length; ++idx) {
        	int first = road[idx][0], second = road[idx][1], cost = road[idx][2];
        	if(map[first][second] == 0 || map[first][second] > cost) {
        		map[first][second] = cost;
        		map[second][first] = cost;
        	}
        }

        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        q.add(0);
        
        while(!q.isEmpty()) {
        	int node = q.poll();
        	int cost = q.poll();
        	if(cost <= K) visited[node] = cost;
        	
        	if(cost < K) {
        		for(int next = 2; next <= N; ++next) {
        			if(map[node][next] != 0) {
        				if(visited[next] == 0 || visited[next] > cost + map[node][next]) {
        					q.add(next);
        					q.add(cost + map[node][next]);
        				}
        			}
        		}
        	}
        }
        
        for(int tmp : visited) {
        	if(tmp != 0) ++answer;
        }
        
        return answer;
    }

}
