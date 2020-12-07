#include <string>
#include <cmath>
#include <iostream>

using namespace std;

int solution(string dartResult) {
	int answer = 0, prev_score = 0, current_score = 0;
	while (!dartResult.empty()) {
		string temp = "";
		while (true) {
			temp += dartResult[0];
			dartResult.erase(0, 1);
			if (dartResult[0] == 'S' || dartResult[0] == 'D' || dartResult[0] == 'T') break;
		}
		if (dartResult[0] == 'S') current_score = stoi(temp);
		else if(dartResult[0] == 'D') current_score = pow(stoi(temp), 2);
		else current_score = pow(stoi(temp), 3);

		dartResult.erase(0, 1);

		if (dartResult[0] == '*') {
			answer -= prev_score;
			current_score = current_score * 2;
			prev_score = prev_score * 2;
			answer += (current_score + prev_score);
			dartResult.erase(0, 1);
			prev_score = current_score;
		}

		else if (dartResult[0] == '#') {
			answer -= current_score;
			dartResult.erase(0, 1);
			prev_score = -1 * current_score;
		}

		else {
			answer += current_score;
			prev_score = current_score;
		}
	}
	return answer;
}

void main() {
	string dartResult = "1D2S3T*";
	cout << solution(dartResult);
}