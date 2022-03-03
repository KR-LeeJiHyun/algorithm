import java.util.TreeMap;
import java.util.ArrayList;
import java.util.Arrays;
public class Pro_FaultRate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int N = 5;
		int[] stages = {2, 1, 2, 6, 2, 4, 3, 3};
		
		double a = 0.0d, b = 0.4d;
		
		solution(N, stages);
	}
	
    public static int[] solution(int N, int[] stages) {
        int[] answer = {};
        Arrays.sort(stages);
        answer = new int[N];
        TreeMap<Double, ArrayList<Integer>> map = new TreeMap<>();
        int sIdx = 0;
        int sum = stages.length;
        for(int stage = 1; stage <=N; ++stage) {
        	double no = 0;
        	for(int idx = sIdx; idx < stages.length; ++idx) {
        		if(stages[idx] == stage) { 
        			++no;
        			if(idx + 1 == stages.length) {
            			double fault = no /sum;
            			if(!map.containsKey(fault)) map.put(fault, new ArrayList<>());
            			map.get(fault).add(stage);
        			}
        		}
        		else {
        			double fault = no /sum;
        			if(!map.containsKey(fault)) map.put(fault, new ArrayList<>());
        			map.get(fault).add(stage);
        			sum -= no;
        			sIdx = idx;
        			break;
        		}
        	}
        }
        
        ArrayList<Integer> tmpAnswer = new ArrayList<>();
        for(double key : map.keySet()) {
        	ArrayList<Integer> tmpList = map.get(key);
        	for(int idx = tmpList.size() - 1; idx > -1; --idx) {
        		tmpAnswer.add(0, (Integer) tmpList.get(idx));
        	}
        }
        
        int idx = 0;
        for(int tmp : tmpAnswer) answer[idx++] = tmp;
        
        return answer;
    }

}
