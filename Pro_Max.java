import java.util.Comparator;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Collections;

public class Pro_Max {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] numbers = {3, 32, 323, 33, 330, 335, 34, 340, 346, 38};
		solution(numbers);
	}

	/*public static String solution(int[] numbers) {
		String answer = "";
		int numLen = numbers.length;
		String[] strNumbers = new String[numLen];
		
		for(int idx = 0; idx < numLen; ++idx) strNumbers[idx] = Integer.toString(numbers[idx]);
		
		Arrays.sort(strNumbers, new Comparator<String>() {
			public int compare(String a, String b) {
				return (b + a).compareTo(a + b);
			}
		});
		
		if(strNumbers[0].equals("0")) return "0";
		
		for(String tmp : strNumbers) answer += tmp;
		
		return answer;
	}*/
	
	   public static String solution(int[] numbers) {
			String answer = "";
			HashMap<Character, ArrayList<String>> map = new HashMap<Character, ArrayList<String>>();

			for(int tmp : numbers) {
				String value = Integer.toString(tmp);
				char key = value.charAt(0);
				if(!map.containsKey(key)) map.put(key, new ArrayList());
				ArrayList<String> list = map.get(key);
				list.add(value);
				map.put(key, list);
			}

			for(char key = '9'; key > '0'; --key) {
				if(map.containsKey(key)) {
					ArrayList<String> list = map.get(key);
					Collections.sort(list, new Comparator<String>(){
						public int compare(String a, String b) {
							return (b + a).compareTo(a + b);
						}
					});

					for(String tmp : list) answer += tmp;
				}
			}

			if(answer.compareTo("") == 0) answer = "0";
			else if(map.containsKey('0')) {
				int loop = map.get('0').size();
				for(int idx = 0; idx < loop; ++idx) answer += "0";
			}

			return answer;
		}
}

/*
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Collections;

   public static String solution(int[] numbers) {
		String answer = "";
		HashMap<Character, ArrayList<String>> map = new HashMap<Character, ArrayList<String>>();

		for(int tmp : numbers) {
			String value = Integer.toString(tmp);
			char key = value.charAt(0);
			if(!map.containsKey(key)) map.put(key, new ArrayList());
			ArrayList<String> list = map.get(key);
			list.add(value);
			map.put(key, list);
		}

		for(char key = '9'; key > '0'; --key) {
			if(!map.containsKey(key)) continue;
			ArrayList<String> list = map.get(key);
			Collections.sort(list);

			while(!list.isEmpty()) {
				String tmpAnswer = list.get(0);
				for(int idx = 1; idx < list.size(); ++idx) {
					String c = list.get(idx);
					if((tmpAnswer + c).compareTo(c + tmpAnswer) <= 0) tmpAnswer = c;
				}
				answer += tmpAnswer;
				list.remove(tmpAnswer);
			}
		}

		if(answer.compareTo("") == 0) answer = "0";
		else if(map.containsKey('0')) answer += "0";

		return answer;
	}
*/

