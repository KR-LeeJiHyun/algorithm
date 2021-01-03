#include <iostream>
#include <queue>
#include <string>
#include <algorithm>

using namespace std;

string input;
int K;
bool visit[11][1000001];

struct info {
	string str;
	int count;
};

string exchange(string str, int i, int j) {
	char temp;
	temp = str[i];
	str[i] = str[j];
	str[j] = temp;
	return str;
}

void sol() {
	queue<info> q;
	vector<int> answer;
	info temp;
	temp.str = input;
	temp.count = 0;
	
	q.push(temp);

	while (!q.empty()) {
	    temp = q.front();
		q.pop();

		if (temp.count != K) {
			string str_temp;
			info info_temp;
			for (int i = 0; i < temp.str.length() - 1; ++i) {
				for (int j = i + 1; j < temp.str.length(); ++j) {
					if (i != 0) {
						str_temp = exchange(temp.str, i, j);
						if (!visit[temp.count][stoi(str_temp)]) {
							visit[temp.count][stoi(str_temp)] = true;
							info_temp.str = str_temp;
							info_temp.count = temp.count + 1;
							q.push(info_temp);
						}
					}
					else {
						if (temp.str[j] != '0') {
							str_temp = exchange(temp.str, i, j);
							if (!visit[temp.count][stoi(str_temp)]) {
								visit[temp.count][stoi(str_temp)] = true;
								info_temp.str = str_temp;
								info_temp.count = temp.count + 1;
								q.push(info_temp);
							}
						}
						else continue;
					}
				}
			}
		}
		else {
			answer.push_back(stoi(temp.str));
		}
	}
	
	if (answer.size() > 0) {
		sort(answer.begin(), answer.end());

		cout << answer[answer.size() - 1];
	}

	else cout << -1;
}

int main() {
	cin >> input >> K;
	sol();
	return 0;
}