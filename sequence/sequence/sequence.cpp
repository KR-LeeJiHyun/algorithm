#include <iostream>
#include <vector>

using namespace std;

void sol(vector<int> seq) {
	vector<int> dp = seq;
	int max = 0;
	for (int i = 0; i < seq.size(); ++i) {
		for (int j = 0; j < i; ++j) {
			if (seq[j] < seq[i] && dp[i] < dp[j] + seq[i]) dp[i] = dp[j] + seq[i];
		}
		if (dp[i] > max) max = dp[i];
	}
	cout << max;
}

int main() {
	int N, input;
	vector<int> sequence;

	cin >> N;
	sequence.resize(N);

	for (int i = 0; i < N; ++i) {
		cin >> input;
		sequence.push_back(input);
	}

	sol(sequence);

	return 0;
}