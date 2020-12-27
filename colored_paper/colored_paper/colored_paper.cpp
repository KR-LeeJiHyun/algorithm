#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

vector<vector<int>> map;
vector<int> cnt_colored(5, 5);
int min_answer = 100;
int N = 10;

bool match(int row, int col, int size) {
	for (int i = 0; i < size; ++i) {
		for (int j = 0; j < size; ++j) {
			if (!map[i + row][j + col]) {
				return false;
			}
		}
	}
	return true;
}

void update_map(int row, int col, int size, int attach_paper) {
	for (int i = 0; i < size; ++i) {
		for (int j = 0; j < size; ++j) {
			map[i + row][j + col] = attach_paper;
		}
	}
}

void sol(int row, int col, int count) {
	bool escape = false;
	for (; row < N; ++row) {
		for (; col < N; ++col) {
			if (map[row][col]) { 
				escape = !escape;
				break;
			}
		}
		if (escape) break;
		col = 0;
	}
	if (row == N || col == N) {
		min_answer = min(min_answer, count);
	}

	if (min_answer == count) return;

	for (int s = 5; s > 0; --s) {
		if (row + s > N || col + s > N || cnt_colored[s-1] == 0)  continue;
		if (match(row, col, s)) {
			update_map(row, col, s, 0);
			--cnt_colored[s - 1];
			sol(row, col, count + 1);
			++cnt_colored[s - 1];
			update_map(row, col, s, 1);
		}
	}
}

int main() {
	map.resize(N);
	for (int i = 0; i < N; ++i) {
		map[i].resize(N);
		for (int j = 0; j < N; ++j) {
			cin >> map[i][j];
		}
	}

	sol(0, 0, 0);

	if (min_answer == 100) cout << -1;
	else cout << min_answer;
	return 0;
}