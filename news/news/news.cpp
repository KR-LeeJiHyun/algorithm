#include <string>
#include <map>

using namespace std;

int solution(string str1, string str2) {
    const int MUL = 65536;
    int answer = 0, uni = 0;
    map<string, int> m1, m2;

    for (int idx = 0; idx < str1.length() - 1; ++idx) {
        if(idx == 0) str1[idx] = toupper(str1[idx]);
        str1[idx + 1] = toupper(str1[idx + 1]);

        if (str1[idx] >= 'A' && str1[idx] <= 'Z' && str1[idx + 1] >= 'A' && str1[idx + 1] <= 'Z') {
            string tmp = "";
            tmp += str1[idx];
            tmp += str1[idx + 1];
            ++m1[tmp];
            ++uni;
        }
    }

    for (int idx = 0; idx < str2.length() - 1; ++idx) {
        if (idx == 0) str2[idx] = toupper(str2[idx]);
        str2[idx + 1] = toupper(str2[idx + 1]);
        
        if (str2[idx] >= 'A' && str2[idx] <= 'Z' && str2[idx + 1] >= 'A' && str2[idx + 1] <= 'Z') {
            string tmp = "";
            tmp += str2[idx];
            tmp += str2[idx + 1];
            ++m2[tmp];
            ++uni;
        }
    }

    int inter = 0;

    for (auto iter = m1.begin(); iter != m1.end(); ++iter) {
        string key = iter->first;
        int value1 = iter->second, value2 = m2[key];
        if (value1 != 0 && value2 != 0) {
            if (value1 < value2) inter += value1;
            else inter += value2;
        }
    }

    if (uni == 0) answer = MUL;
    else answer = inter * MUL / (uni - inter);

    return answer;
}

int main() {
    string str1 = "E=M*C^2", str2 = "e=m*c^2";
    solution(str1, str2);
    return 0;
}