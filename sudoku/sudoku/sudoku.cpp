#include <iostream>
#include <vector>

using namespace std;

const int N = 9, SN = 3;
bool answer = false;
vector<vector<int>> board;
vector<vector<bool>> r_check, c_check, s_check;

int square_check(int row, int col){
    return ((row / SN) * SN) + (col / SN);
}


bool sol(int n) {
    if (n == N * N) return true;

    int row = n / N, col = n % N;
    int s = square_check(row, col);

    if (board[row][col] != 0) return sol(n + 1);
    else {
        for (int num = 1; num <= N; ++num) {
            if (!r_check[row][num - 1] && !c_check[col][num - 1] && !s_check[s][num - 1]) {
                r_check[row][num - 1] = true;
                c_check[col][num - 1] = true;
                s_check[s][num - 1] = true;
                board[row][col] = num;

                if (sol(n + 1)) return true;

                r_check[row][num - 1] = false;
                c_check[col][num - 1] = false;
                s_check[s][num - 1] = false;
                board[row][col] = 0;
            }
        }
    }

    return false;
}


int main() {
	board.resize(N);
	r_check.resize(N);
	c_check.resize(N);
    s_check.resize(N);
	for (int idx = 0; idx < N; ++idx) {
		r_check[idx].resize(N);
		c_check[idx].resize(N);
        s_check[idx].resize(N);
	}

	for (int row = 0; row < N; ++row) {
		for (int col = 0; col < N; ++col) {
			int input = 0;
			cin >> input;
			board[row].push_back(input);
            if(input != 0){
				r_check[row][input - 1] = true;
				c_check[col][input - 1] = true;
                s_check[square_check(row, col)][input - 1] = true;
			}
		}
	}
	sol(0);

	for (int row = 0; row < N; ++row) {
		for (int col = 0; col < N; ++col) {
			cout << board[row][col] << " ";
		}
		cout << endl;
	}
	return 0;
}
/*#include <iostream>

using namespace std;

int sudoku[10][10];

bool check_row[10][10]; // �� �˻� : x�࿡ ���� y�� ������ true
bool check_col[10][10]; // �� �˻� : x���� ���� y�� ������ true
bool check_square[10][10]; // ���� ���簢�� �˻� : x��° ���� ���簢���� ���� y�� ������ true

// row�� col���� ���ϴ� ���� ���簢�� ���ϱ�
int get_square(int row, int col){
    return (row/3)*3 + (col/3);
}

// sudoku ���
void print(){
    for(int i=0; i<9; i++){
        for(int j=0; j<9; j++){
            cout << sudoku[i][j] << ' ';
        }
        cout << '\n';
    }
}

// num��° ������ ���ϱ�
bool solve(int num){
    // ������ ĭ�� ��� -> ��� �� ����
    if(num == 81) {
        print();
        return true;
    }
    
    // ��, �� ���ϱ�
    int x = num/9; int y = num%9;
    
    if(sudoku[x][y] != 0){
        // ���� ������ -> ���� ���� �Ѿ��
        return solve(num+1);
    } else {
        // ���� ������ -> 1~9 �˻��ؼ� �� ä���
        for(int i=1; i<=9; i++){
            if(!check_row[x][i] && !check_col[y][i] && !check_square[get_square(x, y)][i]){
                // ������ ó��
                check_row[x][i] = true;
                check_col[y][i] = true;
                check_square[get_square(x, y)][i] = true;
                sudoku[x][y] = i;
                
                if(solve(num+1)){
                    return true;
                }
                
                // �ٽ� �������� (��Ʈ��ŷ)
                check_row[x][i] = false;
                check_col[y][i] = false;
                check_square[get_square(x, y)][i] = false;
                sudoku[x][y] = 0;
            }
        }
    }
    
    return false;
}

int main(void){
    
    for(int i=0; i<9; i++){
        for(int j=0; j<9; j++){
            cin >> sudoku[i][j];
            
            // ��ĭ�� �ƴ� ��� ó��
            if(sudoku[i][j] != 0){
                check_row[i][sudoku[i][j]] = true;
                check_col[j][sudoku[i][j]] = true;
                check_square[get_square(i, j)][sudoku[i][j]] = true;
            }
        }
    }
    
    // 0�� ĭ���� ä��� ����
    solve(0);
    return 0;
}*/