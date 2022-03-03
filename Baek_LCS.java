import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class Baek_LCS {
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String strA = br.readLine();
		String strB = br.readLine();
		int answer = 0;
		int lenA = strA.length(), lenB = strB.length();
		int[][] dp = new int[lenA + 1][lenB + 1];
		
		for(int idxA = 0; idxA < lenA; ++idxA) {
			char tmpA = strA.charAt(idxA);
			for(int idxB = 0; idxB< lenB; ++idxB) {
				char tmpB = strB.charAt(idxB);
				if(tmpA == tmpB) dp[idxA + 1][idxB + 1] = dp[idxA][idxB] + 1;
				else dp[idxA + 1][idxB + 1] = Math.max(dp[idxA][idxB + 1], dp[idxA + 1][idxB]);
			}
		}
		
		answer = dp[lenA][lenB];
		
		bw.write(Integer.toString(answer));
		
		br.close();
        bw.flush();
        bw.close();
	}
}


/*public static void main(String[] args) throws IOException {
// TODO Auto-generated method stub
BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

String strA = br.readLine();
String strB = br.readLine();
int answer = 0;
int lenA = strA.length(), lenB = strB.length();
int[][] dp = new int[lenA][lenB];

for(int idxA = 0; idxA < lenA; ++idxA) {
	char tmpA = strA.charAt(idxA);
	int max = 0;
	for(int idxB = 0; idxB< lenB; ++idxB) {
		for(int sIdxA = 0; sIdxA < idxA; ++sIdxA) {
			if(idxB != 0) max = Math.max(max, dp[sIdxA][idxB - 1]);
		}
		char tmpB = strB.charAt(idxB);
		if(tmpA == tmpB) {
			dp[idxA][idxB] = 1;
			dp[idxA][idxB] = Math.max(dp[idxA][idxB], max + 1);
		}
		answer = Math.max(answer, dp[idxA][idxB]);
	}
}

bw.write(Integer.toString(answer));

br.close();
bw.flush();
bw.close();
}*/