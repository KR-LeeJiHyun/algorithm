#include <iostream>
#include <vector>

using namespace std;

void sol(int min_L, int max_L, int max_H, int max_HL, vector<int> warehouse) {
	int answer = warehouse[max_HL];
	int H = warehouse[min_L];
	int L = min_L;
	for (int i = min_L + 1; i <= max_HL; ++i) {
		if (H <= warehouse[i]) {
			answer += (H*(i - L));
			L = i;
			H = warehouse[i];
		}
	}
	H = warehouse[max_L];
	L = max_L;
	for (int i = max_L; i >= max_HL; --i) {
		if (H <= warehouse[i]) {
			answer += (H*(L - i));
			L = i;
			H = warehouse[i];
		}
	}
	cout << answer;
}

int main() {
	int N, L, H, max_L = 0, max_H = 0, min_L = 1001, max_HL;
	vector<int> warehouse(1001);

	cin >> N;

	for (int i = 0; i < N; ++i) {
		cin >> L >> H;
		if (min_L > L) min_L = L;
		if (max_L < L) max_L = L;
		if (max_H < H) { 
			max_H = H;
			max_HL = L;
		};
		warehouse[L] = H;
	}

	sol(min_L, max_L, max_H, max_HL, warehouse);
	return 0;
}
