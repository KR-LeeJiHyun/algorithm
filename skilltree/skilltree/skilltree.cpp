#include <string>
#include <vector>
#include <iostream>

using namespace std;

int solution(string skill, vector<string> skill_trees) {
	int answer = 0;

	for (int i = 0; i < skill_trees.size(); ++i) {
		bool possible = true;
		for (int j = 0; j < skill.length() - 1; ++j) {
			int prev_idx = skill_trees[i].find(skill[j]);
			int next_idx = skill_trees[i].find(skill[j + 1]);
			if ((prev_idx == string::npos || prev_idx > next_idx) && next_idx != string::npos) {
				possible = false;
				break;
			}
		}
		if (possible) ++answer;
	}
	return answer;
}

void main() {
	string skill = "CBD";
	vector<string> skill_trees = { "BACDE", "CBADF", "AECB", "BDA", "AEFGH" };

	cout << solution(skill, skill_trees);
}