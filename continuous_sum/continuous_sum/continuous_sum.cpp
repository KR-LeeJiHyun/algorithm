#include <iostream>
#include <vector>

using namespace std;

int n;
vector<int> dp;

int main() {
	cin >> n;
	int max = -1000;

	for (int idx = 0; idx < n; ++idx) {
		int input = 0;
		cin >> input;
		if (idx != 0) {
			if (dp[idx - 1] + input > input) dp.push_back(dp[idx - 1] + input);
			else dp.push_back(input);
		}
		else dp.push_back(input);

		if (max < dp[idx]) max = dp[idx];
	}

	cout << max;
}