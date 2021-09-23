#include <iostream>
#include <algorithm>
#include <vector>
#include <queue>

using namespace std;

int N, M, start;
vector<bool> visited;
vector<vector<bool>> graph;

void dfs(int start) {
	cout << start << " ";

	for (int idx = 1; idx <= N; ++idx) {
		if (!visited[idx] && graph[start][idx]) {
			visited[idx] = true;
			dfs(idx);
		}
	}
}

void bfs() {
	queue<int> bfs_q;
	bfs_q.push(start);

	while (!bfs_q.empty()) {
		int u = bfs_q.front();
		bfs_q.pop();
		cout << u << " ";
		for (int idx = 1; idx <= N; ++idx) {
			if (!visited[idx] && graph[u][idx]) {
				visited[idx] = true;
				bfs_q.push(idx);
			}
		}
	}
}

int main() {
	cin >> N >> M >> start;

	graph.resize(N + 1);
	visited.resize(N + 1);

	for (int idx = 0; idx <= N; ++idx) {
		graph[idx].resize(N + 1);
	}

	for (int idx = 0; idx < M; ++idx) {
		int u, v;
		cin >> u >> v;
		graph[u][v] = true;
		graph[v][u] = true;
	}

	visited[start] = true;
	dfs(start);
	cout << "\n";

	visited.clear();
	visited.resize(N + 1);
	visited[start] = true;
	bfs();

	return 0;
}