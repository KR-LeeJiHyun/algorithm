#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int n;
const int WIRE_LEN = 501;
vector<int> a_wire, wire(WIRE_LEN, 0), dp;

int sol() {
	sort(a_wire.begin(), a_wire.end());

	int answer = 0;
	for (int idx = 1; idx < n; ++idx) {
		for (int in_idx = 0; in_idx < idx; ++in_idx) {
			if (wire[a_wire[idx]] > wire[a_wire[in_idx]]) {
				if (dp[idx] < dp[in_idx] + 1) dp[idx] = dp[in_idx] + 1;
			}
		}
		if (dp[idx] > answer) answer = dp[idx];
	}

	return n - answer;
}

int main() {
	cin >> n;

	dp.resize(n, 1);

	for (int idx = 0; idx < n; ++idx) {
		int a_input, b_input;
		cin >> a_input >> b_input;
		a_wire.push_back(a_input);
		wire[a_input] = b_input;
	}

	cout << sol();

	return 0;
}