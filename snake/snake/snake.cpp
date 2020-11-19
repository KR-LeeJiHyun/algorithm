#include <iostream>
#include <cstdlib>
#include <vector>
#include <queue>

using namespace std;

class InvalidIndexException {};

template<typename T>
class ListNode {
public:
	T row;
	T col;
	ListNode<T> *next; // 마지막 노드면 nullptr

					   // 생성자
	ListNode<T>() : next(nullptr) {}
	ListNode<T>(T row, T col, ListNode<T> *next1) : row(row), col(col), next(next1) {}
};

template<typename T>
class LinkedList {
public:
	int size;
	ListNode<T> *head;

	// 생성자
	LinkedList<T>() : size(0), head(nullptr) {}

	// 소멸자
	~LinkedList<T>() {
		ListNode<T> *t1 = head, *t2;
		while (t1 != nullptr) {
			t2 = t1->next;
			delete t1;
			t1 = t2;
		}
	}

	// 멤버 함수
	void insert(int k, T row, T col) { // k번째 원소 앞에 새 원소 삽입
		try {
			// 예외 처리: 잘못된 인덱스
			if (k < 0 || k > size) throw InvalidIndexException();

			if (k == 0) { // 처음에 삽입
				head = new ListNode<T>(row, col, head);
			}
			else { // k번째 원소 앞에 삽입
				ListNode<T> *dest = head;
				for (int i = 0; i<k - 1; i++) dest = dest->next;
				dest->next = new ListNode<T>(row, col, dest->next);
			}
			size++;
		}
		catch (InvalidIndexException e) {
			cerr << "잘못된 인덱스입니다." << endl;
			exit(1);
		}
	}

	void erase(int k, vector<vector<bool>> &board) { // k번째 원소를 제거
		try {
			// 예외 처리: 잘못된 인덱스
			if (k < 0 || k >= size) throw InvalidIndexException();

			if (k == 0) { // head를 삭제
				ListNode<T> *temp = head->next;
				board[head->row][head->col] = false;
				delete head;
				head = temp;
			}
			else { // k번째 원소 삭제
				ListNode<T> *dest = head, *temp;
				for (int i = 0; i<k - 1; i++) dest = dest->next;
				temp = dest->next->next;
				board[dest->next->row][dest->next->col] = false;
				delete dest->next;
				dest->next = temp;
				
			}
			size--;
		}
		catch (InvalidIndexException e) {
			cerr << "잘못된 인덱스입니다." << endl;
			exit(2);
		}
	}

	int getSize() {
		return this->size;
	}


};

void sol(vector<vector<bool>> board, vector<vector<bool>> apple, queue<int> sec, queue<char> arrow,int N, int K, int L) {
	int answer = 0;
	char a = 'R';
	LinkedList<int> LL;
	LL.insert(0, 0, 0);
	board[0][0] = true;
	
	while (true) {
		ListNode<int> *head = LL.head;
		++answer;
		int nr, nc, S = -1;
		char C = NULL;
		if (!sec.empty()) {
			S = sec.front();
			C = arrow.front();
			if (answer == S) {
				sec.pop();
				arrow.pop();
			}
		}

		if (a == 'U') {
			nr = head->row - 1;
			nc = head->col;
			if (nr == -1 || board[nr][nc]) {
				cout << answer;
				break;
			}
			else {
				if (apple[nr][nc]) {
					apple[nr][nc] = false;
					LL.insert(0, nr, nc);
					board[nr][nc] = true;
				}
				else {
					LL.insert(0, nr, nc);
					LL.erase(LL.getSize() - 1, board);
					board[nr][nc] = true;
				}
			}
			if (S == answer) {
				if (C == 'L') a = 'L';
				else a = 'R';
			}
		}

		else if (a == 'D') {
			nr = head->row + 1;
			nc = head->col;
			if (nr == N || board[nr][nc]) {
				cout << answer;
				break;
			}
			else {
				if (apple[nr][nc]) {
					apple[nr][nc] = false;
					LL.insert(0, nr, nc);
					board[nr][nc] = true;
				}
				else {
					LL.insert(0, nr, nc);
					LL.erase(LL.getSize() - 1, board);
					board[nr][nc] = true;
				}
			}
			if (S == answer) {
				if (C == 'L') a = 'R';
				else a = 'L';
			}
		}

		else if (a == 'L') {
			nr = head->row;
			nc = head->col - 1;
			if (nc == -1 || board[nr][nc]) {
				cout << answer;
				break;
			}
			else {
				if (apple[nr][nc]) {
					apple[nr][nc] = false;
					LL.insert(0, nr, nc);
					board[nr][nc] = true;
				}
				else {
					LL.insert(0, nr, nc);
					LL.erase(LL.getSize() - 1, board);
					board[nr][nc] = true;
				}
			}
			if (S == answer) {
				if (C == 'L') a = 'D';
				else a = 'U';
			}
		}

		else {
			nr = head->row;
			nc = head->col + 1;
			if (nc == N || board[nr][nc]) {
				cout << answer;
				break;
			}
			else {
				if (apple[nr][nc]) {
					apple[nr][nc] = false;
					LL.insert(0, nr, nc);
					board[nr][nc] = true;
				}
				else {
					LL.insert(0, nr, nc);
					LL.erase(LL.getSize() - 1, board);
					board[nr][nc] = true;
				}
			}
			if (S == answer) {
				if (C == 'L') a = 'U';
				else a = 'D';
			}
		}
	}
}

int main() {
	vector<vector<bool>> board;
	vector<vector<bool>> apple;
	queue<int> sec;
	queue<char> arrow;
	int N, K, L, row, col, S;
	char C, A = 'R';

	cin >> N >> K;
	
	board.resize(N);
	apple.resize(N);
	for (int i = 0; i < N; ++i) { 
		board[i].resize(N);
		apple[i].resize(N);
	};

	for (int i = 0; i < K; ++i) {
		cin >> row >> col;
		apple[row - 1][col - 1] = true;
	}

	cin >> L;
	for (int i = 0; i < L; ++i) {
		cin >> S >> C;
		sec.push(S);
		arrow.push(C);
	}
	
	sol(board, apple, sec, arrow, N, K, L);
	return 0;
}