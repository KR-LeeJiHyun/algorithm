#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

bool compare(const pair<int, int> &a, const pair<int, int> &b) {
	return (a.second > b.second);
}

long long sol(vector<pair<int, int>> rest, int L, int N, int rf, int rb) {
	long long result = 0;
	long long current_pos = 0;
	long long prev_pos = 0;
	long long tf, tb, diff;

	for (int i = 0; i < rest.size(); ++i) {
		if (current_pos < rest[i].first) {
			prev_pos = current_pos;
			current_pos = rest[i].first;
			tf = rf*(current_pos - prev_pos);
			tb = rb*(current_pos - prev_pos);
			diff = tf - tb;
			result += (diff*rest[i].second);
		}
	}

	return result;
}

int main() {
	int L, N, rf, rb, x, c;
	vector<pair<int, int>> rest;

	cin >> L >> N >> rf >> rb;

	for (int i = 0; i < N; ++i) {
		cin >> x >> c;
		rest.push_back(make_pair(x, c));
	}

	sort(rest.begin(), rest.end(), compare);

	cout << sol(rest, L, N, rf, rb);

	return 0;
}