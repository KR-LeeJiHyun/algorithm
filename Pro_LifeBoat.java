import java.util.Arrays;

public class Pro_LifeBoat {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] people = {70, 80, 50};
		int limit = 100;
		solution(people, limit);
	}
	
    public static int solution(int[] people, int limit) {
        int answer = 0, pcnt = 0, len = people.length, left = 0, right = len - 1;
        Arrays.sort(people);
        
        while(pcnt != len) {
        	int sum = 0;
        	sum += people[right--];
        	++pcnt;
        	if(left <= right && sum + people[left] <= limit) {
        		++pcnt;
        		++left;
        	}
        	++answer;
        }
        
        return answer;
    }

}
