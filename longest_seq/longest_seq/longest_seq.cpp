#include <iostream>
#include <vector>

using namespace std;

vector<int> dp, seq;
int n = 0;

int sol() {
	int answer = 1;

	for (int idx = 1; idx < n; ++idx) {
		int count = 0;
		for (int pre = 0; pre < idx; ++pre) {
			if (seq[pre] < seq[idx]) {
				if (count < dp[pre]) count = dp[pre];
			}
		}
		dp[idx] = count + 1;
		if (answer < dp[idx]) answer = dp[idx];
	}

	return answer;
}

int main() {
	cin >> n;
	dp.resize(n, 1);

	for (int idx = 0; idx < n; ++idx) {
		int input = 0;
		cin >> input;
		seq.push_back(input);
	}

	cout << sol();

	return 0;
}