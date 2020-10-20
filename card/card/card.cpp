#include <iostream>
#include <vector>

using namespace std;

void sol(int N, vector<int> cards) {
	vector<int> dp(N + 1, 0);
	for (int i = 1; i < N + 1; ++i) {
		for (int j = 0; j < i; ++j) {
			if (dp[i] < dp[i - j - 1] + cards[j]) dp[i] = dp[i - j - 1] + cards[j];
		}
	}
	cout << dp[N];
}

int main() {
	int N, input;
	vector<int> cards;

	cin >> N;
	for (int i = 0; i < N; ++i) {
		cin >> input;
		cards.push_back(input);
	}

	sol(N, cards);

	return 0;
}