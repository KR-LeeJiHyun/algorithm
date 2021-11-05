#include <string>
#include <vector>
#include <queue>
#include <algorithm>
#include <functional>

using namespace std;

int solution(vector<int> scoville, int K) {
    int answer = 0;
    priority_queue<int, vector<int>, greater<int>> pq;

    for (int idx = 0; idx < scoville.size(); ++idx) pq.push(scoville[idx]);

    
    while (pq.size() != 1 && pq.top() < K) {
        int first = pq.top();
        pq.pop();
        int second = pq.top();
        pq.pop();
        pq.push(first + second * 2);
        ++answer;
    }

    if (pq.top() < K) answer = -1;

    return answer;
}

int main() {
    return 0;
}