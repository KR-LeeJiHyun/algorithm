import java.util.HashMap;

public class Pro_VowelDic {

	public static void main(String[] args) {
		solution("E");
	}
	
    public static int solution(String word) {
        int answer = 0;
        char[] vowels = {'A', 'E', 'I', 'O', 'U'};
        HashMap<String, Integer> dic = new HashMap<>();
        
        dfs(vowels, dic, "");
        
        answer = dic.get(word);
        return answer;
//        int answer = 0, per = 3905;
//        for(String s : word.split("")) answer += "AEIOU".indexOf(s) * (per /= 5) + 1;
//        return answer;
    }

	private static void dfs(char[] vowels, HashMap<String, Integer> dic, String word) {
		if(word.length() == 5) return;
		for(char vowel : vowels) {
			dic.put(word + vowel, dic.size() + 1);
			dfs(vowels, dic, word + vowel);
		}
	}

}

