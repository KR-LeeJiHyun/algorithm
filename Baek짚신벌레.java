import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baek짚신벌레 {
	
	static class Bug {
		int day;
		int cnt;
		
		Bug(int day, int cnt) {
			this.day = day;
			this.cnt = cnt;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		final int UNIT = 1000;
		
		int[] bug = new int[N + 1];
		bug[0] = 1;
		int birth = 0;
		Queue<Bug> plusQ = new LinkedList<>();
		Queue<Bug> minusQ = new LinkedList<>();
		Queue<Bug> deathQ = new LinkedList<>();
		
		plusQ.add(new Bug(a, 1));
		minusQ.add(new Bug(b, 1));
		deathQ.add(new Bug(d, 1));
		
		for(int day = 1; day <= N; ++day) {
			bug[day] = bug[day - 1];
			if(!plusQ.isEmpty() && plusQ.peek().day == day) {
				Bug cBug = plusQ.poll();
				birth += cBug.cnt;
			}
			birth += UNIT;
			if(!minusQ.isEmpty() && minusQ.peek().day == day) {
				Bug cBug = minusQ.poll();
				birth -= cBug.cnt;
			}
			bug[day] += birth;
			bug[day] %= UNIT;
			if(!deathQ.isEmpty() && deathQ.peek().day <= N) {
				bug[day] = (bug[day] + UNIT - deathQ.poll().cnt) % UNIT;
			}
			
			plusQ.add(new Bug(day + a, birth % UNIT));
			minusQ.add(new Bug(day + b, birth % UNIT));
			deathQ.add(new Bug(day + d, birth % UNIT));
		}
		
		bw.write(String.valueOf(bug[N]));
		br.close();
		bw.close();
	}
	/*
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		final int UNIT = 1000;
		
		int[] bug = new int[N + 1];
		
		for(int day = 0; day < a; ++day) {
			bug[day] = 1;
		}
		 
		for(int day = a; day <= N; ++day) {
			bug[day] = (bug[day - 1] + bug[day - a]) % UNIT;
			if(b <= day) {
				bug[day] = (bug[day] + UNIT - bug[day - b]) % UNIT;
			}
		}
		int answer = 0;
		if(N - d >= 0) {
			answer = (bug[N] + UNIT - bug[N - d]) % UNIT;
		}
		else {
			answer = bug[N];
		}
		bw.write(String.valueOf(answer));
		br.close();
		bw.close();
	}
	*/

}
