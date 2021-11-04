#include <iostream>
#include <vector>

using namespace std;

vector<vector<int>> dp;

int min(int a, int b) {
	if (a < b) return a;
	return b;
}

int sol(int n) {
	for (int idx = 1; idx < n; ++idx) {
		dp[idx][0] = min(dp[idx - 1][1] + dp[idx][0], dp[idx - 1][2] + dp[idx][0]);
		dp[idx][1] = min(dp[idx - 1][0] + dp[idx][1], dp[idx - 1][2] + dp[idx][1]);
		dp[idx][2] = min(dp[idx - 1][0] + dp[idx][2], dp[idx - 1][1] + dp[idx][2]);
	}
	int answer = min(dp[n - 1][0], min(dp[n - 1][1], dp[n - 1][2]));
	return answer;
}

int main() {
	int n = 0;
	cin >> n;
	dp.resize(n);
	for (int idx = 0; idx < n; ++idx) {
		int r, g, b;
		cin >> r >> g >> b;
		dp[idx].push_back(r);
		dp[idx].push_back(g);
		dp[idx].push_back(b);
	}

	cout << sol(n);
}