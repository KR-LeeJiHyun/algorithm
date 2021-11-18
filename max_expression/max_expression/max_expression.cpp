#include <string>
#include <vector>
#include <cmath>
#include <algorithm>

using namespace std;

long long cal(vector<char> op, string expression) {
    for (int idx = 0; idx < op.size(); ++idx) {
        char tmp_op = op[idx];
        int pos = expression.find(tmp_op);;
        while (pos != string::npos) {
            string str1 = "", str2 = "";
            int str1_idx, str2_idx;
            for (int idx = pos - 1; idx >= 0; --idx) {
                if (expression[idx] < '0' || expression[idx] > ':') break;
                if(expression[idx] != ':') str1 += expression[idx];
                else str1 += '-';
                str1_idx = idx;
            }
            
            reverse(str1.begin(), str1.end());

            for (int idx = pos + 1; idx < expression.size(); ++idx) {
                if (expression[idx] < '0' || expression[idx] > ':') break;
                if (expression[idx] != ':') str2 += expression[idx];
                else str2 += '-';
                str2_idx = idx;
            }
            long long first = stoll(str1), second = stoll(str2);
            auto iter = expression.begin();
            long long result;

            if (tmp_op == '+') {
                result = first + second;
                if (result >= 0) expression.replace(iter + str1_idx, iter + str2_idx + 1, to_string(result));
                else expression.replace(iter + str1_idx, iter + str2_idx + 1, ":" + to_string(abs(result)));
            }
            else if (tmp_op == '-') {
                result = first - second;
                if (result >= 0) expression.replace(iter + str1_idx, iter + str2_idx + 1, to_string(result));
                else expression.replace(iter + str1_idx, iter + str2_idx + 1, ":" + to_string(abs(result)));
            }
            else if (tmp_op == '*') {
                result = first * second;
                if (result >= 0) expression.replace(iter + str1_idx, iter + str2_idx + 1, to_string(result));
                else expression.replace(iter + str1_idx, iter + str2_idx + 1, ":" + to_string(abs(result)));
            }

            pos = expression.find(tmp_op);
        }
    }

    if (expression[0] == ':') expression.erase(0, 1);
    return stoll(expression);
}

long long solution(string expression) {
    long long answer = 0;
    const int OP_NUM = 3;
    vector<char> op = { '+', '-', '*' };
    for (int idx = 0; idx < OP_NUM; ++idx) {
        long long result = 0;
        vector<char> com_op;
        com_op.push_back(op[idx]);
        com_op.push_back(op[(idx + 1) % OP_NUM]);
        com_op.push_back(op[(idx + 2) % OP_NUM]);
        result = cal(com_op, expression);
        if (result > answer) answer = result;
        char tmp = com_op[1];
        com_op[1] = com_op[2];
        com_op[2] = tmp;
        result = cal(com_op, expression);
        if (result > answer) answer = result;
    }

    return answer;
}

int main() {
    string expression = "50*6-3*2";
    solution(expression);
    return 0;
}