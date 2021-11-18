#include <string>
#include <vector>

using namespace std;

vector<int> solution(string s) {
    vector<int> answer;
    vector<vector<int>> result;
    vector<bool> contain(100001);

    s.erase(0, 1);
    s.erase(s.size() - 1, 1);

    while (!s.empty()) {
        int pos = s.find('}');
        string str = s.substr(1, pos - 1);
        s.erase(0, pos + 2);
        vector<int> sum;
        while (!str.empty()) {
            pos = str.find(',');
            int tmp = 0;
            if (pos != string::npos) {
                tmp = stoi(str.substr(0, pos));
                str.erase(0, pos + 1);
            }
            else {
                tmp = stoi(str);
                str.erase(0);
            }
            sum.push_back(tmp);
        }
        if (result.size() <= sum.size()) result.resize(sum.size() + 1);
        result[sum.size()] = sum;
    }

    for (int row = 1; row < result.size(); ++row) {
        for (int col = 0; col < result[row].size(); ++col) {
            if (!contain[result[row][col]]) {
                answer.push_back(result[row][col]);
                contain[result[row][col]] = true;
            }
        }
    }

    return answer;
}

int main() {
    string s = "{{20,111},{111}}";
    solution(s);
    return 0;
}