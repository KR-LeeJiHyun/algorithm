#include <string>
#include <vector>
#include <algorithm>
#include <map>

using namespace std;

map<string, int> dfs(map<string, int> dic, string order, int c_idx, string comb) {
    for (int idx = c_idx; idx < order.size(); ++idx) {
        string tmp = comb;
        tmp += order[idx];
        if (tmp.size() > 1) {
            ++dic[tmp];
        }
        dic = dfs(dic, order, idx + 1, tmp);
    }

    return dic;
}

vector<string> solution(vector<string> orders, vector<int> course) {
    vector<string> answer, result(course[course.size() - 1] + 1);
    vector<int> max_course(course[course.size() - 1] + 1, 2);
    map<string, int> dic;

    for (int idx = 0; idx < orders.size(); ++idx) {
        sort(orders[idx].begin(), orders[idx].end());
        dic = dfs(dic, orders[idx], 0, ""); 
    }

    for (auto iter = dic.begin(); iter != dic.end(); ++iter) {
        string menu = iter->first;
        int order_num = iter->second;
        for (int idx = 0; idx < course.size(); ++idx) {
            if (menu.size() == course[idx] && max_course[course[idx]] <= order_num) {
                if (max_course[course[idx]] < order_num) {
                    max_course[course[idx]] = order_num;
                    result[course[idx]] = menu;
                }
                else result[course[idx]] += menu;
            }
        }
    }

    for (int idx = 0; idx < course.size(); ++idx) {
        string menu = result[course[idx]];
        while (!menu.empty()) {
            answer.push_back(menu.substr(0, course[idx]));
            menu.erase(0, course[idx]);
        }
    }

    sort(answer.begin(), answer.end());

    return answer;
}

int main() {
    vector<string> orders = { "XYZ", "XWY", "WXA" };
    vector<int> course = { 2,3,4 };

    solution(orders, course);
    return 0;
}