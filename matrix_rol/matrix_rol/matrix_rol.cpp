#include <string>
#include <vector>
#include <iostream>

using namespace std;

void print_matrix(vector<vector<int>> matrix, int rows, int columns) {
    for (int row = 0; row < rows; ++row) {
        matrix[row].resize(columns);
        for (int col = 0; col < columns; ++col) {
            cout << matrix[row][col] << " ";
        }
        cout << "\n";
    }
}

vector<int> solution(int rows, int columns, vector<vector<int>> queries) {
    vector<int> answer;
    vector<vector<int>> matrix(rows);

    int num = 1;
    for (int row = 0; row < rows; ++row) {
        matrix[row].resize(columns);
        for (int col = 0; col < columns; ++col) {
            matrix[row][col] = num++;
        }
    }

    for (int idx = 0; idx < queries.size(); ++idx) {
        int x1 = queries[idx][0] - 1, y1 = queries[idx][1] - 1, x2 = queries[idx][2] - 1, y2 = queries[idx][3] - 1, c_num = matrix[x1][y1], min = c_num, cx = x1, cy = y1;
        bool right = true, left = false, up = false, down = false;
        
        while (right) {
            if (right && cy + 1 <= y2) {
                int tmp = matrix[cx][cy + 1];
                matrix[cx][cy + 1] = c_num;
                c_num = tmp;
                ++cy;
                if (min > c_num) min = c_num;
            }
            else {
                right = false;
                down = true;
            }
        }
        
        while (down) {
            if (down && cx + 1 <= x2) {
                int tmp = matrix[cx + 1][cy];
                matrix[cx + 1][cy] = c_num;
                c_num = tmp;
                ++cx;
                if (min > c_num) min = c_num;
            }
            else {
                down = false;
                left = true;
            }
        }

        while (left) {
            if (left && cy - 1 >= y1) {
                int tmp = matrix[cx][cy - 1];
                matrix[cx][cy - 1] = c_num;
                c_num = tmp;
                --cy;
                if (min > c_num) min = c_num;
            }
            else {
                left = false;
                up = true;
            }
        }

        while (up) {
            if (up && cx - 1 >= x1) {
                int tmp = matrix[cx - 1][cy];
                matrix[cx - 1][cy] = c_num;
                c_num = tmp;
                --cx;
                if (min > c_num) min = c_num;
            }
            else up = false;
        }

        cout << "\n";
        print_matrix(matrix, rows, columns);

        answer.push_back(min);
    }

    return answer;
}

/*
* 
            

            

            
*/
int main() {
    int rows = 3, columns = 3;
    vector<vector<int>> queries = {
        {1, 1, 2, 2}, {1, 2, 2, 3}, 
        {2, 1, 3, 2}, {2, 2, 3, 3}
    };

    solution(rows, columns, queries);

    return 0;
}