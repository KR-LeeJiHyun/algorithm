import java.util.HashMap;
import java.util.Objects;

public class Pro숫자타자대회 {

	public static void main(String[] args) {
		String numbers = "1756";
		Pro숫자타자대회 s = new Pro숫자타자대회();
		s.solution(numbers);
	}
	
	class FingerPos {
		int l;
		int r;
		
		FingerPos(int l, int r) {
			this.l = l;
			this.r = r;
		}
		
		@Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            FingerPos fingerPos = (FingerPos) o;
            return l == fingerPos.l && r == fingerPos.r;
        }

        @Override
        public int hashCode() {
            return Objects.hash(l, r);
        }
	}
	
	final int[][] costs = { 
				{ 1, 7, 6, 7, 5, 4, 5, 3, 2, 3 },
            	{ 7, 1, 2, 4, 2, 3, 5, 4, 5, 6 },
            	{ 6, 2, 1, 2, 3, 2, 3, 5, 4, 5 },
            	{ 7, 4, 2, 1, 5, 3, 2, 6, 5, 4 },
            	{ 5, 2, 3, 5, 1, 2, 4, 2, 3, 5 },
            	{ 4, 3, 2, 3, 2, 1, 2, 3, 2, 3 },
            	{ 5, 5, 3, 2, 4, 2, 1, 5, 3, 2 },
            	{ 3, 4, 5, 6, 2, 3, 5, 1, 2, 4 },
            	{ 2, 5, 4, 5, 3, 2, 3, 2, 1, 2 },
            	{ 3, 6, 5, 4, 5, 3, 2, 4, 2, 1 } 
            }; 
	
	HashMap<FingerPos, Integer> q = new HashMap<>();
	HashMap<FingerPos, Integer> tmp;
	
    public int solution(String numbers) {
        int answer = Integer.MAX_VALUE;
        final int LEN = numbers.length();
        
        q.put(new FingerPos(4, 6), 0);
        for(int idx = 0; idx < LEN; ++idx) {
        	int number = Character.getNumericValue(numbers.charAt(idx));
        	tmp = new HashMap<>();
        	move(number);
        	q = tmp;
        }
        
        for(FingerPos key : q.keySet()) {
        	answer = Math.min(answer, q.get(key));
        }
        
        return answer;
    }

	private void move(int number) {
		for(FingerPos curr : q.keySet()) {
			int l = curr.l;
			int r = curr.r;
			int cost = q.get(curr);
			
			FingerPos next;
			if(number == l) {
				next = new FingerPos(number, r);
				if(!tmp.containsKey(next) || tmp.get(next) > cost + 1) {
					tmp.put(next, cost + 1);
				}
			}
			else if (number == r) {
				next = new FingerPos(l, number);
				if(!tmp.containsKey(next) || tmp.get(next) > cost + 1) {
					tmp.put(next, cost + 1);
				}
			}
			else {
				next = new FingerPos(number, r);
				int lcost = cost + costs[l][number];
				if(!tmp.containsKey(next) || tmp.get(next) > lcost) {
					tmp.put(next, lcost);
				}
				next = new FingerPos(l, number);
				int rcost = cost + costs[r][number];
				if(!tmp.containsKey(next) || tmp.get(next) > rcost) {
					tmp.put(next, rcost);
				}
			}
		}
		
	}
}
