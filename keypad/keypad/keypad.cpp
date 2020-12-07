#include <string>
#include <vector>
#include <iostream>

using namespace std;

string solution(vector<int> numbers, string hand) {
	string answer = "";
	string left = "*", right = "#";
	for (int i = 0; i < numbers.size(); ++i) {
		if (numbers[i] == 1 || numbers[i] == 4 || numbers[i] == 7) {
			left = to_string(numbers[i]);
			answer += 'L';
		}
		else if (numbers[i] == 3 || numbers[i] == 6 || numbers[i] == 9) {
			right = to_string(numbers[i]);
			answer += 'R';
		}
		else {
			int l_row = 1, l_col, r_row = 1, r_col, n_row, n_col = 2;
			int l_temp = 0;
			int r_temp = 0;
			if (left != "*" && left != "0") {
				l_temp = stoi(left);
				while (l_temp > 3) {
					l_temp -= 3;
					++l_row;
				}
				l_col = l_temp;
			}
			else {
				if (left == "*") {
					l_row = 4;
					l_col = 1;
				}
				else {
					l_row = 4;
					l_col = 2;
				}
			}

			if (right != "#" && right != "0") {
				r_temp= stoi(right);
				while (r_temp > 3) {
					r_temp -= 3;
					++r_row;
				}
				r_col = r_temp;
			}
			else {
				if (right == "#") {
					r_row = 4;
					r_col = 3;
				}
				else {
					r_row = 4;
					r_col = 2;
				}
			}
			if (numbers[i] == 2) n_row = 1;
			else if(numbers[i] == 5) n_row = 2;
			else if (numbers[i] == 8) n_row = 3;
			else n_row = 4;

			int l_d, r_d;
			l_d = n_col - l_col;
			r_d = r_col - n_col;
			if ((n_row - l_row) < 0) l_d += (-1)*(n_row - l_row);
			else l_d += n_row - l_row;
			if ((n_row - r_row) < 0) r_d += (-1)*(n_row - r_row);
			else r_d += n_row - r_row;

			if (l_d == r_d) {
				if (hand == "left") { 
					answer += "L";
					left = to_string(numbers[i]);
				}
				else { 
					answer += "R";
					right = to_string(numbers[i]);
				}
			}
			else {
				if(l_d < r_d) {
					answer += "L";
					left = to_string(numbers[i]);
				}
				else {
					answer += "R";
					right = to_string(numbers[i]);
				}
			}
		}
	}
	return answer;
}

void main() {
	vector<int> numbers = { 7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2 };
	string hand = "left";
	cout << solution(numbers, hand);
}