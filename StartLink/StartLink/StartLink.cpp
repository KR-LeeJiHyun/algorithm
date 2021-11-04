#include <iostream>
#include <vector>
#include <cstdlib>

using namespace std;

vector<vector<int>> chemi;
vector<bool> visit;
int N = 0, answer = 10000;

int balance(int count, int member) {
	if (count == N / 2) {
		int start = 0, link = 0;
		for (int row = 0; row < N - 1; ++row) {
			for (int col = row + 1; col < N; ++col) {
				if (visit[row] && visit[col]) {
					start += chemi[row][col] + chemi[col][row];
				}
				else if (!visit[row] && !visit[col]) {
					link += chemi[row][col] + chemi[col][row];
				}
			}
		}
		return abs(start - link);
	}

	for (int idx = member; idx < N; ++idx) {
		if (!visit[idx]) {
			visit[idx] = true;
			answer = min(balance(count + 1, idx + 1), answer);
			visit[idx] = false;
		}
	}

	return answer;
}

int main() {
	cin >> N;
	chemi.resize(N);
	visit.resize(N);

	for (int row = 0; row < N; ++row) {
		chemi[row].resize(N);
		for (int col = 0; col < N; ++col) {
			int input = 0;
			cin >> input;
			chemi[row][col] = input;
		}
	}

	cout << balance(0, 0);

	return 0;
	return 0;
}

/*int balance(vector<int> start_team, vector<int> link_team, vector<bool> visit) {
	int answer = 10000;
	if (start_team.size() == link_team.size()) {
		int start = 0, link = 0;
		for (int idx = 0; idx < start_team.size() - 1; ++idx) {
			for (int s_idx = idx + 1; s_idx < start_team.size(); ++s_idx) {
				start += chemi[start_team[idx]][start_team[s_idx]] + chemi[start_team[s_idx]][start_team[idx]];
				link += chemi[link_team[idx]][link_team[s_idx]] + chemi[link_team[s_idx]][link_team[idx]];
			}
		}
		if (start > link) return start - link;
		else return link - start;
	}

	for (int row = 0; row < N; ++row) {
		if (!visit[row]) {
			visit[row] = true;
			start_team.push_back(row);
			auto it = find(link_team.begin(), link_team.end(), row);
			link_team.erase(it);

			answer = min(answer, balance(start_team, link_team, visit));
			start_team.pop_back();
			link_team.push_back(row);
		}
	}

	return answer;
}

int main() {
	cin >> N;
	chemi.resize(N);
	vector<int> start_team, link_team;

	for (int row = 0; row < N; ++row) {
		link_team.push_back(row);
		chemi[row].resize(N);
		for (int col = 0; col < N; ++col) {
			int input = 0;
			cin >> input;
			chemi[row][col] = input;
		}
	}

	vector<bool> visit(N);

	cout << balance(start_team, link_team,visit);

	return 0;
}*/