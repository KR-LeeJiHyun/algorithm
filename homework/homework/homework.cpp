#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

bool compare_second(const pair<int, int> &a, const pair<int, int> &b) {
	return (a.second > b.second);
}

int sol(vector <pair<int, int>> homework) {
	int result = 0;
	int d = 0;
	vector<bool> day(1001, false);

	for (int i = 0; i < homework.size(); ++i) {
		d = homework[i].first;
		for (int j = d; j > 0; --j) {
			if (day[j] == false) {
				result += homework[i].second;
				day[j] = true;
				break;
			}
		}
	}

	return result;
}

int main() {
	int N, d, w;
	vector<pair<int, int>> homework;
	
	cin >> N;
	for (int i = 0; i < N; ++i) {
		cin >> d >> w;
		homework.push_back(make_pair(d,w));
	}

	sort(homework.begin(), homework.end(), compare_second);

	cout << sol(homework);

	return 0;
}