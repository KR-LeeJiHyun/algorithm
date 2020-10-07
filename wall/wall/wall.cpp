#include <iostream>
#include <vector>
#include <queue>
#include <string>

using namespace std;

void bfs(vector<vector<int>> &map, int row, int col) {
	int s_row, s_col, count, wall;
	vector<vector<bool>> visit;
	queue<int> node;

	visit.resize(2);
	visit[0].assign(row*col, false);
	visit[1].assign(row*col, false);
	map[0][0] = 2;
	node.push(0);
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
		wall = node.front();
		node.pop();

		if ((s_row + 1) == row && (s_col + 1) == col) {
			cout << count + 1;
			return;
		}

		if (-1 < (s_row - 1)) {
			if (map[s_row - 1][s_col] == 0 && visit[wall][(s_row - 1) * col + s_col] == false) {
				visit[wall][(s_row - 1) * col + s_col] = true;
				node.push(s_row - 1);
				node.push(s_col);
				node.push(count + 1);
				node.push(wall);
			}

			else if (wall == 0 && map[s_row - 1][s_col] == 1 && visit[wall][(s_row - 1) * col + s_col] == false) {
				visit[wall][(s_row - 1) * col + s_col] = true;
				node.push(s_row - 1);
				node.push(s_col);
				node.push(count + 1);
				node.push(wall + 1);
			}
		}

		if ((s_row + 1) < row) {
			if (map[s_row + 1][s_col] == 0 && visit[wall][(s_row + 1) * col + s_col] == false) {
				visit[wall][(s_row + 1) * col + s_col] = true;
				node.push(s_row + 1);
				node.push(s_col);
				node.push(count + 1);
				node.push(wall);
			}
			else if (wall == 0 && map[s_row + 1][s_col] == 1 && visit[wall][(s_row + 1) * col + s_col] == false) {
				visit[wall][(s_row + 1) * col + s_col] = true;
				node.push(s_row + 1);
				node.push(s_col);
				node.push(count + 1);
				node.push(wall + 1);
			}
		}

		if (-1 < (s_col - 1)) {
			if (map[s_row][s_col - 1] == 0 && visit[wall][s_row * col + s_col - 1] == false) {
				visit[wall][s_row * col + s_col - 1] = true;
				node.push(s_row);
				node.push(s_col - 1);
				node.push(count + 1);
				node.push(wall);
			}
			else if (wall == 0 && map[s_row][s_col - 1] == 1 && visit[wall][s_row * col + s_col - 1] == false) {
				visit[wall][s_row * col + s_col - 1] = true;
				node.push(s_row);
				node.push(s_col - 1);
				node.push(count + 1);
				node.push(wall + 1);
			}
		}

		if ((s_col + 1) < col) {
			if (map[s_row][s_col + 1] == 0 && visit[wall][s_row * col + s_col + 1] == false) {
				visit[wall][s_row * col + s_col + 1] = true;
				node.push(s_row);
				node.push(s_col + 1);
				node.push(count + 1);
				node.push(wall);
			}
			else if (wall == 0 && map[s_row][s_col + 1] == 1 && visit[wall][s_row * col + s_col + 1] == false) {
				visit[wall][s_row * col + s_col + 1] = true;
				node.push(s_row);
				node.push(s_col + 1);
				node.push(count + 1);
				node.push(wall + 1);
			}
		}
	}
	cout << -1;
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