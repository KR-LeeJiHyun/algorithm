#include <vector>
#include<iostream>

using namespace std;

void sol(int N, vector<int> histogram, int min, int max) {
	int answer = 0;
	for (int i = 0; i < N; ++i) {
		int base = 1;
		int current = histogram[i];

		if (current == min) {
			if (answer < N*current) answer = current*N;
		}

		else if (current == max) {
			if (answer < current) answer = current;
		}

		else {
			for (int j = i - 1; j > -1; --j) {
				if (current <= histogram[j]) ++base;
				else break;
			}

			for (int j = i + 1; j < N; ++j) {
				if (current <= histogram[j]) ++base;
				else break;
			}
			if (answer < base*current) answer = current*base;
		}
	}
	cout << answer;
}

int main() {
	int N, input;
	vector<int> histogram;
	int min = 1000000000, max = 0;
	cin >> N;
	for (int i = 0; i < N; ++i) {
		cin >> input;
		histogram.push_back(input);
		if (input < min) min = input;
		if (input > max) max = input;
	}
	sol(N, histogram, min, max);
	return 0;
}