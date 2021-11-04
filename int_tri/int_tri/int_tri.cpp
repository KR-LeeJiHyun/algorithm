#include <iostream>
#include <vector>

using namespace std;

vector<vector<int>> dp, tri;
int n = 0;

int max(int a, int b) {
	if (a > b) return a;
	return b;
}

int sol() {
	int answer = 0;
	for (int idx = 0; idx < tri.size() - 1; ++idx) {
		for (int in_idx = 0; in_idx < tri[idx].size(); ++in_idx) {
			dp[idx + 1][in_idx] = max(dp[idx + 1][in_idx], tri[idx + 1][in_idx] + dp[idx][in_idx]);
			dp[idx + 1][in_idx + 1] = max(dp[idx + 1][in_idx + 1], tri[idx + 1][in_idx + 1] + dp[idx][in_idx]);
		}
	}

	for (int idx = 0; idx < dp[n - 1].size(); ++idx) {
		answer = max(answer, dp[n - 1][idx]);
	}

	return answer;
}

int main() {
	cin >> n;
	dp.resize(n);
	tri.resize(n);

	for (int idx = 0; idx < n; ++idx) {
		for (int in_idx = 0; in_idx < idx + 1; ++in_idx) {
			int input = 0;
			cin >> input;
			tri[idx].push_back(input);
			dp[idx].push_back(0);
		}
	}

	dp[0] = tri[0];
	cout << sol();

	return 0;
}