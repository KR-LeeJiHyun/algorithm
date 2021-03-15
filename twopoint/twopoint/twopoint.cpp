#include <iostream>
#include <vector>

using namespace std;

int main(){
	int N, M, Number, Count = 0;
	vector<int> Array;

	cin >> N >> M;
	
	for (int Index = 0; Index < N; ++Index) {
		cin >> Number;
		Array.push_back(Number);
	}

	for (int Start = 0; Start < N; ++Start) {
		int Sum = Array[Start];
		if (Sum < M) {
			for (int End = Start + 1; End < N; ++End) {
				Sum += Array[End];
				if (Sum >= M) break;
			}
		}

		if (Sum == M) ++Count;
	}

	cout << Count;

	return 0;
}