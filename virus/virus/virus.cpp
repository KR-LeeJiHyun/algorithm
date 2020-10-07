#include <iostream>
#include <vector>
#include <queue>

using namespace std;

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
	start = 1;
	cin >> N >> M;

	vector<int>* bfs_graph = new vector<int>[N + 1];
	vector<int> visit_bfs(N + 1);
	queue<int> bfs_node;

	bfs_node.push(start);

	int u, v;
	for (int i = 0; i < M; ++i) {
		cin >> u >> v;
		bfs_graph[u].push_back(v);
		bfs_graph[v].push_back(u);
	}
	bfs(bfs_graph, bfs_node, N, visit_bfs);

	cout << bfs_graph[0].size()-1;

	return 0;
}