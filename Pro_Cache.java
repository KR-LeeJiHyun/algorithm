import java.util.ArrayList;

public class Pro_Cache {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        
        if(cacheSize == 0) return cities.length * 5;
        
        ArrayList<String> cache = new ArrayList<>();
        
        for(String city : cities) {
        	city = city.toLowerCase();
        	int idx = cache.indexOf(city);
        	
        	if(idx != -1) {
        		++answer;
        		cache.remove(idx);
        		cache.add(city);
        	}
        	else {
        		answer += 5;
        		if(cache.size() < cacheSize) cache.add(city);
        		else {
        			cache.remove(0);
        			cache.add(city);
        		}
        	}
        	
        }
        
        return answer;
    }

}
