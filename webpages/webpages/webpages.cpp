#include<iostream>
#include<vector>
#include<string>

using namespace std;

int main() {
	string input;
	vector<string> tags;
	vector<string> answer;

	while (true) {
		getline(cin, input);
		if (input != "#") {
			int index = input.find('<');
			while (index != string::npos) {
				int end = input.find('>');
				string temp = input.substr(index, end + 1 - index);
				input.erase(index, end + 1 - index);
				//a tag
				if(temp.find("<a") != string::npos) tags.push_back("a");

				//br tag
				else if (temp.compare("<br />") == 0){}

				//<>open tag
				else if (temp.find('/') == string::npos) {
					temp = temp.erase(0, 1);
					temp = temp.erase(temp.length() - 1, 1);
					tags.push_back(temp);
				}

				//</>close tag
				else {
					int tag_size = tags.size();
					if (tag_size != 0) {
						temp = temp.erase(0, 2);
						temp = temp.erase(temp.length() - 1, 1);
						if (temp.compare(tags[tag_size - 1]) == 0) tags.pop_back();
					}
					else {
						tags.push_back(" ");
						break;
					}
				}
				index = input.find('<');
			}
			if (tags.size() == 0) answer.push_back("legal");
			else answer.push_back("illegal");
			tags.clear();
		}
		else break;
	}
	for (int i = 0; i < answer.size(); ++i) cout << answer[i] << endl;
	return 0;
}