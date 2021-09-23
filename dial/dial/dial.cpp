#include <iostream>
#include <string>

using namespace std;

int main() {
	string input;
	cin >> input;

	int answer = 0;
	for (int idx = 0; idx < input.length(); ++idx) {
		if (input[idx] < 'D') answer += 3;
		else if (input[idx] < 'G') answer += 4;
		else if (input[idx] < 'J') answer += 5;
		else if (input[idx] < 'M') answer += 6;
		else if (input[idx] < 'P') answer += 7;
		else if (input[idx] < 'T') answer += 8;
		else if (input[idx] < 'W') answer += 9;
		else answer += 10;
	}

	cout << answer;
	return 0;
}