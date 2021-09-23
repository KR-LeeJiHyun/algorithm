#include <iostream>
#include <string>
#include <vector>

using namespace std;

int main() {
	string word = "";
	vector<int> alphabet_count(26);
	int max = 0;
	char answer;
	char start_idx = 'A';

	cin >> word;

	for (int idx = 0; idx < word.length(); ++idx) {
		word[idx] = toupper(word[idx]);
		++alphabet_count[word[idx] - start_idx];
		if (max == alphabet_count[word[idx] - start_idx]) answer = '?';
		else if (max < alphabet_count[word[idx] - start_idx]) {
			max = alphabet_count[word[idx] - start_idx];
			answer = word[idx];
		}
	}

	cout << answer;

	return 0;
}