import java.util.Arrays;
import java.util.HashMap;

public class Pro_NoneFinish {
	
	public String hash_solution(String[] participant, String[] completion) {
		 String answer = "";
		 HashMap<String, Integer> map = new HashMap<>();
		 
		 for(int idx = 0; idx <completion.length; ++idx) {
			Integer tmp = map.get(completion[idx]);
			
			if(tmp == null) map.put(completion[idx], 1);
			else {
				int count = tmp;
				map.put(completion[idx], count + 1);
			}
		 }
		 for(int idx = 0; idx < participant.length; ++idx) {
				Integer tmp = map.get(participant[idx]);
				
				if(tmp == null || tmp < 1) return participant[idx];
				else {
					int count = tmp;
					map.put(participant[idx], count - 1);
				}
			 }
		 
		 return answer;
	 }

	
	 public String solution(String[] participant, String[] completion) {
		 Arrays.sort(participant);
		 Arrays.sort(completion);

		 for(int idx = 0; idx < completion.length; ++idx) {
			 if(!completion[idx].equals(participant[idx])) {
				 return participant[idx];
			 }
		 }

		 return participant[participant.length - 1];
	 }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
