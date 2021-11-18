#include <string>
#include <vector>

using namespace std;

int check(vector<string> place, int N) {
    for (int row = 0; row < N; ++row) {
        for (int col = 0; col < N; ++col) {
            if (place[row][col] == 'P') {
                if (col + 1 < N && place[row][col + 1] == 'P') return 0;
                else if (col + 2 < N && place[row][col + 2] == 'P' && place[row][col + 1] != 'X') return 0;
                else if (row + 2 < N && place[row + 2][col] == 'P' && place[row + 1][col] != 'X') return 0;
                else if (row + 1 < N) { 
                    if(place[row + 1][col] == 'P') return 0;
                    else if (col + 1 < N && place[row + 1][col + 1] == 'P') {
                        if (place[row + 1][col] != 'X' || place[row][col + 1] != 'X') return 0;
                    }
                    else if (col > 0 && place[row + 1][col - 1] == 'P') {
                        if (place[row + 1][col] != 'X' || place[row][col - 1] != 'X') return 0;
                    }
                }
            }
        }
    }
    return 1;
}

vector<int> solution(vector<vector<string>> places) {
    vector<int> answer;
    const int N = 5;

    for (int num = 0; num < N; ++num) answer.push_back(check(places[num], N));

    return answer;
}

int main() {
    vector<vector<string>> places = {
        {"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"},
        {"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"},
        {"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"},
        {"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"},
        {"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}
    };

    solution(places);
    return 0;
}