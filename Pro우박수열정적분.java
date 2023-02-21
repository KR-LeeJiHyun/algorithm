import java.util.ArrayList;

public class Pro우박수열정적분 {

	public static void main(String[] args) {
		
		int k = 5;
		int[][] ranges = {{0, 0}, {0, -1}, {2, -3}, {3, -3}};
		Pro우박수열정적분 s = new Pro우박수열정적분();
		s.solution(k, ranges);

	}
	
    public double[] solution(int k, int[][] ranges) {
        double[] answer = {};
        
        ArrayList<Integer> list = new ArrayList<>();
        list.add(k);
        
        while(k != 1) {
        	if(k % 2 == 0) {
        		k /= 2;
        	}
        	else {
        		k = k * 3 + 1;
        	}
        	list.add(k);
        }
        
        int len = list.size();
        ArrayList<Double> tmp = new ArrayList<>();
        
        for(int idx = 0; idx < ranges.length; ++idx) {
        	int start = ranges[idx][0];
        	int end = len + ranges[idx][1];
        	double area = 0;
        	if(start > end - 1) {
        		area = -1.0d;
        	}
        	for(; start < end - 1; ++start) {
        		area += (list.get(start) + list.get(start + 1)) / 2;
        	}
        	tmp.add(area);
        }
        
        answer = new double[tmp.size()];
        for(int idx = 0; idx < tmp.size(); ++idx) {
        	answer[idx] = tmp.get(idx);
        }
        
        return answer;
    }

}
