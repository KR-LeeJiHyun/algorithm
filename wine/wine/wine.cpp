#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int main() {
	int n;
	vector<int> wine;
	vector<int> dp;

	cin >> n;
	wine.resize(n, 0);
	dp.resize(n, 0);

	for (int Index = 0; Index < n; ++Index) {
		cin >> wine[Index];
	}

	for (int Index = 0; Index < n; ++Index) {
		if (Index > 1) {
			dp[Index] = max(max(wine[Index] + wine[Index - 1] + dp[Index - 3], dp[Index -1]), wine[Index] + dp[Index - 2]);
		}
		else if (Index == 1) {
			dp[Index] = wine[Index] + dp[Index - 1];
		}
		else {
			dp[Index] = wine[Index];
		}
	}

	cout << dp[n - 1];
	return 0;
}