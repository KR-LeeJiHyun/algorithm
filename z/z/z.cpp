#include <iostream>
#include <vector>
#include <cmath>

using namespace std;

int number = 0;

void sol(int N, int r, int c, int d_r, int d_c) {
	if (N == 2) {
		for (int row = r; row < (r + N); ++row) {
			for (int col = c; col < (c + N); ++col) {
				if (row == d_r && col == d_c) {
					cout << number;
					return;
				}
				++number;
			}
		}
		return;
	}
	else {
		int next_N = N / 2;
		sol(next_N, r, c, d_r, d_c);
		sol(next_N, r, c + next_N, d_r, d_c);
		sol(next_N, r + next_N, c, d_r, d_c);
		sol(next_N, r + next_N, c + next_N, d_r, d_c);
	}
}

int main() {
	int N, r, c;

	cin >> N >> r >> c;
	N = pow(2, N);

	sol(N, 0 , 0, r, c);

	return 0;
}

//테스트용
/*#include <iostream>
#include <vector>
#include <cmath>

using namespace std;

//vector<vector<int>> map;
int number = 0;

void sol(int N, int r, int c, int d_r, int d_c) {
	if (N == 2) {
		for (int row = r; row < (r + N); ++row) {
			for (int col = c; col < (c + N); ++col) {
				if (row == d_r && col == d_c) {
					cout << number;
					return;
				}
				++number;
			}
		}
		return;
	}
	else {
		int next_N = N / 2;
		sol(next_N, r, c, d_r, d_c);
		sol(next_N, r, c + next_N, d_r, d_c);
		sol(next_N, r + next_N, c, d_r, d_c);
		sol(next_N, r + next_N, c + next_N, d_r, d_c);
	}
}

int main() {
	int N, r, c;

	cin >> N >> r >> c;
	N = pow(2, N);

	sol(N, 0 , 0, r, c);

	/*for (int i = 0; i < N; ++i) {
		for (int j = 0; j < N; ++j) {
			cout.width(5);
			cout.fill(' ');
			cout << map[i][j] << " ";
		}
		cout << endl;
	}

	cout << endl;
	cout << map[r][c];

return 0;
}*/