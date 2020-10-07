#include <iostream>
#include <algorithm>
#include <vector>
#include <queue>

using namespace std;

void dfs(vector<int>* graph, int start, int N, vector<int>& visit_node) {
	graph[0].push_back(start);
	visit_node[start] = 1;

	for (int i = 0; i < graph[start].size(); ++i) {
		if (visit_node[graph[start][i]] != 1) {
			dfs(graph, graph[start][i], N, visit_node);
		}
	}
}

void bfs(vector<int>* graph, queue<int> bfs_start, int N, vector<int>& visit_node) {
	int start;

	while (!bfs_start.empty()) {
		start = bfs_start.front();
		bfs_start.pop();
		graph[0].push_back(start);
		visit_node[start] = 1;
		for (int i = 0; i < graph[start].size(); ++i) {
			if (visit_node[graph[start][i]] != 1) { 
				bfs_start.push(graph[start][i]);
				visit_node[graph[start][i]] = 1;
			}
		}
	}
}

int main() {
	int N, M, start;

	cin >> N >> M >> start;

	vector<int>* dfs_graph = new vector<int>[N+1];
	vector<int>* bfs_graph = new vector<int>[N + 1];
	vector<int> visit_dfs(N + 1);
	vector<int> visit_bfs(N + 1);
	queue<int> bfs_node;

	bfs_node.push(start);

	int u, v;
	for (int i = 0; i < M; ++i) {
		cin >> u >> v;
		dfs_graph[u].push_back(v);
		dfs_graph[v].push_back(u);
		bfs_graph[u].push_back(v);
		bfs_graph[v].push_back(u);
	}

	for (int i = 1; i < N; ++i) {
		sort(dfs_graph[i].begin(), dfs_graph[i].end());
		sort(bfs_graph[i].begin(), bfs_graph[i].end());
	}

	dfs(dfs_graph, start, N, visit_dfs);
	bfs(bfs_graph, bfs_node, N, visit_bfs);

	for (int i = 0; i < dfs_graph[0].size(); ++i) {
		cout << dfs_graph[0][i] << " ";
	}

	cout << endl;

	for (int i = 0; i < bfs_graph[0].size(); ++i) {
		cout << bfs_graph[0][i] << " ";
	}

	return 0;
}