
public class Pro_AnticipatedMatch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		solution(8, 4, 7);

	}
	
    public static int solution(int n, int a, int b)
    {
        int answer = 0;
        
        while(true) {
        	++answer;
        	int bCount = b/2;
        	if(b % 2 != 0) ++bCount;
        	int aCount = a/2;
        	if(a % 2 != 0) ++aCount;
        	if(aCount == bCount) break;
        	b = bCount;
        	a = aCount;
        }

        return answer;
    }

}
