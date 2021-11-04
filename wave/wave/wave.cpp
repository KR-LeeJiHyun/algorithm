#include <iostream>

using namespace std;

long long dp[101] = { 0, 1, 1, 1, 2, 2, 0, };

long long P(int n) {
	if (n == 0) return 0;
	else if (dp[n] != 0) return dp[n];
	else dp[n] = P(n - 1) + P(n - 5);

	return dp[n];
}

int main() {
	int n = 0, count = 0;

	cin >> count;

	for (int idx = 0; idx < count; ++idx) {
		cin >> n;
		cout << P(n) << endl;
	}
	return 0;
}