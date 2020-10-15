#include <iostream>
#include <string>
#include <vector>

using namespace std;

void sol(string sentence, vector<string> word) {
	vector<bool> dp(sentence.length() + 1, false);
	dp[sentence.length()] = true;

	for (int i = sentence.length() - 1; i >= 0; --i) {
		for (int j = 0; j < word.size(); ++j) {
			if (sentence.find(word[j], i) == i && dp[i + word[j].length()] == true) {
				dp[i] = true;
			}
		}
	}

	if(dp[0]) cout << 1;
	else cout << 0;
}

int main() {
	int N;
	string sentence,input;
	vector<string> word;

	cin >> sentence >> N;
	for (int i = 0; i < N; ++i) {
		cin >> input;
		word.push_back(input);
	}

	sol(sentence, word);
	return 0;
}
