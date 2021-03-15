#include <iostream>
#include <vector>

using namespace std;

int rain(int H, int W, vector<int> blocks) {
	int result = 0;
	int height, left, right;

	for (int index = 1; index < W - 1; ++index) {
		left = 0;
		right = 0;
		for (int left_idx = index - 1; left_idx >= 0; --left_idx) {
			if (left < blocks[left_idx]) left = blocks[left_idx];
		}
		for (int right_idx = index + 1; right_idx < W; ++right_idx) {
			if (right < blocks[right_idx]) right = blocks[right_idx];
		}

		if (left < right) height = left;
		else height = right;

		if (height > blocks[index]) result += height - blocks[index];
	}

	return result;
}

int main() {
	int W, H, block;
	vector<int> blocks;

	cin >> H >> W;

	for (int index = 0; index < W; ++index) {
		cin >> block;
		blocks.push_back(block);
	}

	cout << rain(H, W, blocks);

	return 0;
}