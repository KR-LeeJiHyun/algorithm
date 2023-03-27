import java.util.PriorityQueue;

public class Pro광물캐기 {
	
	public static void main(String[] args) {
		int[] picks = {0, 1, 1};
		String[] minerals = {"diamond", "diamond", "diamond", "diamond", "diamond", "iron", "iron", "iron", "iron", "iron", "diamond"};
		Pro광물캐기 S = new Pro광물캐기();
		S.solution(picks, minerals);
	}
	
	class Ore implements Comparable<Ore> {
		int diamond;
		int iron;
		int stone;
		
		Ore(int diamond, int iron, int stone) {
			this.diamond = diamond;
			this.iron = iron;
			this.stone = stone;
		}
		
		public void setDiamond() {
			++this.diamond;
		}
		
		public void setIron() {
			++this.iron;
		}
		
		public void setStone() {
			++this.stone;
		}
		
		public int compareTo(Ore o) {
			if(this.diamond == o.diamond) {
				if(this.iron == o.iron) {
					return o.stone - this.stone;
				}
				else {
					return o.iron - this.iron;
				}
			}
			return o.diamond - this.diamond;
		}
	}
	
    public int solution(int[] picks, String[] minerals) {
        int answer = 0;
        final int LEN = minerals.length;
        PriorityQueue<Ore> pq = new PriorityQueue<>();
        final int CNT = (picks[0] + picks[1] + picks[2]) * 5;
        int unit = 5;
        Ore ore = null;
        for(int idx = 0; idx < LEN; ++idx) {
        	if(idx % unit == 0) {
        		if(ore != null) {
        			pq.add(ore);
        		}
        		ore = new Ore(0, 0, 0);
        	}
        	if(CNT == idx) {
        		break;
        	}
        	if(minerals[idx].charAt(0) == 'd') {
        		ore.setDiamond();
        	}
        	else if(minerals[idx].charAt(0) == 'i') {
        		ore.setIron();
        	}
        	else {
        		ore.setStone();
        	}
        }
        
        if(pq.size() * 5 <= CNT) {
        	pq.add(ore);
        }
        
        while(!pq.isEmpty()) {
        	Ore current = pq.poll();
        	if(picks[0] > 0) {
                --picks[0];
        		answer += current.diamond + current.iron + current.stone;
            }
        	else if(picks[1] > 0) {
                --picks[1];
        		answer += current.diamond * 5 + current.iron + current.stone;
            }
            else {
                --picks[2];
        		answer += current.diamond * 25 + current.iron * 5 + current.stone;
            }
        }
        
        return answer;
    }
}
