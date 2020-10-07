#include <iostream>
#include <string>

using namespace std;

int main() {
	int answer = 666;
	int N;
	int count = 0;
	cin >> N;

	for (int i = 1; i < N; ++i) {
		++answer;
		string temp = to_string(answer);
		if (temp.find("666") == string::npos) { 
			--i;
		}
	}

	cout << answer;
	return 0;
}