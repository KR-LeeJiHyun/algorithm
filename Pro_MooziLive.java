import java.util.Comparator;
import java.util.ArrayList;
import java.util.Collections;

public class Pro_MooziLive {

	public static void main(String[] args) {
		// TODO Auto-generated method stub]
		/*int[] food_times = {1, 1, 1, 1};
		long k = 4;
		solution(food_times, k);*/
		int a= 1, sum = 0;
		while(a++ < 10) {
			sum+= a*3 >= sum ? a:1;
		}
		
		a= 20;
	}
	
	static class Food{
		int idx;
		int time;
		
		Food(int idx, int time){
			this.idx = idx;
			this.time = time;
		}
	}
	
	static Comparator<Food> compareIdx = new Comparator<Food>() {
		public int compare(Food o1, Food o2) {
			return o1.idx - o2.idx;
		};
	};
	
	static Comparator<Food> compareTime = new Comparator<Food>() {
		public int compare(Food o1, Food o2) {
			return o1.time - o2.time;
		};
	};
	
	public static int solution(int[] food_times, long k) {
		int answer = -1;
		
		ArrayList<Food> list = new ArrayList<>();
		for(int idx = 0; idx < food_times.length; ++idx) list.add(new Food(idx, food_times[idx]));
		Collections.sort(list, compareTime);
		int perTime = 0, idx = 0, len = food_times.length;
		
		while(idx < food_times.length) {
			int time = list.get(idx).time;
			int diff = time - perTime;
			long spend = 0l;
			if(diff > 0) {
				spend = (long)diff * (long)len;
				perTime = time;
			}
			
			if(k < spend) {
				k %= len;
				Collections.sort(list.subList(idx, food_times.length), compareIdx);
				return list.get(idx + (int)k).idx + 1;
			}
			else k -= spend;
			
			++idx;
			--len;
		}
		
		return answer;
	}

	
    /*public static int solution(int[] food_times, long k) {
    	final int MAXN = 100000001, MAX = 100000000;
        int answer = -2;
        int len = food_times.length;
        int start = 0, end = MAX;
        int n = MAXN;
        
        while(start <= end) {
        	int mid = (start + end) / 2;
        	long sum = 0l;
        	for(int idx = 0; idx < len; ++idx) {
        		sum += Math.min(food_times[idx], mid);
        		if(sum >= k) break;
        	}
        	
        	if(sum >= k) {
        		n = Math.min(n, mid); 
        		end = mid - 1;
        	}
        	else if(sum < k) start = mid + 1;
        }
        
        if(n != MAXN) {
        	long nSum = 0l;
        	for(int idx = 0; idx < len; ++idx) nSum += Math.min(food_times[idx], n-1);
        	for(int idx = 0; idx < len; ++idx) {
        		if(food_times[idx] >= n ) {
        			++nSum;
        			if(nSum == k + 1) answer = idx;
        		}
        	}
        	
        	if(answer == -2) {
        		for(int idx = 0; idx < len; ++idx) {
        			if(food_times[idx] > n) {
        				answer = idx;
        				break;
        			}
        		}
        	}
        }
        
        return answer + 1;
    }*/
}
