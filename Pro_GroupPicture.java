import java.util.HashMap;

public class Pro_GroupPicture {
	 static int answer = 0;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 2;
		String[] data = {"N~F=0", "R~T>2"};
		
		System.out.print(solution(n, data));
	}
	
	public static int solution(int n, String[] data) {
        HashMap<Integer, Character> map = new HashMap<Integer, Character>();
        map.put(0, 'A');
        map.put(1, 'C');
        map.put(2, 'F');
        map.put(3, 'J');
        map.put(4, 'M');
        map.put(5, 'N');
        map.put(6, 'R');
        map.put(7, 'T');
        boolean[] visited = new boolean[map.size()];
        String picture = "";
        
        dfs(n, data, visited, picture, map);
        
        return answer;
    }
	
	public static void dfs(int n, String[] data, boolean[] visited, String picture, HashMap<Integer, Character> map) {
		int len = map.size();
		if(picture.length() == len) {
			if(check(n, data, picture)) ++answer;
			return;
		}
		for(int idx = 0; idx <len; ++idx) {
			if(!visited[idx]) {
				String tmp_picture = picture + map.get(idx);
				visited[idx] = true;
				dfs(n, data, visited, tmp_picture, map);
				visited[idx] = false;
			}
		}
	}
	
	public static boolean check(int n, String[] data, String picture) {
		for(int idx = 0; idx <n; ++idx) {
			int first = picture.indexOf(data[idx].charAt(0)), second = picture.indexOf(data[idx].charAt(2)), dis = data[idx].charAt(4) - '0' + 1;
			char op = data[idx].charAt(3);
			
			if(op == '=') { 
				if(Math.abs(first - second) != dis) return false;
			}
			else if(op == '>'){
				if(Math.abs(first - second) <= dis) return false;
			}
			else if(op == '<'){
				if(Math.abs(first - second) >= dis) return false;
			}
		}
		return true;
	}
}



/*public static int solution(int n, String[] data) {
int answer = 0;
char[] peoples = {'A', 'C', 'F', 'J', 'M', 'N', 'R', 'T'};
int len = peoples.length;
String picture = "";

for(int idx_1 = 0; idx_1 < len; ++idx_1) {
	picture += peoples[idx_1];
	for(int idx_2 = 0; idx_2 < len; ++idx_2) {
		if(idx_2 != idx_1) picture += peoples[idx_2];
		else continue;
		for(int idx_3 = 0; idx_3 < len; ++idx_3) {
			if(idx_3 != idx_1 && idx_3 != idx_2) picture += peoples[idx_3];
			else continue;
			for(int idx_4 = 0; idx_4 < len; ++idx_4) {
				if(idx_4 != idx_1 && idx_4 != idx_2 && idx_4 != idx_3) picture += peoples[idx_4];
				else continue;
				for(int idx_5 = 0; idx_5 < len; ++idx_5) {
					if(idx_5 != idx_1 && idx_5 != idx_2 && idx_5 != idx_3 && idx_5 != idx_4) picture += peoples[idx_5];
					else continue;
					for(int idx_6 = 0; idx_6 < len; ++idx_6) {
						if(idx_6 != idx_1 && idx_6 != idx_2 && idx_6 != idx_3 && idx_6 != idx_4 && idx_6 != idx_5) picture += peoples[idx_6];
						else continue;
						for(int idx_7 = 0; idx_7 < len; ++idx_7) {
							if(idx_7 != idx_1 && idx_7 != idx_2 && idx_7 != idx_3 && idx_7 != idx_4 && idx_7 != idx_5 && idx_7 != idx_6) picture += peoples[idx_7];
							else continue;
							for(int idx_8 = 0; idx_8 < len; ++idx_8) {
								if(idx_8 != idx_1 && idx_8 != idx_2 && idx_8 != idx_3 && idx_8 != idx_4 && idx_8 != idx_5 && idx_8 != idx_6 && idx_8 != idx_7) {
									picture += peoples[idx_8];
									boolean check = true;
									for(int idx = 0; idx <n; ++idx) {
										int first = picture.indexOf(data[idx].charAt(0)), second = picture.indexOf(data[idx].charAt(2)), dis = data[idx].charAt(4) - '0' + 1;
										char op = data[idx].charAt(3);
										
										if(op == '=') { 
											if(Math.abs(first - second) != dis) {
											check = false;
											break;
											}
										}
										else if(op == '>'){
											if(Math.abs(first - second) <= dis) {
												check = false;
												break;
											}
										}
										else if(op == '<'){
											if(Math.abs(first - second) >= dis) {
												check = false;
												break;
											}
										}
									}
									if(check) ++answer;
									picture = picture.substring(0, 7);
								}
				        	}
							picture = picture.substring(0, 6);
			        	}
						picture = picture.substring(0, 5);
		        	}
					picture = picture.substring(0, 4);
	        	}
				picture = picture.substring(0, 3);
        	}
			picture = picture.substring(0, 2);
    	}
		picture = picture.substring(0, 1);
	}
	picture = "";
}

return answer;
}*/