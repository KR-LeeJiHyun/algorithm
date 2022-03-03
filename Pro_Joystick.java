import java.util.ArrayList;

public class Pro_Joystick {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		solution("BBBBAAAABA");
	}
	
    public static int solution(String name) {
        int answer = 0, idx = 0;
        boolean check = true;
        ArrayList<Integer> start = new ArrayList<>(), end = new ArrayList<>();
        
        for(char alphabet : name.toCharArray()) {
        	if(alphabet == 'A' && check && idx != 0) {
        		start.add(idx);
        		check = false;
        	}
        	else if(alphabet != 'A' && !check) {
        		end.add(idx - 1);
        		check = true;
        	}
        	
        	answer += Math.min(alphabet - 'A', 'Z' - alphabet + 1);
        	++idx;
        }
        
        if(end.size() < start.size()) end.add(idx - 1);
        
        int min = name.length() - 1;
        for(int i = 0; i < start.size(); ++i) {
        	min = Math.min(Math.min((start.get(i) - 1) * 2 + (name.length() - 1 - end.get(i)), (name.length() - 1 - end.get(i)) * 2 + (start.get(i) - 1)), min);
        }
        
        return answer + min;
    }

}
