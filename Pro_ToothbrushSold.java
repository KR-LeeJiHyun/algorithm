import java.util.HashMap;

public class Pro_ToothbrushSold {
	
    public static int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        int[] answer = new int [enroll.length];
        final int unit = 100, percent = 10;
        String root = "-";
        
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        
        for(int idx = 0; idx < enroll.length; ++idx) map.put(enroll[idx], idx);
        
        for(int idx = 0; idx < seller.length; ++idx) {
        	int soldAmount = amount[idx] * unit;
        	String sell = seller[idx];
        	
        	while(!sell.equals(root)) {
        		int sell_idx = map.get(sell);
        		int benefit = soldAmount - (soldAmount / percent);
        		answer[sell_idx] += benefit;
        		soldAmount -= benefit;
        		if(soldAmount == 0)  break;
        		sell = referral[sell_idx];
        	}
        }
        
        return answer;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] enroll = {	
				"john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young"
		}, 
		referral = {
				"-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward"
		}, 
		seller = {
				"sam", "emily", "jaimie", "edward"
		};
		
		int[] amount = {
				2, 3, 5, 4
		};
		
		solution(enroll, referral, seller, amount);
	}

}
