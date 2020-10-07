#include <iostream>
#include <vector>
#include <queue>
#include <algorithm>
#include <string>

using namespace std;

int bfs(vector<vector<int>> &map, int N, int row, int col, int comp) {
	int result = 1;
	int s_row, s_col;
	queue<int> node;

	node.push(row);
	node.push(col);

	while (!node.empty()) {
		s_row = node.front();
		node.pop();
		s_col = node.front();
		node.pop();

		if (-1 < (s_row - 1)) {
			if (map[s_row - 1][s_col] == 1) {
				result += 1;
				map[s_row - 1][s_col] = 0;
				node.push(s_row - 1);
				node.push(s_col);
			}
		}

		if ((s_row + 1) < N) {
			if (map[s_row + 1][s_col] == 1) {
				result += 1;
				map[s_row + 1][s_col] = 0;
				node.push(s_row + 1);
				node.push(s_col);
			}
		}

		if (-1 < (s_col - 1)) {
			if (map[s_row][s_col - 1] == 1) {
				result += 1;
				map[s_row][s_col - 1] = 0;
				node.push(s_row);
				node.push(s_col - 1);
			}
		}

		if ((s_col + 1) < N) {
			if (map[s_row][s_col + 1] == 1) {
				result += 1;
				map[s_row][s_col + 1] = 0;
				node.push(s_row);
				node.push(s_col + 1);
			}
		}
	}

	return result;
}

void complex(vector<vector<int>> &map, int N) {
	int comp = 0;
	vector<int> result;

	for (int i = 0; i < N; ++i) {
		for (int j = 0; j < N; ++j) {
			if (map[i][j] == 1) {
				map[i][j] = 0;
				++comp;
				result.push_back(bfs(map, N, i, j, comp));
			}
		}
	}
	sort(result.begin(), result.end());
	cout << comp << endl;
	for (int i = 0; i < result.size(); ++i) {
		cout << result[i] << endl;
	}
}

int main() {
	vector<vector<int>> map;
	vector<int> input;
	int N;
	string house;

	cin >> N;

	for (int i = 0; i < N; ++i) {
		cin.get();
		for (int j = 0; j < N; ++j) {
			house = cin.get();
			input.push_back(stoi(house));
		}
		map.push_back(input);
		input.clear();
	}

	complex(map, N);

	return 0;
}