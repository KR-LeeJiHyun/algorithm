#include <iostream>
#include <vector>
#include <string>

using namespace std;

int main() {
	const int MAX_COUNT = 26;
	int answer = 0, N;
	string input;

	cin >> N;

	for (int idx = 0; idx < N; ++idx) {
		cin >> input;
		vector<bool> check(MAX_COUNT, false);

		for (int input_idx = 0; input_idx < input.length(); ++input_idx) {
			if (check[input[input_idx] - 'a'] && input[input_idx] != input[input_idx - 1]) {
				--answer;
				break;
			}
			else check[input[input_idx] - 'a'] = true;
		}

		++answer;
	}

	cout << answer;

	return 0;
}