#include <iostream>
#include <vector>

using namespace std;

vector<vector<int>> alphabet(26);
string f_word, s_word;

int LCS(int c_idx) {
	int pos = s_word[c_idx] - 'A';

	for (int idx = 0; idx < alphabet[pos].size(); ++idx) {

	}
}

int sol() {
	int answer = 0;

	for (int idx = 0; idx < s_word.size(); ++idx) {
		if (alphabet[s_word[idx] - 'A'].empty()) {
			int pos = f_word.find(s_word[idx]);
			while (pos != string::npos) {
				alphabet[s_word[idx] - 'A'].push_back(pos);
				pos = f_word.find(s_word[idx],pos + 1);
			}
		}
	}

	answer = LCS(0);
	return answer;
}

int main() {
	cin >> f_word >> s_word;

	cout << sol();
	return 0;
}