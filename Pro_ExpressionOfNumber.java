
public class Pro_ExpressionOfNumber {

	public static void main(String[] args) {

	}
	
    public int solution(int n) {
        int answer = 0;
        
        //������ � �ڿ����� ���������� ��Ÿ���� ����� �� = � �ڿ����� Ȧ���� ����� ����
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
