#include <iostream>

using namespace std;

long long gcd(int w, int h) {
	long long a = 0;
	while (h != 0){
		a = w % h;
		w = h;
		h = a;
	}
	return w;
}

long long solution(int w, int h) {
	long long answer = 1, area;
	long long W = w, H = h;
	area = W*H;
	long long g = gcd(w, h);
	answer = area - (w + h - g);
	return answer;
}

void main() {
	int w = 12, h = 8;
	cout << solution(w, h);
}