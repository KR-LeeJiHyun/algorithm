import java.util.Queue;
import java.util.LinkedList;
import java.util.ArrayList;

public class Pro_LongestNode {
	
    public static int solution(int n, int[][] edge) {
        int answer = 0;
        boolean[] visited = new boolean[n + 1];
        ArrayList<Integer>[] map = new ArrayList[n + 1];
        for(int idx = 1; idx < n + 1; ++idx) {
        	map[idx] = new ArrayList();
        }
        
        Queue<Integer> q = new LinkedList();
        
        for(int idx = 0; idx < edge.length; ++idx) {
        	map[edge[idx][0]].add(edge[idx][1]);
        	map[edge[idx][1]].add(edge[idx][0]);
        }
        
        int max = 0;
        q.offer(1);
        q.offer(0);
        visited[1] = true;
        
        while(!q.isEmpty()) {
        	int node = q.poll();
        	int count = q.poll();
        	if(count > max) {
        		max = count;
        		answer = 1;
        	}
        	else ++answer;
        	
        	for(int idx = 0; idx < map[node].size(); ++idx) {
        		int next = map[node].get(idx);
        		if(!visited[next]) {
        			visited[next] = true;
        			q.offer(next);
        			q.offer(count + 1);
        		}
        	}
        }
        
        return answer;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 6;
		int[][] edge = {{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}};
		
		solution(n, edge);
	}

}
