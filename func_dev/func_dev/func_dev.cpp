#include <string>
#include <vector>

using namespace std;

vector<int> solution(vector<int> progresses, vector<int> speeds) {
    vector<int> answer;
    vector<int> days;
    const int COMPLETE = 100;

    for (int idx = 0; idx < speeds.size(); ++idx) {
        int day = (COMPLETE - progresses[idx]) / speeds[idx];
        int mod = (COMPLETE - progresses[idx]) % speeds[idx];
        if (mod != 0) ++day;
        days.push_back(day);
    }

    int c_idx = 0,next_idx = 1;
    while (c_idx < days.size()) {
        if (next_idx == days.size()) {
            answer.push_back(next_idx - c_idx);
            c_idx = next_idx++;
        }
        else if (days[c_idx] >= days[next_idx]) ++next_idx;
        else {
            answer.push_back(next_idx - c_idx);
            c_idx = next_idx++;
        }
    }

    return answer;
}

int main() {
    vector<int> progresses = { 96, 94 }, speeds = { 3, 3 };
    solution(progresses, speeds);
    return 0;
}