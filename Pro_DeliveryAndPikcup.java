
public class Pro_DeliveryAndPikcup {

	public static void main(String[] args) {
		Pro_DeliveryAndPikcup PDAP = new Pro_DeliveryAndPikcup();
		int cap = 4;
		int n = 5;
		int[] deliveries = {1, 0, 3, 1, 2};
		int[] pickups = {0, 3, 0, 4, 0};
		System.out.println(PDAP.solution(cap, n, deliveries, pickups));
	}
	
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;
        
        int dIdx = n - 1;
        int pIdx = n - 1;
        
        while(dIdx != -1 || pIdx != -1) {
        	int d = 0;
        	int p = 0;
        	int dis = -1;
        	
        	while(d != cap && dIdx != -1) {
        		if(deliveries[dIdx] == 0) --dIdx;
        		else {
        			dis = Math.max(dIdx, dis);
        			int tmpD = d;
        			d = Math.min(d + deliveries[dIdx], cap);
        			deliveries[dIdx] = Math.max(0, deliveries[dIdx]- cap + tmpD);
        		}
        	}
        	
        	while(p != cap && pIdx != -1) {
        		if(pickups[pIdx] == 0) --pIdx;
        		else {
        			dis = Math.max(pIdx, dis);
        			int tmpP = p;
        			p = Math.min(p + pickups[pIdx], cap);
        			pickups[pIdx] = Math.max(0, pickups[pIdx]- cap + tmpP);
        		}
        	}
        	
        	answer += (dis + 1) * 2;
        	
        }
        
        return answer;
    }

}
