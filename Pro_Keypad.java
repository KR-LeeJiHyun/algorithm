
public class Pro_Keypad {
	
	 public static String solution(int[] numbers, String hand) {
	        String answer = "";
	        
	        int [] left = {3, 0}, right = {3, 2};
	        
	        for(int idx = 0; idx < numbers.length; ++idx) {
	        	if(numbers[idx] == 1 || numbers[idx] == 4 || numbers[idx] == 7) {
	        		int num_row = (numbers[idx] + 2) / 3 - 1, num_col = 0;
	        		answer += 'L';
	        		left[0] = num_row;
	        		left[1] = num_col;
	        	}
	        	else if(numbers[idx] == 3 || numbers[idx] == 6 || numbers[idx] == 9) {
	        		int num_row = (numbers[idx]) / 3 - 1, num_col = 2;
	        		answer += 'R';
	        		right[0] = numbers[idx] / 3 - 1;
	        		right[1] = num_col;
	        	}
	        	else {
	        		int r_dis = 0, l_dis = 0, num_row = 0, num_col = 0;
	        		
	        		if(numbers[idx] != 0) {
	        			num_row = (numbers[idx] + 1) / 3 - 1; 
	        			num_col = 1;
	        		}
	        		else {
	        			num_row = 3;
	        			num_col = 1;
	        		}
	        		
	        		r_dis = Math.abs(right[0] - num_row) + Math.abs(num_col - right[1]);
        			l_dis = Math.abs(left[0] - num_row) + Math.abs(num_col - left[1]);
        			
        			if(r_dis < l_dis) {
        				answer += 'R';
        				right[0] = num_row;
        				right[1] = num_col;
        			}
        			else if(l_dis < r_dis) {
        				answer += 'L';
        				left[0] = num_row;
        				left[1] = num_col;
        			}
        			else if(hand.equals("right")) {
        				answer += 'R';
        				right[0] = num_row;
        				right[1] = num_col;
        			}
        			else {
        				answer += 'L';
        				left[0] = num_row;
        				left[1] = num_col;
        			}
	        	}
	        }
	        
	        return answer;
	    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] numbers = {1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5};
		String hand = "right";
		
		solution(numbers, hand);
	}

}
