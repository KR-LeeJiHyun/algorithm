#include <iostream>
#include <queue>
#include <cmath>

using namespace std;

long long zero = 0;

void sol(long long N, long long Ha, queue<long long> dungeon) {
	long long t, a, h;
	long long cur_d = 0, max_h = 0;
	//O(n)풀이
	for (int i = 0; i < N; ++i) {
		//해당 방의 정보 추출
		t = dungeon.front();//방 구분(몬스터, 포션)
		dungeon.pop();
		a = dungeon.front();//몬스터, 포션의 공격력 수치
		dungeon.pop();
		h = dungeon.front();//몬스터, 포션의 체력 수치
		dungeon.pop();

		if (t == 1) {
			if(h%Ha == 0) cur_d += a * ((h/Ha) - 1);//현재방에서 누적된 데미지 계산
			else cur_d += a * (h / Ha);//현재방에서 누적된 데미지 계산
			if (cur_d > max_h) max_h = cur_d;//현재방까지 와서 누적된 데미지가 이전에 누적된 데미지보다 클 시 그만큼의 체력이 필요하므로 답으로 바꿈
		}

		else {
			Ha += a;//공격력 상승
			cur_d = max(cur_d - h, zero);//최대체력을 넘어 회복이 안되므로 누적된 데미지 보다 체력이 많이 회복 될경우 현재 데미지가 -가 되므로 0과 현재 데미지 중에 큰값 선택
		}
	}
	cout << max_h + 1;//최대체력 계산시 딱 맞는 데미지만 들어오므로 그거보다 1이 높아야 용사가 죽지 않으므로 1을 더하여 출력
}

int main() {
	long long N, Ha, input;
	queue<long long> dungeon;

	cin >> N >> Ha;

	for (int i = 0; i < N * 3; ++i) {
		cin >> input;
		dungeon.push(input);
	}

	sol(N, Ha, dungeon);

	return 0;

}