#include <iostream>
#include <vector>

using namespace std;

/* NM
void back_tracking(vector<int> path, vector<bool> visit, int N, int M) {
	if (path.size() == M) {
		for (int idx = 0; idx < M; ++idx) cout << path[idx] + 1 << " ";
		cout << "\n";
		return;
	}


	for (int idx = 0; idx < N; ++idx) {
		vector<int> tmp_path = path;
		vector<bool> tmp_visit = visit;
		if (!tmp_visit[idx]) {
			tmp_visit[idx] = true;
			tmp_path.push_back(idx);
			back_tracking(tmp_path, tmp_visit, N, M);
		}
	}
}*/

/* NM2
void back_tracking(vector<int> path, vector<bool> visit, int N, int M) {
	if (path.size() == M) {
		for (int idx = 0; idx < M; ++idx) cout << path[idx] + 1 << " ";
		cout << "\n";
		return;
	}


	for (int idx = 0; idx < N; ++idx) {
		vector<int> tmp_path = path;
		if (!visit[idx]) {
			visit[idx] = true;
			tmp_path.push_back(idx);
			back_tracking(tmp_path, visit, N, M);
			
		}
	}
}*/

/* NM3
void back_tracking(vector<int> path, vector<bool> visit, int N, int M) {
	if (path.size() == M) {
		for (int idx = 0; idx < M; ++idx) cout << path[idx] + 1 << " ";
		cout << "\n";
		return;
	}


	for (int idx = 0; idx < N; ++idx) {
		vector<int> tmp_path = path;
		tmp_path.push_back(idx);
		back_tracking(tmp_path, visit, N, M);
	}
}*/

void back_tracking(vector<int> path, vector<bool> visit, int N, int M) {
	if (path.size() == M) {
		for (int idx = 0; idx < M; ++idx) cout << path[idx] + 1 << " ";
		cout << "\n";
		return;
	}

	for (int idx = 0; idx < N; ++idx) {
		vector<int> tmp_path = path;
		if (!visit[idx]) {
			tmp_path.push_back(idx);
			back_tracking(tmp_path, visit, N, M);
		}
		visit[idx] = true;
	}
}

int main() {
	int N, M;
	
	cin >> N >> M;

	vector<int> path;
	vector<bool> visit(N, false);

	back_tracking(path, visit, N, M);

	return 0;
}