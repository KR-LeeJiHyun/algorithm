#include <string>
#include <vector>

using namespace std;

bool isright(string u) {
    vector<char> stack;

    for (int idx = 0; idx < u.size(); ++idx) {
        if (!stack.empty()) {
            if (stack.back() == '(' && u[idx] == ')') stack.pop_back();
            else stack.push_back(u[idx]);
        }
        else stack.push_back(u[idx]);
    }

    if (stack.empty()) return true;
    else return false;
}

string convert(string u) {
    string tmp = u.substr(1, u.size() - 2), result = "";
    vector<char> conv = { ')', '(' };
    for (int idx = 0; idx < tmp.size(); ++idx) {
        result += conv[tmp[idx] - '('];
    }
    return result;
}

string solution(string p) {
    if (p.empty()) return p;

    string answer = "", u = "", v = "";
    
    int f_p = 0, s_p = 0;

    for (int idx = 0; idx < p.size(); ++idx) {
        if (f_p == s_p && f_p != 0) {
            v = p.substr(idx);
            break; 
        }
        u += p[idx];
        if (p[idx] == '(') ++f_p;
        else ++s_p;
    }

    if (isright(u)) return u + solution(v);
    else return "(" + solution(v) + ")" + convert(u);
}

int main() {
    string p = "()))((()";
    string answer = solution(p);
    return 0;
}