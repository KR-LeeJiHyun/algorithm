public class Pro_LCM {
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public int solution(int[] arr) {
        for(int idx = arr.length - 1; idx > 0; --idx) {
        	int gcd = gcd(arr[idx], arr[idx - 1]);
        	arr[idx - 1] = arr[idx] * arr[idx - 1] / gcd; 
        }
        return arr[0];
    }

	private int gcd(int i, int j) {
		int mod = i % j;
		if(mod == 0) return j;
		else return gcd(j, mod);
	}
}
