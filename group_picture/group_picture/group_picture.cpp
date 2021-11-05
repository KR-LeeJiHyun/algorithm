#include <string>
#include <vector>
#include <cmath>

using namespace std;

// 전역 변수를 정의할 경우 함수 내에 초기화 코드를 꼭 작성해주세요.
int solution(int n, vector<string> data) {
    int answer = 0;
    const string peoples = "ACFJMNRT";
    int people_len = peoples.size();
    vector<bool> visited(people_len);

    for (int idx_1 = 0; idx_1 < people_len; ++idx_1) {
        string picture = "";
        picture += peoples[idx_1];
        for (int idx_2 = 0; idx_2 < people_len; ++idx_2) {
            if (idx_1 != idx_2) {
                picture += peoples[idx_2];
                for (int idx_3 = 0; idx_3 < people_len; ++idx_3) {
                    if (idx_1 != idx_3 && idx_2 != idx_3) {
                        picture += peoples[idx_3];
                        for (int idx_4 = 0; idx_4 < people_len; ++idx_4) {
                            if (idx_1 != idx_4 && idx_2 != idx_4 && idx_3 != idx_4) {
                                picture += peoples[idx_4];
                                for (int idx_5 = 0; idx_5 < people_len; ++idx_5) {
                                    if (idx_1 != idx_5 && idx_2 != idx_5 && idx_3 != idx_5 && idx_4 != idx_5) {
                                        picture += peoples[idx_5];
                                        for (int idx_6 = 0; idx_6 < people_len; ++idx_6) {
                                            if (idx_1 != idx_6 && idx_2 != idx_6 && idx_3 != idx_6 && idx_4 != idx_6 && idx_5 != idx_6) {
                                                picture += peoples[idx_6];
                                                for (int idx_7 = 0; idx_7 < people_len; ++idx_7) {
                                                    if (idx_1 != idx_7 && idx_2 != idx_7 && idx_3 != idx_7 && idx_4 != idx_7 && idx_5 != idx_7 && idx_5 != idx_7 && idx_6 != idx_7) {
                                                        picture += peoples[idx_7];
                                                        for (int idx_8 = 0; idx_8 < people_len; ++idx_8) {
                                                            if (idx_1 != idx_8 && idx_2 != idx_8 && idx_3 != idx_8 && idx_4 != idx_8 && idx_5 != idx_8 && idx_5 != idx_8 && idx_6 != idx_8 && idx_7 != idx_8) {
                                                                picture += peoples[idx_8];
                                                                bool check = true;
                                                                for (int idx = 0; idx < n; ++idx) {
                                                                    string tmp_data = data[idx];
                                                                    char first = tmp_data[0], second = tmp_data[2], op = tmp_data[3];
                                                                    int dis = tmp_data[4] - '0' , first_pos, second_pos;
                                                                    first_pos = picture.find(first);
                                                                    second_pos = picture.find(second);
                                                                    if (op == '<') { 
                                                                        if (!(abs(first_pos - second_pos) - 1 < dis)) {
                                                                            check = false;
                                                                            break;
                                                                        }
                                                                    }
                                                                    else if (op == '>') {
                                                                        if (!(abs(first_pos - second_pos) - 1 > dis)) {
                                                                            check = false;
                                                                            break;
                                                                        }
                                                                    }
                                                                    else if (op == '=') {
                                                                        if (abs(first_pos - second_pos) - 1 != dis) {
                                                                            check = false;
                                                                            break;
                                                                        }
                                                                    }
                                                                }
                                                                if (check) ++answer;
                                                                picture.erase(picture.end() - 1);
                                                            }
                                                        }
                                                        picture.erase(picture.end() - 1);
                                                    }
                                                }
                                                picture.erase(picture.end() - 1);
                                            }
                                        }
                                        picture.erase(picture.end() - 1);
                                    }
                                }
                                picture.erase(picture.end() - 1);
                            }
                        }
                        picture.erase(picture.end() - 1);
                    }
                }
                picture.erase(picture.end() - 1);
            }
        }
        picture.erase(picture.end() - 1);
    }
    return answer;
}

int main() {
    int n = 2;
    vector<string> data = { "N~F=0", "R~T>2" };

    solution(n, data);
    return 0;
}