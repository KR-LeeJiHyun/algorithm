#include <iostream>
#include<string>
#include<vector>;

using namespace std;

int solution(string s)
{
    int answer = -1;
    vector<char> couple;
    couple.push_back(s[0]);
    for (int idx = 1; idx < s.size(); ++idx) {
        if (!couple.empty() && couple.back() == s[idx]) couple.pop_back();
        else couple.push_back(s[idx]);
    }

    if (couple.empty()) answer = 1;
    else answer = 0;

   return answer;
}

int main() {
    string s = "baabaa";
    solution(s);
    return 0;
}