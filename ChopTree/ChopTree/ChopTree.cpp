#include <iostream>
#include <vector>

using namespace std;

void sol(int N, int M, vector<int> tree) {
	int low = 0, high = 2000000000;

	while (low + 1 < high) {
		int mid = (low + high) / 2;
		long long sum = 0;
		for (int i = 0; i < N; ++i) {
			if (mid <= tree[i]) sum += tree[i] - mid;
		}
		if (sum >= M) low = mid;
		else high = mid;
	}

	cout << low;
}

int main() {
	int N, M, input;
	vector<int> tree;

	cin >> N >> M;
	for (int i = 0; i < N; ++i) {
		cin >> input;
		tree.push_back(input);
	}
	sol(N, M, tree);

	return 0;
}