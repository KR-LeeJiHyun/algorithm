#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

void sol(int N, int K, int D, vector<int> box) {
	int low = 1, high = N;

	while (low + 1 < high) {
		int mid = (low + high)/2;
		long long cnt = 0;
		for (int i = 0; i < K; ++i) {
			if(mid >= box[i*3]) cnt += min(((box[(i * 3) + 1] - box[i*3])/ box[(i * 3) + 2]) + 1, ((mid - box[i * 3]) / box[(i * 3) + 2]) + 1);
		}

		if (cnt >= D) {
			high = mid;
		}
		else low = mid;
	}
	cout << high;
}

int main() {
	int N, K, D, input;
	vector<int> box;

	cin >> N >> K >> D;

	for (int i = 0; i < K; ++i) {
		cin >> input;
		box.push_back(input);
		cin >> input;
		box.push_back(input);
		cin >> input;
		box.push_back(input);
	}

	sol(N, K, D, box);
}