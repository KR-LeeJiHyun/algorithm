#include <iostream>
#include <string>

using namespace std;

int main() {
	string input = "";
	getline(cin, input);

	int count = 0;
	bool space = true;
	for (int idx = 0; idx < input.length(); ++idx) {
		if(space && input[idx] != ' ') {
			++count;
			space = false;
		}
		else if(input[idx] == ' ') {
			space = true;
		}
	}

	cout << count;

	return 0;
}

