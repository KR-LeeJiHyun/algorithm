import java.util.Arrays;
import java.util.Comparator;

public class Pro_SurveillanceCamera {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public int solution(int[][] routes) {
        int answer = 0;
        
        Arrays.sort(routes, new Comparator<int[]>() {
        	public int compare(int[] o1, int[] o2) {
        		return o1[1] - o2[1];
        	}
		});
        
        int prev = -30001;
        for(int idx = 0; idx < routes.length; ++idx) {
        	if(prev < routes[idx][0]) {
        		++answer;
        		prev = routes[idx][1];
        	}
        }
        
        return answer;
    }
}
