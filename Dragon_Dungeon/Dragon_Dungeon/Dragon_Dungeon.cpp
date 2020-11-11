#include <iostream>
#include <queue>
#include <cmath>

using namespace std;

long long zero = 0;

void sol(long long N, long long Ha, queue<long long> dungeon) {
	long long t, a, h;
	long long cur_d = 0, max_h = 0;
	//O(n)Ǯ��
	for (int i = 0; i < N; ++i) {
		//�ش� ���� ���� ����
		t = dungeon.front();//�� ����(����, ����)
		dungeon.pop();
		a = dungeon.front();//����, ������ ���ݷ� ��ġ
		dungeon.pop();
		h = dungeon.front();//����, ������ ü�� ��ġ
		dungeon.pop();

		if (t == 1) {
			if(h%Ha == 0) cur_d += a * ((h/Ha) - 1);//����濡�� ������ ������ ���
			else cur_d += a * (h / Ha);//����濡�� ������ ������ ���
			if (cur_d > max_h) max_h = cur_d;//�������� �ͼ� ������ �������� ������ ������ ���������� Ŭ �� �׸�ŭ�� ü���� �ʿ��ϹǷ� ������ �ٲ�
		}

		else {
			Ha += a;//���ݷ� ���
			cur_d = max(cur_d - h, zero);//�ִ�ü���� �Ѿ� ȸ���� �ȵǹǷ� ������ ������ ���� ü���� ���� ȸ�� �ɰ�� ���� �������� -�� �ǹǷ� 0�� ���� ������ �߿� ū�� ����
		}
	}
	cout << max_h + 1;//�ִ�ü�� ���� �� �´� �������� �����Ƿ� �װź��� 1�� ���ƾ� ��簡 ���� �����Ƿ� 1�� ���Ͽ� ���
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