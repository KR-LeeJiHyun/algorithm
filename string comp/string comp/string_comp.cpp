#include <string>
#include <vector>
#include <iostream>

using namespace std;

int solution(string s) {
    int answer = 0;

    answer = s.size();

    for (int idx = 1; idx <= s.size() / 2; ++idx) {
        string tmp_s = s, comp_s = "", sub_str;
        int count = 0;
        while (!tmp_s.empty()) {
            ++count;
            sub_str = tmp_s.substr(0, idx);
            tmp_s.erase(0, idx);
            if (tmp_s.find(sub_str) != 0) { 
                if (count != 1) {
                    comp_s += to_string(count) + sub_str;
                    count = 0;
                }
                else {
                    comp_s += sub_str;
                    count = 0;
                }
            }
        }
        if (answer > comp_s.size()) {
            answer = comp_s.size();
        }
    }

    return answer;
}

int main() {
    string s = "xababcdcdababcdcd";

    cout << solution(s);

    return 0;
}