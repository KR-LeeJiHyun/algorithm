#include <iostream>
#include <vector>
#include <queue>

using namespace std;

void sol(vector<vector<char>> map, queue<int> fire, queue<int> sang, int row, int col) {
	bool escape = false;
	while (!sang.empty()) {
		int cfr, cfc, csr, csc, csn;
		int fire_size = fire.size() / 2;
		int sang_size = sang.size() / 3;
		//불
		for (int i = 0; i < fire_size; ++i) {
			cfr = fire.front();
			fire.pop();
			cfc = fire.front();
			fire.pop();

			//상
			if (cfr != 0 && map[cfr - 1][cfc] != '#' && map[cfr - 1][cfc] != '*') {
				fire.push(cfr - 1);
				fire.push(cfc);
				map[cfr - 1][cfc] = '*';
			}
			//하
			if (cfr != row - 1 && map[cfr + 1][cfc] != '#' && map[cfr + 1][cfc] != '*') {
				fire.push(cfr + 1);
				fire.push(cfc);
				map[cfr + 1][cfc] = '*';
			}
			//좌
			if (cfc != 0 && map[cfr][cfc - 1] != '#' && map[cfr][cfc - 1] != '*') {
				fire.push(cfr);
				fire.push(cfc - 1);
				map[cfr][cfc - 1] = '*';
			}
			//우
			if (cfc != col - 1 &&  map[cfr][cfc + 1] != '#' && map[cfr][cfc + 1] != '*') {
				fire.push(cfr);
				fire.push(cfc + 1);
				map[cfr][cfc + 1] = '*';
			}
		}
		//상근이
		for (int i = 0; i < sang_size; ++i) {
			csr = sang.front();
			sang.pop();
			csc = sang.front();
			sang.pop();
			csn = sang.front();
			sang.pop();

			if (csr == row - 1 || csr == 0 || csc == col - 1 || csc == 0) {
				escape = !escape;
				++csn;
				break;
			}

			//상
			if (csr != 0 && map[csr - 1][csc] != '#' && map[csr - 1][csc] != '*' && map[csr - 1][csc] != '@') {
				sang.push(csr - 1);
				sang.push(csc);
				sang.push(csn + 1);
				map[csr - 1][csc] = '@';
			}
			//하
			if (csr != row - 1 && map[csr + 1][csc] != '#' && map[csr +1][csc] != '*' && map[csr + 1][csc] != '@') {
				sang.push(csr + 1);
				sang.push(csc);
				sang.push(csn + 1);
				map[csr + 1][csc] = '@';
			}
			//좌
			if (csc != 0 && map[csr][csc - 1] != '#' && map[csr][csc - 1] != '*' && map[csr][csc - 1] != '@') {
				sang.push(csr);
				sang.push(csc - 1);
				sang.push(csn + 1);
				map[csr][csc - 1] = '@';
			}
			//우
			if (csc != col - 1 && map[csr][csc + 1] != '#' && map[csr][csc + 1] != '*' && map[csr][csc + 1] != '@') {
				sang.push(csr);
				sang.push(csc + 1);
				sang.push(csn + 1);
				map[csr][csc + 1] = '@';
			}
		}
		
		/*cout << endl;
		for (int i = 0; i < row; ++i) {
			cout << endl;
			for (int j = 0; j < col; ++j) {
				cout << map[i][j];
			}
		}*/

		if (escape) {
			cout << csn << endl;
			break;
		}
	}
	if (!escape) cout << "IMPOSSIBLE" << endl;
}

int main() {
	int N, row, col;
	char input;
	cin >> N;

	for (int n = 0; n < N; ++n) {
		cin >> col >> row;
		vector<vector<char>> map;
		queue<int> fire;
		queue<int> sang;

		map.resize(row);
		for (int i = 0; i < row; ++i) {
			cin.get();
			for (int j = 0; j < col; ++j) {
				input = cin.get();
				map[i].push_back(input);
				if (input == '*') {
					fire.push(i);
					fire.push(j);
				}
				else if (input == '@') {
					sang.push(i);
					sang.push(j);
					sang.push(0);
				}
			}
		}
		sol(map, fire, sang, row, col);
	}
	return 0;
}