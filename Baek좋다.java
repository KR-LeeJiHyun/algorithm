import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Baek좋다 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int answer = 0;
		HashMap<Integer, Integer> map = new HashMap<>();
		
		for(int idx = 0; idx < N; ++idx) {
			int num = Integer.parseInt(st.nextToken());
			map.put(num, map.getOrDefault(num, 0) + 1);
		}
		
		for(int key : map.keySet()) {
			for(int sKey : map.keySet()) {
				if(key == sKey && map.get(key) == 1) continue;
				
				int tKey = key - sKey;
				if(map.containsKey(tKey)) {
					if(map.get(tKey) > 2) {
						answer += map.get(key);
						break;
					}
					else if(key == tKey && sKey != tKey && map.get(tKey) > 1) {
						answer += map.get(key);
						break;
					}
					else if(key != tKey && sKey == tKey && map.get(tKey) > 1) {
						answer += map.get(key);
						break;
					}
					else if(key != tKey && sKey != tKey) {
						answer += map.get(key);
						break;
					}
				}
			}
		}
		
		/*
		int[] arr = new int[N];
		
		for(int idx = 0; idx < N; ++idx) {
			arr[idx] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		
		for(int idx = 0; idx < N; ++idx) {
			int left = 0;
			int right = N - 1;
			
			while(left < right) {
				int sum = arr[left] + arr[right];
				if(left == idx) {
					++left;
				}
				else if(right == idx) {
					--right;
				}
				else if(arr[idx] < sum) {
					--right;
				}
				else if(arr[idx] > sum) {
					++left;
				}
				else {
					++answer;
					break;
				}
			}
		}
		*/
		/*for(int idx = 0; idx < N; ++idx) {
			for(int sIdx = 0; sIdx < N - 1; ++sIdx) {
				
				if(sIdx == idx) continue;
				
				int left = sIdx + 1;
				int right = N - 1;
				int target = arr[idx] - arr[sIdx];
				boolean possible = false;
				
				while(left <= right) {
					int mid = (left + right) / 2;
					if(target < arr[mid]) {
						right = mid - 1;
					}
					else if(target > arr[mid]) {
						left = mid + 1;
					}
					else {
						if(mid == idx) {
							left = mid + 1;
						}
						else {
							possible = true;
							break;
						}
					}
				}
				
				if(possible) {
					++answer;
					break;
				}
			}
		}*/
		
		bw.write(String.valueOf(answer));
		br.close();
		bw.close();

	}

}
