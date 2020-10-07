#include <iostream>
#include <vector>
#include <queue>

using namespace std;

void bfs(vector<vector<vector<int>>> &map, int row, int col, int hei) {
	int count = 0;
	int day = 0;
	int s_row, s_col, s_hei;
	queue<int> node;
	for (int x = 0; x < hei; ++x) {
		for (int i = 0; i < row; ++i) {
			for (int j = 0; j < col; ++j) {
				if (map[x][i][j] == 1) {
					node.push(x);
					node.push(i);
					node.push(j);
					node.push(count);
				}
			}
		}
	}

	while (!node.empty()) {
		s_hei = node.front();
		node.pop();
		s_row = node.front();
		node.pop();
		s_col = node.front();
		node.pop();
		count = node.front();
		node.pop();

		if (-1 < (s_hei - 1)) {
			if (map[s_hei - 1][s_row][s_col] == 0) {
				map[s_hei - 1][s_row][s_col] = 1;
				node.push(s_hei - 1);
				node.push(s_row);
				node.push(s_col);
				node.push(count + 1);
				if ((count + 1) > day) day = count + 1;
			}
		}

		if ((s_hei + 1) < hei) {
			if (map[s_hei + 1][s_row][s_col] == 0) {
				map[s_hei + 1][s_row][s_col] = 1;
				node.push(s_hei + 1);
				node.push(s_row);
				node.push(s_col);
				node.push(count + 1);
				if ((count + 1) > day) day = count + 1;
			}
		}

		if (-1 < (s_row - 1)) {
			if (map[s_hei][s_row - 1][s_col] == 0) {
				map[s_hei][s_row - 1][s_col] = 1;
				node.push(s_hei);
				node.push(s_row - 1);
				node.push(s_col);
				node.push(count + 1);
				if ((count + 1) > day) day = count + 1;
			}
		}

		if ((s_row + 1) < row) {
			if (map[s_hei][s_row + 1][s_col] == 0) {
				map[s_hei][s_row + 1][s_col] = 1;
				node.push(s_hei);
				node.push(s_row + 1);
				node.push(s_col);
				node.push(count + 1);
				if ((count + 1) > day) day = count + 1;
			}
		}

		if (-1 < (s_col - 1)) {
			if (map[s_hei][s_row][s_col - 1] == 0) {
				map[s_hei][s_row][s_col - 1] = 1;
				node.push(s_hei);
				node.push(s_row);
				node.push(s_col - 1);
				node.push(count + 1);
				if ((count + 1) > day) day = count + 1;
			}
		}

		if ((s_col + 1) < col) {
			if (map[s_hei][s_row][s_col + 1] == 0) {
				map[s_hei][s_row][s_col + 1] = 1;
				node.push(s_hei);
				node.push(s_row);
				node.push(s_col + 1);
				node.push(count + 1);
				if ((count + 1) > day) day = count + 1;
			}
		}
	}

	for (int x = 0; x < hei; ++x) {
		for (int i = 0; i < row; ++i) {
			for (int j = 0; j < col; ++j) {
				if (map[x][i][j] == 0) {
					cout << -1;
					return;
				}
			}
		}
	}
	cout << day;
}

int main() {
	int N, M, H, input;
	vector<vector<vector<int>>> map;

	cin >> M >> N >> H;
	map.resize(H);
	for (int x = 0; x < H; ++x) {
		map[x].resize(N);
		for (int i = 0; i < N; ++i) {
			map[x][i].resize(M);
			for (int j = 0; j < M; ++j) {
				cin >> input;
				map[x][i][j] = input;
			}
		}
	}

	bfs(map, N, M, H);

	return 0;
}