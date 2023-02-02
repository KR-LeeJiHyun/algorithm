
public class Pro_EmoticonSale {

	public static void main(String[] args) {
		Pro_EmoticonSale PES = new Pro_EmoticonSale();
		int[][] users = {{40, 10000}, {25, 10000}};
		int[] emoticons = {7000, 9000};
		PES.solution(users, emoticons);
	}
	
    public int[] solution(int[][] users, int[] emoticons) {
        int[] answer;
        int[] profit = new int[users.length];
        answer = dfs(users, emoticons, profit, 0, emoticons.length);
        return answer;
    }

	private int[] dfs(int[][] users, int[] emoticons, int[] profit, int i, int length) {
		int[] result = new int[2];
		if(i == length) {
			for(int idx = 0; idx < users.length; ++idx) {
				if(profit[idx] >= users[idx][1]) {
					++result[0];
				}
				else {
					result[1] += profit[idx];
				}
			}
		}
		else {
			int[] tmpR;
			int[] tmpP;
			for(int idx = 1; idx <= 4; ++idx) {
				tmpP = profit.clone();
				int price = emoticons[i] - (emoticons[i] / 10 * idx);
				for(int uIdx = 0; uIdx < users.length; ++uIdx) {
					if(users[uIdx][0] <= idx * 10) {
						tmpP[uIdx] += price;
					}
				}
				tmpR = dfs(users, emoticons, tmpP, i + 1, length);
				if(tmpR[0] > result[0]) {
					result = tmpR.clone();
				}
				else if(tmpR[0] == result[0] && tmpR[1] > result[1]) {
					result = tmpR.clone();
				}
			}
		}
		
		return result;
	}
    
}
