#include <string>
#include <vector>
#include <algorithm>
#include <iostream>

using namespace std;

vector<string> solution(int n, vector<int> arr1, vector<int> arr2) {
	vector<string> answer;
	for (int i = 0; i < n; ++i) {
		string output = "", output2 = "";
		int input = arr1[i] | arr2[i];
		while(input > 1){
			output += to_string(input % 2);
			input = input / 2;
		}
		output += "1";
		if (output.size() < n) {
			while (output.size() < n) output += "0";
		}
		reverse(output.begin(), output.end());
		for (int j = 0; j < n; ++j) {
			if (output[j] == '1') output2 += "#";
			else output2 += " ";
		}

		while (output2.find("  ") != string::npos) {
			int idx = output2.find("  ");
			output2.replace(idx, 2, " ");
		}
		answer.push_back(output2);
	}
	return answer;
}

void main() {
	int n = 6;
	vector<int> arr1 = { 46, 33, 33 ,22, 31, 50 };
	vector<int> arr2 = { 27 ,56, 19, 14, 14, 10 };
	vector<string> answer = solution(n, arr1, arr2);

	for (int i = 0; i < answer.size(); ++i) {
		cout << answer[i] << "+" << endl;
	}
}