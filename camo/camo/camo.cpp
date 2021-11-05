#include <string>
#include <vector>
#include <map>

using namespace std;

int solution(vector<vector<string>> clothes) {
    int answer = 1;
    map<string, int> kinds;

    for (int idx = 0; idx < clothes.size(); ++idx) {
        kinds[clothes[idx][1]] += 1;
    }

    for (auto iter = kinds.begin(); iter != kinds.end(); ++iter) {
        answer *= (iter->second + 1);
    }

    return answer - 1;
}

int main() {
    vector<vector<string>> clothes = {{"yellowhat", "headgear"}, {"bluesunglasses", "eyewear"}, {"green_turban", "headgear"}};
    solution(clothes);
    return 0;
}

