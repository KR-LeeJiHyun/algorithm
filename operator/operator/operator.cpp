#include <iostream>
#include <vector>

using namespace std;

const int OPE_N = 4, PLUS = 0, MINUS = 1, MUL = 2, DIV = 3;
int n = 0;
int mini = 1000000000;
int maxi = -1000000000;
vector<int> numbers;
vector<int> ope;

void insert_ope(int number_idx, int result, vector<int> opes) {
	if (number_idx == n) {
		if (mini > result) mini = result;
		if (maxi < result) maxi = result;
		return;
	}

	int tmp_result = result;
	vector<int> tmp_ope = opes;

	for (int idx = 0; idx < OPE_N; ++idx) {
		if (idx == PLUS && tmp_ope[idx] != 0) {
			tmp_result += numbers[number_idx];
			--tmp_ope[idx];
			insert_ope(number_idx + 1, tmp_result, tmp_ope);
			++tmp_ope[idx];
			tmp_result = result;
		}
		else if (idx == MINUS && tmp_ope[idx] != 0) {
			tmp_result -= numbers[number_idx];
			--tmp_ope[idx];
			insert_ope(number_idx + 1, tmp_result, tmp_ope);
			++tmp_ope[idx];
			tmp_result = result;
		}
		else if (idx == MUL && tmp_ope[idx] != 0) {
			tmp_result = tmp_result * numbers[number_idx];
			--tmp_ope[idx];
			insert_ope(number_idx + 1, tmp_result, tmp_ope);
			++tmp_ope[idx];
			tmp_result = result;
		}
		else if (idx == DIV && tmp_ope[idx] != 0) {
			tmp_result = tmp_result / numbers[number_idx];
			--tmp_ope[idx];
			insert_ope(number_idx + 1, tmp_result, tmp_ope);
			++tmp_ope[idx];
			tmp_result = result;
		}
	}
}

int main() {
	int input = 0;
	cin >> n;

	for (int idx = 0; idx < n; ++idx) {
		cin >> input;
		numbers.push_back(input);
	}

	for (int idx = 0; idx < OPE_N; ++idx) {
		cin >> input;
		ope.push_back(input);
	}

	insert_ope(1, numbers[0], ope);

	cout << maxi << endl << mini;

	return 0;
}