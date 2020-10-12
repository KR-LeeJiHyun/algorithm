#include <iostream>
#include <vector>
#include <queue>

using namespace std;

struct pos {
	int x;
	int y;
};

bool cutting(vector<vector<int>> slate, int row, int col, int cut) {
	if (cut == 1) {
		int size = slate.size();
		for (int i = 0; i < size; ++i) {
			if (slate[i][col] == 2) {
				return false;
			}
		}
	}
	else if (cut == 2) {
		int size = slate[0].size();
		for (int i = 0; i < size; ++i) {
			if (slate[row][i] == 2) {
				return false;
			}
		}
	}
	return true;
}

bool remain_slate(vector<vector<int>> slate, int cut) {
	bool pass = true;
	int count = 0;
	int row_size = 0, col_size = 0;
	row_size = slate.size();
	col_size = slate[0].size();

	for (int row = 0; row < row_size; ++row) {
		for (int col = 0; col < col_size; ++col) {
			if (slate[row][col] == 1) {
				pass = false;
			}
			else {
				count += slate[row][col];
			}
		}
		if (!pass) break;
		else if (count > 2) {
			pass = false;
			break;
		}
	}

	if (pass && count == 2) return true;

	return false;
}

void sol(vector<vector<int>> slate, queue<pos> impurity) {
	int result = 0;
	pos temp;
	vector<vector<int>> a_slate, b_slate;

	while (!impurity.empty()) {
		temp = impurity.front();
		impurity.pop();
		
		//가로 자르기
		if (cutting(slate, temp.x, temp.y, 2)) {
			a_slate.resize(temp.x);
			for (int row = 0; row < temp.x; ++row) {
				a_slate[row].resize(slate[row].size());
				for (int col = 0; col < slate[row].size(); ++col) {
					a_slate[row][col] = slate[row][col];
				}
			}
			b_slate.resize(slate.size() - temp.x -1);
			for (int row = temp.x + 1; row < slate.size(); ++row) {
				b_slate[row - temp.x - 1].resize(slate[row].size());
				for (int col = 0; col < slate[row].size(); ++col) {
					b_slate[row - temp.x - 1][col] = slate[row][col];
				}
			}
			if (remain_slate(a_slate, 1) && remain_slate(b_slate, 1)) ++result;
		}

		//세로 자르기
		if (cutting(slate, temp.x, temp.y, 1)) {
			a_slate.resize(slate.size());
			for (int row = 0; row < slate.size(); ++row) {
				a_slate[row].resize(temp.y);
				for (int col = 0; col < temp.y; ++col) {
					a_slate[row][col] = slate[row][col];
				}
			}
			b_slate.resize(slate.size());
			for (int row = 0; row < slate.size(); ++row) {
				b_slate[row].resize(slate[row].size() - temp.y - 1);
				for (int col = temp.y + 1; col < slate[row].size(); ++col) {
					b_slate[row][col - temp.y - 1] = slate[row][col];
				}
			}
			if (remain_slate(a_slate, 2) && remain_slate(b_slate, 2)) ++result;
		}
	}

	cout << result;
}

int main() {
	int a = 3/2;
	cout << a;

	/*int N = 0, input = 0;
	vector<vector<int>> slate;
	queue<pos> impurity;

	cin >> N;
	slate.resize(N);
	for (int row = 0; row < N; ++row) {
		slate[row].resize(N);
		for (int col = 0; col < N; ++col) {
			cin >> input;
			slate[row][col] = input;
			if (input == 1) {
				pos locate;
				locate.x = row;
				locate.y = col;
				impurity.push(locate);
			}
		}
	}

	sol(slate, impurity);*/

	return 0;
}