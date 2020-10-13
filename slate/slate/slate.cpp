#include <iostream>
#include <vector>
#include <queue>

using namespace std;

struct pos {
	int x;
	int y;
};

int cut(vector<vector<int>> slate, pos p, bool horizon);
int remain_slate(vector<vector<int>> slate, bool horizon);
void sol(vector<vector<int>> slate, queue<pos> impurity);

int main() { 
	int N = 0, input = 0;
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

	sol(slate, impurity);

	return 0;
}

int remain_slate(vector<vector<int>> slate, bool horizon) {
	int result = 0;
	pos temp;
	bool pass = true;
	int sum = 0;

	for (int row = 0; row < slate.size(); ++row) {
		for (int col = 0; col < slate[row].size(); ++col) {
			if (slate[row][col] == 1) {
				pass = false;
				break;
			}
			else sum += slate[row][col];
		}
		if (!pass) break;
	}

	if (pass) {
		if (sum == 2) return 1;
		else return 0;
	}

	for (int row = 0; row < slate.size(); ++row) {
		for (int col = 0; col < slate[row].size(); ++col) {
			if (slate[row][col] == 1) {
				temp.x = row;
				temp.y = col;
				result += cut(slate, temp, horizon);
			}
		}
	}
	return result;
}

int cut(vector<vector<int>> slate, pos p, bool horizon) {
	vector<vector<int>> a_slate, b_slate;

	//가로자르기
	if (horizon) {
		//가능여부 판단
		for (int col = 0; col < slate[p.x].size(); ++col) {
			if (slate[p.x][col] == 2) return 0;
		}

		a_slate.resize(p.x);
		for (int row = 0; row < p.x; ++row) {
			a_slate[row].resize(slate[row].size());
			for (int col = 0; col < slate[row].size(); ++col) {
				a_slate[row][col] = slate[row][col];
			}
		}
		b_slate.resize(slate.size() - p.x - 1);
		for (int row = p.x + 1; row < slate.size(); ++row) {
			b_slate[row - p.x - 1].resize(slate[row].size());
			for (int col = 0; col < slate[row].size(); ++col) {
				b_slate[row - p.x - 1][col] = slate[row][col];
			}
		}
		return (remain_slate(a_slate, !horizon)*remain_slate(b_slate, !horizon));
	}

	//세로자르기
	else {
		//가능여부 판단
		for (int row = 0; row < slate.size(); ++row) {
			if (slate[row][p.y] == 2) return 0;
		}

		a_slate.resize(slate.size());
		for (int row = 0; row < slate.size(); ++row) {
			a_slate[row].resize(p.y);
			for (int col = 0; col < p.y; ++col) {
				a_slate[row][col] = slate[row][col];
			}
		}
		b_slate.resize(slate.size());
		for (int row = 0; row < slate.size(); ++row) {
			b_slate[row].resize(slate[row].size() - p.y - 1);
			for (int col = p.y + 1; col < slate[row].size(); ++col) {
				b_slate[row][col - p.y - 1] = slate[row][col];
			}
		}
		return (remain_slate(a_slate, !horizon)*remain_slate(b_slate, !horizon));
	}
}

void sol(vector<vector<int>> slate, queue<pos> impurity) {
	int result = 0;
	pos temp;

	while (!impurity.empty()) {
		temp = impurity.front();
		impurity.pop();
		result += cut(slate, temp, true);
		result += cut(slate, temp, false);
	}

	if(result > 0) cout << result;
	else cout << -1;
}