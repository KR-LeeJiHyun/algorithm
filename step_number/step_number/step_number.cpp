#include <iostream>
#include <vector>

using namespace std;

void sol(int N) {
	vector<vector<long long>> step;
	long long result = 0;
	
	step.resize(N + 1);
	for (int i = 0; i <= N; ++i) {
		step[i].resize(10);
	}
	
	step[1][0] = 0;
	for (int i = 1; i < 10; ++i) {
		step[1][i] = 1;
	}

	for (int i = 2; i <= N; ++i) {
		for (int j = 0; j < 10; ++j) {
			if (0 < j && j < 9) step[i][j] = step[i - 1][j - 1] + step[i - 1][j + 1] % 1000000000;
			else if (j == 0) step[i][j] = step[i - 1][j + 1] % 1000000000;
			else step[i][j] = step[i - 1][j - 1] % 1000000000;
		}
	}

	for (int i = 0; i < 10; ++i) {
		result += step[N][i];
	}

	cout << result % 1000000000;
}

int main() {
	int N;
	cin >> N;
	sol(N);
	return 0;
}