import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Baek_BridgeLeap {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String spell = br.readLine(), angel = br.readLine(), devil = br.readLine();
		
		int spellLen = spell.length(), bridgeLen = angel.length();
		int[][][] dp = new int[spellLen][bridgeLen][2];
		
		for(int spellIdx = 0; spellIdx < spellLen; ++spellIdx) {
			for(int bridgeIdx = 0; bridgeIdx < bridgeLen; ++bridgeIdx) {
				char spellChar = spell.charAt(spellIdx);
				if(spellIdx != 0) {
					if(bridgeIdx != 0) {
						dp[spellIdx][bridgeIdx][0] = dp[spellIdx][bridgeIdx - 1][0];
						if(spellChar == angel.charAt(bridgeIdx)) dp[spellIdx][bridgeIdx][0] += dp[spellIdx - 1][bridgeIdx - 1][1];
						dp[spellIdx][bridgeIdx][1] = dp[spellIdx][bridgeIdx - 1][1];
						if(spellChar == devil.charAt(bridgeIdx)) dp[spellIdx][bridgeIdx][1] += dp[spellIdx - 1][bridgeIdx - 1][0];
					}
				}
				else {
					if(bridgeIdx != 0) {
						dp[spellIdx][bridgeIdx][0] = dp[spellIdx][bridgeIdx - 1][0];
						dp[spellIdx][bridgeIdx][1] = dp[spellIdx][bridgeIdx - 1][1];
					}
					if(spellChar == angel.charAt(bridgeIdx)) dp[spellIdx][bridgeIdx][0] += 1;
					if(spellChar == devil.charAt(bridgeIdx)) dp[spellIdx][bridgeIdx][1] += 1;
				}
			}
		}
		
		bw.write(dp[spellLen - 1][bridgeLen - 1][0] + dp[spellLen - 1][bridgeLen - 1][1] + "\n");
		br.close();
		bw.flush();
		bw.close();

	}

}
