import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map.Entry;
import java.util.TreeMap;

public class Pro_BestAlbum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] genres = {"classic", "pop", "classic", "classic", "pop"};
		int[] plays = {500, 600, 150, 800, 2500};
		
		solution(genres, plays);
	}
	
	static class Pair {
		int idx;
		int play;
		
		public Pair(int idx, int play) {
			this.idx = idx;
			this.play = play;
		}
	}
	
    public static int[] solution(String[] genres, int[] plays) {
        int[] answer = {};
        TreeMap<String, Integer> gMap = new TreeMap<>();
        TreeMap<String, ArrayList<Pair>> pMap = new TreeMap<>();
        
        for(int idx = 0; idx < genres.length; ++idx) {
        	String genre = genres[idx];
        	int play = plays[idx];
        	if(!gMap.containsKey(genres[idx])) {
        		gMap.put(genre, 0);
        		pMap.put(genre, new ArrayList<>());
        	}
        	
        	gMap.put(genre, gMap.get(genre) + play);
        	ArrayList<Pair> list = pMap.get(genre);
        	list.add(new Pair(idx, play));
        }
        
        ArrayList<Entry<String, Integer>> eList = new ArrayList<Entry<String, Integer>>(gMap.entrySet());
        Collections.sort(eList, new Comparator<Entry<String, Integer>>() {
        	public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {
        		return o2.getValue() - o1.getValue();
        	}
		});
        
        ArrayList<Integer> tmpAnswer = new ArrayList<Integer>();
        
        for(Entry<String, Integer> tmp : eList) {
        	ArrayList<Pair> pList = pMap.get(tmp.getKey());
        	Collections.sort(pList, new Comparator<Pair>() {
        		public int compare(Pro_BestAlbum.Pair o1, Pro_BestAlbum.Pair o2) {
        			return o2.play - o1.play;
        		}
			});
        	
        	for(int idx = 0; idx < Math.min(2, pList.size()); ++idx) tmpAnswer.add(pList.get(idx).idx);
        }
        
        answer = new int[tmpAnswer.size()];
        for(int idx = 0; idx < tmpAnswer.size(); ++idx) answer[idx] = tmpAnswer.get(idx);
        return answer;
    }

}
