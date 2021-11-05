#include <vector>
#include <queue>

using namespace std;

vector<int> solution(int m, int n, vector<vector<int>> picture) {
    int number_of_area = 0;
    int max_size_of_one_area = 0;
    vector<vector<bool>> visited(m);
    for (int idx = 0; idx < m; ++idx) {
        visited[idx].resize(n);
    }

    for (int row = 0; row < m; ++row) {
        for (int col = 0; col < n; ++col) {
            if (!visited[row][col] && picture[row][col] != 0) {
                queue<int> q;
                int c_row = 0, c_col = 0;
                int max_size = 0;
                visited[row][col] = true;
                q.push(row);
                q.push(col);
                ++number_of_area;

                while (!q.empty()) {
                    ++max_size;
                    c_row = q.front();
                    q.pop();
                    c_col = q.front();
                    q.pop();
                    //up
                    if(c_row - 1 >= 0 && picture[row][col] == picture[c_row - 1][c_col] && !visited[c_row - 1][c_col]){
                        q.push(c_row - 1);
                        q.push(c_col);
                        visited[c_row - 1][c_col] = true;
                    }
                    //dow
                    if (c_row + 1 < m && picture[row][col] == picture[c_row + 1][c_col] && !visited[c_row + 1][c_col]) {
                        q.push(c_row + 1);
                        q.push(c_col);
                        visited[c_row + 1][c_col] = true;
                    }
                    //left
                    if (c_col - 1 >= 0 && picture[row][col] == picture[c_row][c_col - 1] && !visited[c_row][c_col - 1]) {
                        q.push(c_row);
                        q.push(c_col - 1);
                        visited[c_row][c_col - 1] = true;
                    }
                    //right
                    if (c_col + 1 < n && picture[row][col] == picture[c_row][c_col + 1] && !visited[c_row][c_col + 1]) {
                        q.push(c_row);
                        q.push(c_col + 1);
                        visited[c_row][c_col + 1] = true;
                    }
                }
                if (max_size > max_size_of_one_area) max_size_of_one_area = max_size;
            }
        }
    }

    vector<int> answer(2);
    answer[0] = number_of_area;
    answer[1] = max_size_of_one_area;
    return answer;
}

int main() {
    int m = 6, n = 4;
    vector<vector<int>> picture = {
        { 1, 1, 1, 0 },
        { 1, 1, 1, 0 },
        { 0, 0, 0, 1 },
        { 0, 0, 0, 1 },
        { 0, 0, 0, 1 },
        { 0, 0, 0, 1 }
    };

    solution(m, n, picture);
    return 0;
}