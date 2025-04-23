package pg.lv1;

public class BandageBind {

    public static int solution(int[] bandage, int health, int[][] attacks) {
        int t = bandage[0];  // 붕대 감기 시전 시간
        int x = bandage[1];  // 1초당 회복량
        int y = bandage[2];  // 성공 시 추가 회복량

        int maxHealth = health;
        int time = 0; // 현재 시간
        int healStack = 0; // 연속 성공 시간
        int idx = 0; // 공격 배열 인덱스

        for (int i = 0; i <= attacks[attacks.length - 1][0]; i++) {
            if (idx < attacks.length && i == attacks[idx][0]) {
                // 공격 시점
                health -= attacks[idx][1];
                if (health <= 0) return -1;
                healStack = 0; // 붕대 초기화
                idx++;
            } else {
                // 회복 시점
                health += x;
                healStack++;
                if (healStack == t) {
                    health += y;
                    healStack = 0;
                }
                health = Math.min(health, maxHealth);
            }
        }

        return health;
    }

    // 테스트용 main 함수
    public static void main(String[] args) {
        int[] bandage = {5, 1, 5};
        int health = 30;
        int[][] attacks = {{2, 10}, {9, 15}, {10, 5}, {11, 5}};
        System.out.println(solution(bandage, health, attacks)); // 결과 출력
    }
}
