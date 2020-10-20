#include <iostream>
#include <vector>

using namespace std;

void sol(int N) {
	vector<vector<long long>> dp;
	long long result = 0;

	dp.resize(N + 1);
	for (int i = 0; i <= N; ++i) {
		dp[i].resize(10);
	}

	for (int i = 0; i < 10; ++i) {
		dp[1][i] = 1;
	}

	for (int i = 2; i <= N; ++i) {
		for (int j = 0; j < 10; ++j) {
			for (int k = 0; k <= j; ++k) {
				dp[i][j] += dp[i - 1][k] % 10007;
			}
		}
	}

	for (int i = 0; i < 10; ++i) {
		result += dp[N][i];
	}

	cout << result % 10007;
}

int main() {
	int N;
	cin >> N;
	sol(N);
	return 0;
}