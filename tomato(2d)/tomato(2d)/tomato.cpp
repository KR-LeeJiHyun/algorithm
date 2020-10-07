#include <iostream>
#include <vector>
#include <queue>

using namespace std;

void bfs(vector<vector<int>> &map, int row, int col) {
	int count = 0;
	int day = 0;
	int s_row, s_col;
	queue<int> node;
	for (int i = 0; i < row; ++i) {
		for (int j = 0; j < col; ++j) {
			if (map[i][j] == 1) {
				node.push(i);
				node.push(j);
				node.push(count);
			}
		}
	}

	while (!node.empty()) {
		s_row = node.front();
		node.pop();
		s_col = node.front();
		node.pop();
		count = node.front();
		node.pop();

		if (-1 < (s_row - 1)) {
			if (map[s_row - 1][s_col] == 0) {
				map[s_row - 1][s_col] = 1;
				node.push(s_row - 1);
				node.push(s_col);
				node.push(count+1);
				if ((count + 1) > day) day = count + 1;
			}
		}

		if ((s_row + 1) < row) {
			if (map[s_row + 1][s_col] == 0) {
				map[s_row + 1][s_col] = 1;
				node.push(s_row + 1);
				node.push(s_col);
				node.push(count + 1);
				if ((count + 1) > day) day = count + 1;
			}
		}

		if (-1 < (s_col - 1)) {
			if (map[s_row][s_col - 1] == 0) {
				map[s_row][s_col - 1] = 1;
				node.push(s_row);
				node.push(s_col - 1);
				node.push(count + 1);
				if ((count + 1) > day) day = count + 1;
			}
		}

		if ((s_col + 1) < col) {
			if (map[s_row][s_col + 1] == 0) {
				map[s_row][s_col + 1] = 1;
				node.push(s_row);
				node.push(s_col + 1);
				node.push(count + 1);
				if ((count + 1) > day) day = count + 1;
			}
		}
	}

	for (int i = 0; i < row; ++i) {
		for (int j = 0; j < col; ++j) {
			if (map[i][j] == 0) {
				cout << -1;
				return;
			}
		}
	}
	cout << day;
}

int main() {
	int N, M, input;
	vector<vector<int>> map;

	cin >> M >> N;
	map.resize(N);
	for (int i = 0; i < N; ++i) {
		map[i].resize(M);
		for (int j = 0; j < M; ++j) {
			cin >> input;
			map[i][j] = input;
		}
	}

	bfs(map, N, M);

	return 0;
}