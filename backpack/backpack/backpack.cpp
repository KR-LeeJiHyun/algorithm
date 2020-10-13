#include <iostream>
#include <vector>

using namespace std;

vector<vector<int>> dp;

struct product {
	int w;
	int v;
};

void sol(int N, int K, vector<product> products) {
	for (int i = 0; i <= N; ++i) {
		dp[i][0] = 0;
	}

	for (int w = 0; w <= K; ++w) {
		dp[0][w] = 0;
	}

	for (int i = 1; i <= N; ++i) {
		for (int w = 1; w <= K; ++w) {
			if (w >= products[i-1].w) {
				if ((products[i-1].v + dp[i - 1][w - products[i-1].w]) > dp[i - 1][w]) dp[i][w] = products[i-1].v + dp[i - 1][w - products[i-1].w];
				else dp[i][w] = dp[i - 1][w];
			}
			else dp[i][w] = dp[i - 1][w];
		}
	}

	cout << dp[N][K];
}

int main() {
	int N, K, w, v;
	product pro;
	vector<product> products;
	
	cin >> N >> K;
	dp.resize(N + 1);
	for (int i = 0; i < N; ++i) {
		dp[i].resize(K + 1);
		cin >> w >> v;
		pro.w = w;
		pro.v = v;
		products.push_back(pro);
	}
	dp[N].resize(K + 1);

	sol(N, K, products);

	return 0;
}