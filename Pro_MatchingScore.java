import java.util.ArrayList;
import java.util.HashMap;

public class Pro_MatchingScore {

	public static void main(String[] args) {
		/*String[] pages = {
				"<html lang=\"ko\" xml:lang=\"ko\" xmlns=\"http://www.w3.org/1999/xhtml\">\n<head>\n  <meta charset=\"utf-8\">\n  <meta property=\"og:url\" content=\"https://a.com\"/>\n</head>  \n<body>\nBlind Lorem Blind ipsum dolor Blind test sit amet, consectetur adipiscing elit. \n<a href=\"https://b.com\"> Link to b </a>\n</body>\n</html>", 
				"<html lang=\"ko\" xml:lang=\"ko\" xmlns=\"http://www.w3.org/1999/xhtml\">\n<head>\n  <meta charset=\"utf-8\">\n  <meta property=\"og:url\" content=\"https://b.com\"/>\n</head>  \n<body>\nSuspendisse potenti. Vivamus venenatis tellus non turpis bibendum, \n<a href=\"https://a.com\"> Link to a </a>\nblind sed congue urna varius. Suspendisse feugiat nisl ligula, quis malesuada felis hendrerit ut.\n<a href=\"https://c.com\"> Link to c </a>\n</body>\n</html>", 
				"<html lang=\"ko\" xml:lang=\"ko\" xmlns=\"http://www.w3.org/1999/xhtml\">\n<head>\n  <meta charset=\"utf-8\">\n  <meta property=\"og:url\" content=\"https://c.com\"/>\n</head>  \n<body>\nUt condimentum urna at felis sodales rutrum. Sed dapibus cursus diam, non interdum nulla tempor nec. Phasellus rutrum enim at orci consectetu blind\n<a href=\"https://a.com\"> Link to a </a>\n</body>\n</html>"
		};
	
		String word = "Blind";*/
		
		String[] pages = {
		"<html lang=\"ko\" xml:lang=\"ko\" xmlns=\"http://www.w3.org/1999/xhtml\">\n<head>\n  <meta charset=\"utf-8\">\n  <meta property=\"og:url\" content=\"https://careers.kakao.com/interview/list\"/>\n</head>  \n<body>\n<a href=\"https://programmers.co.kr/learn/courses/4673\"></a>#!MuziMuzi!)jayg07con&&\n\n</body>\n</html>",
		"<html lang=\"ko\" xml:lang=\"ko\" xmlns=\"http://www.w3.org/1999/xhtml\">\n<head>\n  <meta charset=\"utf-8\">\n  <meta property=\"og:url\" content=\"https://www.kakaocorp.com\"/>\n</head>  \n<body>\ncon%\tmuzI92apeach&20muzi0muzi0<a href=\"https://hashcode.co.kr/tos\"></a>\n\n\t^\n</body>\n</html>"
		};
		String word = "Muzi";
		
		/*Pattern pattern = Pattern.compile("[^a-z]blind[^a-z]");
		Matcher matcher = pattern.matcher(s.toLowerCase());
		int cnt = (int) matcher.results().count();
		System.out.print(cnt);*/
		
		solution(word, pages);
	}
	
    public static int solution(String word, String[] pages) {
        int answer = 0;
        ArrayList<String> names = new ArrayList<>();
        HashMap<String, Integer> basic = new HashMap<>(), sizes = new HashMap<>();
        HashMap<String, ArrayList<String>> links = new HashMap<>();
        for(String page : pages) {
        	String name = search_name(page);
        	names.add(name);
        	basic.put(name, search_word(word.toLowerCase(), page.replaceAll("<[^>]*>","").toLowerCase()));
        	ArrayList<String> list = search_link(page);
        	sizes.put(name, list.size());
        	for(String link : list) {
        		if(!links.containsKey(link)) links.put(link, new ArrayList<>());
        		links.get(link).add(name);
        	}
        }
        
        double max = 0;
        for(int idx = 0; idx < names.size(); ++idx) {
        	String key = names.get(idx);
        	double score = basic.get(key);
        	if(links.containsKey(key)) { 
        		for(String link : links.get(key)) { 
        			double size = (double)sizes.get(link);
        			if(size != 0) score += (double)basic.get(link) / size; 
        		}
        	}
        	if(max < score) {
        		max = score;
        		answer = idx;
        	}
        }
        
        return answer;
    }

	private static int search_word(String word, String page) {
		int start = 0, cnt = 0;
		
		while(true) {
			start = page.indexOf(word, start + 1);
            if(start == -1) break;
			if(start != 0) {
				if(page.charAt(start - 1) >= 'a' && page.charAt(start - 1) <= 'z') continue;
			}
			if(start + word.length() < page.length()) {
				if(page.charAt(start + word.length()) >= 'a' && page.charAt(start + word.length()) <= 'z') continue;
			}
			++cnt;
		}

		return cnt;
	}

	private static ArrayList<String> search_link(String page) {
		ArrayList<String> links = new ArrayList<>();
		String s = "<a href=\"https://", e ="\"";
		int start = 0, end = 0;
		
		while(true) {
			start = page.indexOf(s, end);
			if(start == -1) break;
			start += s.length();
			end = page.indexOf(e, start);
			String link = page.substring(start, end);
			links.add(link);
		}
		
		return links;
	}

	private static String search_name(String page) {
		String name = "";
		String s = "<meta property=\"og:url\" content=\"https://", e ="\"";
		int start = page.indexOf(s) + s.length(), end = page.indexOf(e, start);
		name = page.substring(start, end);
		return name;
	}

}
