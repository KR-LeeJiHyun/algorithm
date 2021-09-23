#include <iostream>
#include <string>

using namespace std;

int main() {
	string input;
	int answer;

	cin >> input;

	int idx = -1;

	answer = input.length();

	while (!input.empty()) {
		idx = input.find("c=", idx + 1);
		if (idx != string::npos) --answer;
		else break;
	}

	while (!input.empty()) {
		idx = input.find("c-", idx + 1);
		if (idx != string::npos) --answer;
		else break;
	}

	while (!input.empty()) {
		idx = input.find("dz=", idx + 1);
		if (idx != string::npos) answer -= 2;
		else break;
	}

	while (!input.empty()) {
		idx = input.find("d-", idx + 1);
		if (idx != string::npos) --answer;
		else break;
	}

	while (!input.empty()) {
		idx = input.find("lj", idx + 1);
		if (idx != string::npos) --answer;
		else break;
	}

	while (!input.empty()) {
		idx = input.find("nj", idx + 1);
		if (idx != string::npos) --answer;
		else break;
	}

	while (!input.empty()) {
		idx = input.find("s=", idx + 1);
		if (idx != string::npos) --answer;
		else break;
	}

	while (!input.empty()) {
		idx = input.find("z=", idx + 1);
		if (idx != string::npos) {
			if (idx == 0) --answer;
			else if(input[idx - 1] != 'd') --answer; 
		}
		else break;
	}
	cout << answer;

	return 0;
}