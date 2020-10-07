#include <iostream>
#include <vector>
#include <queue>

using namespace std;

class m_graph {
private:
	vector<vector<int>> matrix;

public:
	m_graph() {
		matrix.clear();
	}

	m_graph(int row, int col) {
		matrix.resize(row);

		for (int i = 0; i < matrix.size(); ++i) {
			matrix[i].resize(col);
		}
	}

	void set_matrix(int row, int col) {
		this->matrix[row][col] = 1;
	}

	void bfs(int row, int col) {
		int s_row, s_col;
		queue<int> node;
		int N = this->matrix.size();
		int M = this->matrix[0].size();
		node.push(row);
		node.push(col);

		while (!node.empty()) {
			s_row = node.front();
			node.pop();
			s_col = node.front();
			node.pop();

			if (-1 < (s_row - 1)) {
				if (this->matrix[s_row - 1][s_col] == 1) {
					this->matrix[s_row - 1][s_col] = 0;
					node.push(s_row - 1);
					node.push(s_col);
				}
			}

			if ((s_row + 1) < N) {
				if (this->matrix[s_row + 1][s_col] == 1) {
					this->matrix[s_row + 1][s_col] = 0;
					node.push(s_row + 1);
					node.push(s_col);
				}
			}

			if (-1 < (s_col - 1)) {
				if (this->matrix[s_row][s_col - 1] == 1) {
					this->matrix[s_row][s_col - 1] = 0;
					node.push(s_row);
					node.push(s_col - 1);
				}
			}

			if ((s_col + 1) < M) {
				if (this->matrix[s_row][s_col + 1] == 1) {
					this->matrix[s_row][s_col + 1] = 0;
					node.push(s_row);
					node.push(s_col + 1);
				}
			}
		}
	}

	int get_row() {
		return this->matrix.size();
	};

	int get_col() {
		return this->matrix[0].size();
	};

	int at_matrix(int row, int col) {
		return this->matrix[row][col];
	};
};

class cabbage : public m_graph {
private:
	int count;

public:
	cabbage() {
		count = 0;
	}

	cabbage(int row, int col) : m_graph(row, col) {
		count = 0;
	};

	void earthworm() {
		int N = this->get_row();
		int M = this->get_col();

		for (int i = 0; i < N; ++i) {
			for (int j = 0; j < M; ++j) {
				if (this->at_matrix(i, j) == 1) {
					++this->count;
					this->bfs(i, j);
				}
			}
		}

		cout << count << endl;
	};
};


int main() {
	int test, row, col, num_cabbage, pos_r, pos_c;

	cin >> test;

	for (int i = 0; i < test; ++i) {
		cin >> row >> col >> num_cabbage;
		
		cabbage new_cabbage(row, col);

		for (int j = 0; j < num_cabbage; ++j) {
			cin >> pos_r >> pos_c;
			new_cabbage.set_matrix(pos_r, pos_c);
		}

		new_cabbage.earthworm();
	}

	return 0;
}