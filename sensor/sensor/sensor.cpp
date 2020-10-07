#include <iostream>
#include <vector>
#include <algorithm>
#include <functional>

using namespace std;

int sol(int N, int K, vector<int> sensor) {
	int result = sensor[N-1] - sensor[0];
	vector<int> diff;
	
	for (int i = 1; i < N; ++i) {
		diff.push_back(sensor[i] - sensor[i - 1]);
	}

	sort(diff.begin(), diff.end());

	for (int i = 0; i < K - 1; ++i) {
		if (result < 1) return result;
		result -= diff.back();
		diff.pop_back();
	}

	return result;
}

int main() {
	int N, K, input;
	vector<int> sensor;

	cin >> N >> K;

	for (int i = 0; i < N; ++i) {
		cin >> input;
		sensor.push_back(input);
	}

	sort(sensor.begin(), sensor.end());

	cout << sol(N, K, sensor);

	return 0;
}