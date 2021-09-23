#include <iostream>
#include <string>
#include <vector>

using namespace std;

const int CHAR_SIZE = 26;

int main() {
	string input;
	vector<int> alphabet(CHAR_SIZE, -1);

	cin >> input;

	for (int idx = 0; idx < CHAR_SIZE; ++idx) {
		char search = 'a' + idx;
		int alphabet_idx = input.find(search);
		if (alphabet_idx != string::npos) alphabet[idx] = alphabet_idx;
	}

	for (int idx = 0; idx < CHAR_SIZE; ++idx) cout << alphabet[idx] << " ";

	return 0;
}