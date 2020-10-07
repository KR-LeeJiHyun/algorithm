#include <iostream>
#include <vector>
#include <queue>
#include <string>

using namespace std;

void bfs(vector<vector<int>> &map,int row, int col) {
	int s_row, s_col;
	int count = 0;
	queue<int> node;
	node.push(0);
	node.push(0);
	node.push(0);

	while (!node.empty()) {
		s_row = node.front();
		node.pop();
		s_col = node.front();
		node.pop();
		count = node.front();
		node.pop();

		if ((s_row + 1) == row && (s_col + 1) == col) {
			cout << count + 1;
			return;
		}

		if (-1 < (s_row - 1)) {
			if (map[s_row - 1][s_col] == 1) {
				map[s_row - 1][s_col] = 0;
				node.push(s_row - 1);
				node.push(s_col);
				node.push(count + 1);
			}
		}

		if ((s_row + 1) < row) {
			if (map[s_row + 1][s_col] == 1) {
				map[s_row + 1][s_col] = 0;
				node.push(s_row + 1);
				node.push(s_col);
				node.push(count + 1);
			}
		}

		if (-1 < (s_col - 1)) {
			if (map[s_row][s_col - 1] == 1) {
				map[s_row][s_col - 1] = 0;
				node.push(s_row);
				node.push(s_col - 1);
				node.push(count + 1);
			}
		}

		if ((s_col + 1) < col) {
			if (map[s_row][s_col + 1] == 1) {
				map[s_row][s_col + 1] = 0;
				node.push(s_row);
				node.push(s_col + 1);
				node.push(count + 1);
			}
		}
	}
}



int main() {
	int N, M;
	string input;
	vector<vector<int>> map;

	cin >> N >> M;

	map.resize(N);
	for (int row = 0; row < N; ++row) {
		map[row].resize(M);
		cin.get();
		for (int col = 0; col < M; ++col) {
			input = cin.get();
			map[row][col] = stoi(input);
		}
	}
	
	bfs(map, N, M);

	return 0;
}