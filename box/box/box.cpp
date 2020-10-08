#include <iostream>
#include <vector>
#include <algorithm>
#include <cmath>

using namespace std;

struct cube {
	int len;
	int count;
};

int result = 0;
bool np = false;

//a*b*c를 d*d*d로 채우면 (a-d)*d*d ,a*(b-d)*d, a*b*(c-d)
void sol(int L, int W, int H, int N, vector<cube> &cubes) {
	if (np) return;
	if (L == 0 || W == 0 || H == 0) return;

	for (int i = 0; i < N; ++i) {
		if (cubes[i].count > 0 && cubes[i].len <= L && cubes[i].len <= H && cubes[i].len <= W) {
			--cubes[i].count;
			++result;
			sol(L - cubes[i].len, cubes[i].len, cubes[i].len, N, cubes);
			sol(L, W - cubes[i].len, cubes[i].len, N, cubes);
			sol(L, W, H - cubes[i].len, N, cubes);
			return;
		}
	}
	np = true;
}

bool comp(cube a, cube b) {
	return (a.len > b.len);
}

int main() {
	int L, W, H, N, input;	
	cube c;
	vector<cube> cubes;

	cin >> L >> W >> H >> N;

	for (int i = 0; i < N; ++i) {
		cin >> input >> c.count;
		c.len = pow(2, input);
		cubes.push_back(c);
	}

	sort(cubes.begin(), cubes.end(), comp);

	sol(L, W, H, N, cubes);

	if (np) cout << -1;
	else cout << result;

	return 0;
}

//메모리 초과 코드
/*#include <iostream>
#include <vector>
#include <algorithm>
#include <queue>
#include <cmath>

using namespace std;

struct cube {
	int len;
	int count;
};

//a*b*c를 d*d*d로 채우면 (a-d)*d*d ,a*(b-d)*d, a*b*(c-d)
int sol(int L, int W, int H, int N, vector<cube> cube) {
	int result = 0;
	queue<int> q_box;
	q_box.push(L);
	q_box.push(W);
	q_box.push(H);

	int temp_L, temp_W, temp_H;

	while (!q_box.empty()) {
		temp_L = q_box.front();
		q_box.pop();
		temp_W = q_box.front();
		q_box.pop();
		temp_H = q_box.front();
		q_box.pop();

		for (int i = 0; i < N; ++i) {
			if (cube[i].count > 0 && cube[i].len <= temp_L && cube[i].len <= temp_H && cube[i].len <= temp_W) {
				--cube[i].count;
				if ((temp_L - cube[i].len) != 0) {
					q_box.push(temp_L - cube[i].len);
					q_box.push(cube[i].len);
					q_box.push(cube[i].len);
				}
				if ((temp_W - cube[i].len) != 0) {
					q_box.push(temp_L);
					q_box.push(temp_W - cube[i].len);
					q_box.push(cube[i].len);
				}
				if ((temp_H - cube[i].len) != 0) {
					q_box.push(temp_L);
					q_box.push(temp_W);
					q_box.push(temp_H - cube[i].len);
				}
				++result;
				break;
			}
			else if ((i + 1) == N) {
				return -1;
			}
		}
	}

	return result;
}

bool comp(cube a, cube b) {
	return (a.len > b.len);
}

int main() {
	int L, W, H, N, input;
	cube c;
	vector<cube> cubes;

	cin >> L >> W >> H >> N;

	for (int i = 0; i < N; ++i) {
		cin >> input >> c.count;
		c.len = pow(2, input);
		cubes.push_back(c);
	}

	sort(cubes.begin(), cubes.end(), comp);
	cout << sol(L, W, H, N, cubes);

	return 0;
}*/