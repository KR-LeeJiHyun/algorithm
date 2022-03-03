import java.util.Arrays;

public class Pro_PhoneBook {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        Arrays.sort(phone_book);
        int len = phone_book.length;
        for(int idx = 0; idx < len - 1; ++idx) {
        	if(phone_book[idx + 1].indexOf(phone_book[idx]) == 0) return false;
        }
        
        return answer;
    }

}
