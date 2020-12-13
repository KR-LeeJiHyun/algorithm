#include <iostream>
#include <vector>
#include <string>
#include <queue>

using namespace std;

void sol(int N, int K, vector<int> friends) {
	long long answer = 0;
	vector<queue<int>> good;
	good.resize(21);
	for (int i = 0; i < N; ++i) {
		int index = friends[i];
		if (good[index].empty()) {
			good[index].push(i);
		}
		else {
			while (true) {
				if (good[index].empty() || good[index].front() >= i - K) {
					answer += good[index].size();
					good[index].push(i);
					break;
				}
				else good[index].pop();
			}
		}
	}
	cout << answer;
}

int main() {
	int N, K;
	vector<int> friends;
	string input;

	cin >> N >> K;
	for (int i = 0; i < N; ++i) {
		cin >> input;
		friends.push_back(input.length());
	}
	sol(N, K, friends);
	return 0;
}