
public class Pro_DistanceCheck {
	
    public static int[] solution(String[][] places) {
    	final int len = 5;
    	final char candidate = 'P', empty = 'O', block = 'X';
    	int[] answer = new int[len];
        
        for(int room = 0; room < len; ++room) {
        	int check = 1;
        	for(int row = 0; row < len; ++row) {
        		for(int col = 0; col < len; ++col) {
        			
        			char tmp = places[room][row].charAt(col);
        			if(tmp == candidate) {
        				//바로 아래에 사람
        				if(row + 1 < len && places[room][row + 1].charAt(col) == candidate) {
        					check = 0;
        					break;
        				}
        				
        				//바로 옆에 사람
        				if(col + 1 < len && places[room][row].charAt(col + 1) == candidate) {
        					check = 0;
        					break;
        				}
        				
        				//한칸 띄우고 아래에 사람
        				if(row + 2 < len && places[room][row + 2].charAt(col) == candidate && places[room][row + 1].charAt(col) != block) {
        					check = 0;
        					break;
        				}
        				
        				//한칸 띄우고 옆에 사람
        				if(col + 2 < len && places[room][row].charAt(col + 2) == candidate && places[room][row].charAt(col + 1) != block) {
        					check = 0;
        					break;
        				}
        				
        				//우하 대각선 사람
        				if(col + 1 < len && row + 1 < len && places[room][row + 1].charAt(col + 1) == candidate && (places[room][row + 1].charAt(col) != block || places[room][row].charAt(col + 1) != block)) {
        					check = 0;
        					break;
        				}
        				
        				//좌하 대각선 사람
        				if(col - 1 > -1 && row + 1 < len && places[room][row + 1].charAt(col - 1) == candidate && (places[room][row + 1].charAt(col) != block || places[room][row].charAt(col - 1) != block)) {
        					check = 0;
        					break;
        				}
        			}
        		}
        		if(check == 0) break;
        	}
        	answer[room] = check; 
        }
        
        return answer;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[][] places = {{"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"}, {"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"}, {"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"}, {"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"}, {"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}}; 
		solution(places);
	}

}
