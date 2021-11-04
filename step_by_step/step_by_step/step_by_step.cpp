#include <iostream>
#include <vector>

using namespace std;

vector<int> dp, step;
int n = 0;

int max(int a, int b) {
	if (a > b) return a;
	return b;
}

int sol() {
	for (int idx = 3; idx < step.size(); ++idx) {
		dp[idx] = step[idx] + max(step[idx - 1] + dp[idx - 3], dp[idx - 2]);
	}

	return dp[n];
}

int main() {
	cin >> n;

	dp.resize(n + 1);
	step.push_back(0);
	for (int idx = 0; idx < n; ++idx) {
		int input = 0;
		cin >> input;
		step.push_back(input);

	}
	dp[1] = step[1];
	dp[2] = step[1] + step[2];
	cout << sol();

	return 0;
}