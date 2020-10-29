#include <iostream>
#include <algorithm>

using namespace std;

void sol(int N, int K) {
	int low = 0, high = 1000000000, answer = 0;
	while (low + 1< high) {
		int mid = (low + high) / 2;
		long long cnt = 0;
		for (int i = 0; i < N; i++) {
			cnt += min(N, mid / (i + 1));
		}
		if (cnt >= K) { 
			high = mid;
			answer = mid;
		}
		else low = mid;
	}
	cout << answer;
}

int main() {
	int N, K;

	cin >> N >> K;

	sol(N, K);
	return 0;
}