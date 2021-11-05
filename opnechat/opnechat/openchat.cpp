#include <string>
#include <vector>
#include <iostream>
#include <map>

using namespace std;

vector<string> solution(vector<string> record) {
    const string ENTER = "Enter", LEAVE = "Leave", CHANGE = "Change";
    vector<string> answer, cmd_list, id_list;
    map<string, string> nick_map;

    for (int idx = 0; idx < record.size(); ++idx) {
        string cmd, id, nick, tmp_record = record[idx];
        int pos = tmp_record.find(" ");
        cmd = tmp_record.substr(0, pos);
        tmp_record.erase(0, pos + 1);
        pos = tmp_record.find(" ");
        id = tmp_record.substr(0, pos);
        tmp_record.erase(0, pos + 1);
        nick = tmp_record;

        if (cmd.compare(CHANGE) != 0) {
            if (cmd.compare(ENTER) == 0) {
                cmd_list.push_back("´ÔÀÌ µé¾î¿Ô½À´Ï´Ù.");
                id_list.push_back(id);
                nick_map[id] = nick;
            }
            else {
                cmd_list.push_back("´ÔÀÌ ³ª°¬½À´Ï´Ù.");
                id_list.push_back(id);
            }
        }
        else {
            nick_map[id] = nick;
            }
     }
    
    for (int idx = 0; idx < cmd_list.size(); ++idx) answer.push_back(nick_map[id_list[idx]] + cmd_list[idx]);

    return answer;
}

int main() {
    vector<string> record{ "Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan" };
    record = solution(record);
    for (int idx = 0; idx < record.size(); ++idx) {
        cout << record[idx] << "\n";
    }
    return 0;
}