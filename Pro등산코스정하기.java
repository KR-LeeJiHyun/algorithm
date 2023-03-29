import java.util.PriorityQueue;

public class Pro등산코스정하기 {

	public static void main(String[] args) {
		int n = 7;
		int[][] paths = {{1, 4, 4}, {1, 6, 1}, {1, 7, 3}, {2, 5, 2}, {3, 7, 4}, {5, 6, 6}};
		int[] gates = {2};
		int[] summits ={3, 4};
		Pro등산코스정하기 S = new Pro등산코스정하기();
		S.solution(n, paths, gates, summits);

	}
	
	class Edge implements Comparable<Edge>{
		int idx;
		int intensity;
		
		Edge(int idx, int intensity) {
			this.idx = idx;
			this.intensity = intensity;
		}
		
		public int compareTo(Edge o) {
			if(this.intensity == o.intensity) {
				return this.idx - o.idx;
			}
			return this.intensity - o.intensity;
		}
	}
	
    public int[] solution(int n, int[][] paths, int[] gates, int[] summits) {
        int[] answer = {Integer.MAX_VALUE, Integer.MAX_VALUE};
        
        PriorityQueue<Edge>[] pq = new PriorityQueue[n + 1];
        
        for(int idx = 1; idx <= n; ++idx) {
        	pq[idx] = new PriorityQueue<>();
        }
        
        for(int idx = 0; idx < paths.length; ++idx) {
        	int node1 = paths[idx][0];
        	int node2 = paths[idx][1];
        	int intensity = paths[idx][2];
        	
        	pq[node1].add(new Edge(node2, intensity));
        	pq[node2].add(new Edge(node1, intensity));
        }
        
        boolean[] summit = new boolean[n + 1];
        for(int idx = 0; idx < summits.length; ++idx) {
        	summit[summits[idx]] = true;
        }
        
        boolean[] visited = new boolean[n + 1];
        PriorityQueue<Edge> q = new PriorityQueue<>();
        
        for(int idx = 0; idx < gates.length; ++idx) {
        	q.add(new Edge(gates[idx], 0));
        }
        
        while(!q.isEmpty()) {
        	Edge current = q.poll();
        	if(visited[current.idx]) {
        		continue;
        	}
        	visited[current.idx] = true;
        	if(summit[current.idx] && current.intensity <= answer[1]) {
        		answer[0] = Math.min(current.idx, answer[0]);
        		answer[1] = current.intensity;
        		continue;
        	}
        	
        	while(!pq[current.idx].isEmpty()) {
        		Edge next = pq[current.idx].poll();
        		if(!visited[next.idx]) {
        			next.intensity = Math.max(next.intensity, current.intensity);
        			if(next.intensity <= answer[1]) {
        				q.add(next);
        			}
        		}
        	}
        }
        
        
        return answer;
    }

}
