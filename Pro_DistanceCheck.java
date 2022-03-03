
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
        				//�ٷ� �Ʒ��� ���
        				if(row + 1 < len && places[room][row + 1].charAt(col) == candidate) {
        					check = 0;
        					break;
        				}
        				
        				//�ٷ� ���� ���
        				if(col + 1 < len && places[room][row].charAt(col + 1) == candidate) {
        					check = 0;
        					break;
        				}
        				
        				//��ĭ ���� �Ʒ��� ���
        				if(row + 2 < len && places[room][row + 2].charAt(col) == candidate && places[room][row + 1].charAt(col) != block) {
        					check = 0;
        					break;
        				}
        				
        				//��ĭ ���� ���� ���
        				if(col + 2 < len && places[room][row].charAt(col + 2) == candidate && places[room][row].charAt(col + 1) != block) {
        					check = 0;
        					break;
        				}
        				
        				//���� �밢�� ���
        				if(col + 1 < len && row + 1 < len && places[room][row + 1].charAt(col + 1) == candidate && (places[room][row + 1].charAt(col) != block || places[room][row].charAt(col + 1) != block)) {
        					check = 0;
        					break;
        				}
        				
        				//���� �밢�� ���
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
