
public class Pro_ExpressionOfNumber {

	public static void main(String[] args) {

	}
	
    public int solution(int n) {
        int answer = 0;
        
        //정수론 어떤 자연수의 연속합으로 나타나는 경우의 수 = 어떤 자연수의 홀수인 약수의 갯수
        for(int idx = 1; idx <= n; idx += 2) {
        	if(n % idx == 0) ++answer;
        }
        
        /*for(int idx = 1; idx <= n; ++idx) {
        	int sum = 0;
        	for(int sIdx = idx; sIdx <= n; ++sIdx) {
        		sum += sIdx;
        		if(sum == n) {
        			++answer;
        			break;
        		}
        		else if(sum > n) break;
        	}
        }*/
        
        return answer;
    }

}
