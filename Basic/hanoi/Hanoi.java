package Basic.hanoi;

import java.util.Scanner;

public class Hanoi {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        move(n, 1, 2, 3);
    }

    static void move(int cnt, int from, int temp, int to) {
        if (cnt == 0) return;

        // n-1개의 원판 임시 기둥으로 이동
        move(cnt - 1, from, to, temp);

        System.out.println(from + "기둥 -> " + to + "기둥");

        // n-1개의 임시 기둥에 있는 원판을 타겟 기둥으로 이동
        move(cnt - 1, temp, from, to);
    }
}
