#include <string>
#include <vector>
#include <queue>

using namespace std;

int solution(vector<int> numbers, int target) {
    int answer = 0;
    queue<int> q;
    q.push(numbers[0]);
    q.push(0);
    q.push(-numbers[0]);
    q.push(0);

    while (!q.empty()) {
        int num = q.front();
        q.pop();
        int idx = q.front();
        q.pop();

        if (idx < numbers.size() - 1) {
            q.push(num + numbers[idx + 1]);
            q.push(idx + 1);
            q.push(num - numbers[idx + 1]);
            q.push(idx + 1);
        }
        else {
            if (num == target) ++answer;
        }
    }

    return answer;
}

int main() {
    vector<int> numbers = { 1, 1, 1, 1, 1 };
    int target = 3;
    solution(numbers, target);
    return 0;
}