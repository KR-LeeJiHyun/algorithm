#include <iostream>
#include <string>
#include <algorithm>

using namespace std;

int main() {
	string first, second;
	cin >> first >> second;
	int first_int, second_int;
	reverse(first.begin(), first.end());
	reverse(second.begin(), second.end());
	first_int = stoi(first);
	second_int = stoi(second);

	if (first_int > second_int) cout << first_int;
	else cout << second_int;

	return 0;
}