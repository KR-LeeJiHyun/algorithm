#include<utility>
#include <vector>
#include <iostream>
#include <algorithm>

using namespace std;

bool comp(const pair<int, double> &a, const pair<int, double> &b) {
	if (a.second == b.second) return a.first < b.first;
	return a.second > b.second;
}

vector<int> solution(int N, vector<int> stages) {
	vector<int> answer;
	vector<pair<int, double>> person;

	for (int i = 0; i < N; ++i) {
		double try_p = 0 , clear_p = 0;
		for (int j = 0; j < stages.size(); ++j) {
			if (i < stages[j]) ++try_p;
			if (i + 1 < stages[j]) ++clear_p;
		}
		pair<int, double> result;
		if (try_p != 0) { 
			double temp = (try_p - clear_p) / try_p;
			result = make_pair(i + 1, temp); 
		}
		else result = make_pair(i + 1, 0);

		person.push_back(result);
	}

	sort(person.begin(), person.end(), comp);

	for (int i = 0; i < N; ++i) {
		answer.push_back(person[i].first);
		cout << person[i].first;
	}

	return answer;
}

void main() {
	int N = 4;
	vector<int> stages = { 4,4,4,4,4 };

	solution(N, stages);
}