#include <iostream>
#include <queue>
#include <vector>

using namespace std;

void bfs(int start, int dest) {
	int sec, pos;
	vector<int> visit(100001);
	queue<int> node;
	visit[start] = 1;
	node.push(start);
	node.push(0);

	while (!node.empty()) {
		pos = node.front();
		node.pop();
		sec = node.front();
		node.pop();

		if (pos == dest) {
			cout << sec;
			return;
		}

		else if (pos > dest && visit[pos - 1] == 0) {
			visit[pos - 1] = 1;
			++sec;
			node.push(pos - 1);
			node.push(sec);
		}

		else {
			++sec;
			//�����̵�
			if (pos < 50001 && pos != 0 && visit[2*pos] == 0) {
				visit[2 * pos] = 1;
				node.push(2 * pos);
				node.push(sec);
			}
            //�ڷ� ��ĭ
			if (pos > 0 && visit[pos - 1] == 0) {
				visit[pos - 1] = 1;
				node.push(pos - 1);
				node.push(sec);
			}
			//������ ��ĭ
			if (pos < 100000 && visit[pos + 1] == 0) {
				visit[pos + 1] = 1;
				node.push(pos + 1);
				node.push(sec);
			}
		}
	}
}

int main() {
	int N, K;

	cin >> N >> K;
	bfs(N, K);
	
	return 0;
}