#include <iostream>
#include <vector>

using namespace std;

vector<vector<int>> map;
int n, m;
const int INF = 10000000;

void sol(){
	for (int relay = 0; relay < n; ++relay) {
		for (int row = 0; row < n; ++row) {
			for (int col = 0; col < n; ++col) {
				if (map[row][col] > (map[row][relay] + map[relay][col]))
					map[row][col] = map[row][relay] + map[relay][col];
			}
		}
	}
}

int main() {
	cin >> n;
	cin >> m;

	map.resize(n);
	for (int idx = 0; idx < n; ++idx) {
		map[idx].resize(n, INF);
		map[idx][idx] = 0;
	}

	for (int idx = 0; idx < m; ++idx) {
		int row, col, cost;
		cin >> row >> col >> cost;
		if(map[row-1][col-1] == 0 || map[row-1][col-1] > cost)
			map[row - 1][col - 1] = cost;
	}

	sol();

	for (int row = 0; row < n; ++row) {
		for (int col = 0; col < n; ++col) {
			if(map[row][col] == INF) cout << 0 << " ";
			else cout << map[row][col] << " ";
		}
		cout << endl;
	}

	return 0;
}