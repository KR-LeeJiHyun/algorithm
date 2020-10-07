#include <iostream>
#include <vector>
#include <queue>

using namespace std;

int sol(vector<int> product, int N, int K) {
	vector<int> multitap(N);
	vector<queue<int>> seq;
	int result = 0;
	seq.resize(K+1);

	for (int i = 0; i < K; ++i) {
		seq[product[i]].push(i);
	}
	
	for (int i = 0; i < K + 1; ++i) {
		seq[i].push(1000);
	}

	for (int i = 0; i < K; ++i) {
		seq[product[i]].pop();
		bool change = true;
		int pos = -1;

		for (int j = 0; j < N; ++j) {
			if (multitap[j] == 0 || multitap[j] == product[i]) {
				multitap[j] = product[i];
				change = false;
				break;
			}
			else {
				if (pos == -1 || seq[multitap[pos]].front() < seq[multitap[j]].front()) {
					pos = j;
				}
			}
		}

		if (change) {
			multitap[pos] = product[i];
			++result;
		}
	}

	return result;
}

int main() {
	int input, N, K;
	vector<int> product;

	cin >> N >> K;

	for (int i = 0; i < K; ++i) {
		cin >> input;
		product.push_back(input);
	}

	cout << sol(product, N, K);

	return 0;
}