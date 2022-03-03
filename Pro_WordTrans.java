import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class Pro_WordTrans {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String begin = "hit", target = "cog";
		String[] words = {"hot", "dot", "dog", "lot", "log", "cog"};
		solution(begin, target, words);
	}
	
    public static int solution(String begin, String target, String[] words) {
        int answer = 0;
        
        Queue<String> qWord = new LinkedList<>();
        Queue<Integer> qCnt = new LinkedList<>();
        HashSet<String> visited = new HashSet<>();
        ArrayList<String> wordList = new ArrayList<>();
        
        for(String tmp : words) wordList.add(tmp);
        
        
        qWord.add(begin);
        qCnt.add(0);
        visited.add(begin);
        
        while(!qWord.isEmpty()) {
        	String cWord = qWord.poll();
        	int tmpAnswer = qCnt.poll();
        	
        	if(cWord.equals(target)) {
        		answer = tmpAnswer;
        		break;
        	}
        	
        	for(int idx = 0; idx < cWord.length(); ++idx) {
        		if(cWord.charAt(idx) != target.charAt(idx)) {
        			for(int aIdx = 0; aIdx < 26; ++aIdx) {
        				String tmpWord = cWord.substring(0, idx) + (char)('a' + aIdx) + cWord.substring(idx + 1);
        				if(!visited.contains(tmpWord) && wordList.contains(tmpWord)) {
        					visited.add(tmpWord);
        					qWord.add(tmpWord);
        					qCnt.add(tmpAnswer + 1);
        				}
        			}
        		}
        	}
        }
        
        return answer;
    }
    
    public static int solution1(String begin, String target, String[] words) {
        int answer = 0;
        
        Queue<String> qWord = new LinkedList<>();
        Queue<Integer> qCnt = new LinkedList<>();
        HashSet<String> visited = new HashSet<>();
        ArrayList<String> wordList = new ArrayList<>();
        
        for(String tmp : words) wordList.add(tmp);
        
        
        qWord.add(begin);
        qCnt.add(0);
        visited.add(begin);
        
        while(!qWord.isEmpty()) {
        	String cWord = qWord.poll();
        	int tmpAnswer = qCnt.poll();
        	
        	if(cWord.equals(target)) {
        		answer = tmpAnswer;
        		break;
        	}
        	
        	for(int idx = 0; idx < cWord.length(); ++idx) {
        		if(cWord.charAt(idx) != target.charAt(idx)) {
        			for(int aIdx = 0; aIdx < 26; ++aIdx) {
        				String tmpWord = cWord.substring(0, idx) + (char)('a' + aIdx) + cWord.substring(idx + 1);
        				if(!visited.contains(tmpWord) && wordList.contains(tmpWord)) {
        					visited.add(tmpWord);
        					qWord.add(tmpWord);
        					qCnt.add(tmpAnswer + 1);
        				}
        			}
        		}
        	}
        }
        
        return answer;
    }
}
