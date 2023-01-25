import java.util.PriorityQueue;

public class Pro_PerfomanceAppraisal {

	public static void main(String[] args) {
		int[][] scores = {{2, 10}, {10, 9}, {10, 8}, {9, 10}, {9, 9}, {9, 8}, {7, 8}};
		Pro_PerfomanceAppraisal PPA = new Pro_PerfomanceAppraisal();
		System.out.println(PPA.solution(scores));
	}
	
	class Score implements Comparable<Score>{
		int a;
		int b;
		int sum;
		
		public Score(int a, int b) {
			this.a = a;
			this.b = b;
			this.sum = a + b;
		}
		
		@Override
		public int compareTo(Score o) {
			return o.a - this.a;
		}
	}

    public int solution(int[][] scores) {
		int answer = 1;
		final int LEN = scores.length;
		final int MAX = 100000;
		int[] maxScore = new int[MAX + 2];
		PriorityQueue<Score> pq = new PriorityQueue<>();
		
		for(int idx = 0; idx < LEN; ++idx) pq.add(new Score(scores[idx][0], scores[idx][1]));
		int prevA = pq.peek().a + 1;
		int wA = scores[0][0];
		int wB = scores[0][1];
		int wanho = scores[0][0] + scores[0][1];
		
		while(!pq.isEmpty()) {
			Score s = pq.poll();
			int a = s.a;
			int b = s.b;
			int sum = s.sum;
			
			maxScore[a] = Math.max(maxScore[a], maxScore[prevA]);
			
			if(b < maxScore[prevA]) {
				if(a == wA && b == wB) {
					answer = -1;
					break;
				}
			}
			else {
				maxScore[a] = Math.max(maxScore[a], b);
				if(wanho < sum) ++answer;
			}
			
			if(!pq.isEmpty() && a != pq.peek().a) prevA = a;
		}

		return answer;
    }
	
	/*
	class Score implements Comparable<Score>{
        int a;
        int p;
        int sum;

        public Score(int a, int p) {
            this.a = a;
            this.p = p;
            this.sum = a + p;
        }

        @Override
        public int compareTo(Score o) {
            if(o.a == this.a) return o.p - this.p;
            return o.a - this.a;
        }
    }

    public int solution(int[][] scores) {
        int answer = 1;
        final int LEN = scores.length;
        PriorityQueue<Score> pq = new PriorityQueue<>();

        for(int idx = 0; idx < LEN; ++idx) pq.add(new Score(scores[idx][0], scores[idx][1]));

        int maxP = 0;
        int wA = scores[0][0];
        int wP = scores[0][1];
        int wanho = scores[0][0] + scores[0][1];

        while(!pq.isEmpty()) {
            Score s = pq.poll();

            while(!pq.isEmpty() && pq.peek().a == s.a) {
                Score s2 = pq.poll();
                if(maxP > s2.p) {
                    if(wA == s2.a && wP == s2.p) {
                    answer = -1;
                    break;
                }
                    continue;
                }
                else {
                    if(wanho < s2.sum) ++answer;
                }
            }

            if(answer == -1) {
                break;
            }

            if(maxP > s.p) {
                if(wA == s.a && wP == s.p) {
                    answer = -1;
                    break;
                }
                continue;
            }
            else {
                maxP = s.p;
                if(wanho < s.sum) ++answer;
            }
        }

        return answer;
    }
	 */

}
