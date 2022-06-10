import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Baek_StoneGame2 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		final String[] players = {"SK", "CY"};
		int N = Integer.parseInt(br.readLine());
		
		bw.write(players[N & 1] + "\n");
		br.close();
		bw.flush();
		bw.close();
	}

}