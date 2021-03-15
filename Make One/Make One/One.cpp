#include <iostream>
#include <vector>
#include <queue>

using namespace std;

vector<int> Dp(1000001, 0);

int main() {
	int X;
	cin >> X;
	Dp[2] = 1;
	Dp[3] = 1;
	for (int Index = 4; Index <= X; ++Index) {

		if ((Index % 3) == 0) Dp[Index] = Dp[Index / 3] + 1;

		if ((Index % 2) == 0) {
			if(Dp[Index] == 0 || Dp[Index] > (Dp[Index / 2] + 1)) Dp[Index] = Dp[Index / 2] + 1;
		}

		if (Dp[Index] == 0 || Dp[Index] > (Dp[Index - 1] + 1)) {
			Dp[Index] = Dp[Index - 1] + 1;
		}
	}

	cout << Dp[X];
}