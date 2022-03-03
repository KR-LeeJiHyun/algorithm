
public class Pro_GoldSilberTrans {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a = 90;
		int b = 500;
		int[] g = {70,70,0};
		int[] s = {0,0,500};
		int[] w = {100,100,2};
		int[] t = {4,8,1};
		
		solution(a, b, g, s, w, t);

	}
	
    public static long solution(int a, int b, int[] g, int[] s, int[] w, int[] t) {
        long answer = 0;
        long time = 400000000000000l;
        
        answer = binearySearch(0, time, a, b, g, s, w, t);
        
        if(!check(answer, a, b, g, s, w, t)) ++answer;
        
        return answer;
    }

	public static long binearySearch(long left, long right ,int a, int b, int[] g, int[] s, int[] w, int[] t) {	
		long mid = (left + right) / 2;
		
		if(left >= right) return right;

		if(check(mid, a, b, g, s, w, t)) return binearySearch(left, mid, a, b, g, s, w, t); 
		else return binearySearch(mid + 1, right, a, b, g, s, w, t);
	}

	public static boolean check(long time, int a, int b, int[] g, int[] s, int[] w, int[] t) {
		long gsWeight = a + b;
		long sum = 0, goldSum = 0, silverSum = 0;
		
		for(int idx = 0; idx < w.length; ++idx) {
			long count = time / (t[idx] * 2);
			if(time % (t[idx] * 2) >= t[idx]) ++count;
			long maxWeight = count*w[idx];
			
			//전체 양 계산
			sum += Math.min(maxWeight, g[idx] + s[idx]);
			//금 양 계산
			goldSum += Math.min(maxWeight, g[idx]);
			//은 양 계산
			silverSum += Math.min(maxWeight, s[idx]);
		}
		
		
		if(sum < gsWeight || goldSum < a || silverSum < b) return false;
		
		return true;
	}

}
