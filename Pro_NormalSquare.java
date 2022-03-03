
public class Pro_NormalSquare {
	
	public int gcd(int a, int b) {
		int tmp, n;
		 
		if(a<b){
			tmp = a;
			a = b;
			b = tmp;
		}

		while(b!=0){
			n = a%b;
			a = b;
			b = n;
		}
		return a;
	}

	 public long solution(int w, int h) {
	        long answer = ((long)w * (long)h) - (w+h-gcd(w,h));
	        return answer;
	 } 
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
