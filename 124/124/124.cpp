#include <string>
#include <vector>

using namespace std;

string solution(int n) {
    string answer = "";
    vector<int> nums = { 4, 1, 2 };

    while (n != 0) {
        int mod = n % 3;
        answer = to_string(nums[mod]) + answer;
        
        if (mod != 0) n = n / 3;
        else n = n / 3 - 1;
    }

    return answer;
}

int main() {
    int n = 1234;
    solution(n);
    return 0;
}