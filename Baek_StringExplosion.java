import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Baek_StringExplosion {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		char[] s = br.readLine().toCharArray();
		char[] e = br.readLine().toCharArray();
		int sLen = s.length;
		int eLen = e.length - 1;
		char[] stack = new char[sLen];
		
		int stIdx = 0;
		for(int sIdx = 0; sIdx < sLen; ++sIdx) {
			stack[stIdx] = s[sIdx];
			if(stack[stIdx] == e[eLen] && stIdx >= eLen) {
				int eIdx = eLen;
				int current = stIdx;
				while(eIdx > -1 && stack[current] == e[eIdx]) {
					--current;
					--eIdx;
				}
				if(eIdx == -1) stIdx = current;
			}
			++stIdx;
		}
		
		if(stIdx == 0) bw.write("FRULA");
		else {
			char[] answer = Arrays.copyOfRange(stack, 0, stIdx);
			bw.write(answer);
		}
	
		br.close();
		bw.close();
		
	}

}
