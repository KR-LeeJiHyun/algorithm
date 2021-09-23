#include <vector>
#include<iostream>
#include<stack>


using namespace std;

long long N;
vector<long long> histogram;

void sol() {
	long long answer = 0, height = 0, base = 0;
	stack<long long> stacks;
	stacks.push(0);
	for (long long idx = 1; idx <= N + 1; ++idx) {
		while (histogram[stacks.top()] > histogram[idx]) {
			long long check = stacks.top();
			stacks.pop();
			long long area = histogram[check] * (idx - stacks.top() - 1);
			//cout << area << ", ";
			answer = max(answer, area);
		}
		stacks.push(idx);
	}
	answer = max(answer, height * N);
	cout << "\n" << answer << "\n";
}

int main() {
	while (true) {
		cin >> N;
		if (N == 0) break;
		long long input;
		histogram.push_back(0);
		for (long long idx = 0; idx < N; ++idx) {
			cin >> input;
			histogram.push_back(input);
		}
		histogram.push_back(0);
		sol();
		histogram.clear();
		N = 0;
	}
	return 0;
}