#include <iostream>
#include <vector>

using namespace std;

void sol(vector<long long> pinary, int N) {
	if (N > 2) {
		for (int i = 2; i < N; ++i) {
			pinary[i] = pinary[i - 1] + pinary[i - 2];
		}
		cout << pinary[N - 1];
		return;
	}
	cout << 1;
};

int main() {
	long long N;
	cin >> N;
	vector<long long> pinary(N,1);
	sol(pinary, N);
	return 0;
}