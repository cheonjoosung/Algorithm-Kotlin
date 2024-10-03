package backjun.s3;

import java.util.*;

/**
 * S3 ALPS식 투표
 */

public class P2817 {
    static class Staff {
        String name;
        int votes;
        double[] scores = new double[14]; // 14개의 점수
        int chips = 0; // 받을 칩의 개수

        Staff(String name, int votes) {
            this.name = name;
            this.votes = votes;
            for (int i = 0; i < 14; i++) {
                scores[i] = votes / (double)(i + 1); // 득표수를 1부터 14로 나눈 값 계산
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 참가자 수와 스태프 수 입력
        int X = sc.nextInt(); // 참가자 수
        int N = sc.nextInt(); // 스태프 수

        // 전체 참가자 수의 5% 구하기
        double threshold = X * 0.05;

        List<Staff> staffList = new ArrayList<>();

        // 스태프 정보 입력
        for (int i = 0; i < N; i++) {
            String name = sc.next();
            int votes = sc.nextInt();

            // 득표율이 5% 이상인 스태프만 후보에 포함
            if (votes >= threshold) {
                staffList.add(new Staff(name, votes));
            }
        }

        // 점수 집합 생성
        List<Double> scoreList = new ArrayList<>();
        for (Staff staff : staffList) {
            for (double score : staff.scores) {
                scoreList.add(score);
            }
        }

        // 점수 내림차순으로 정렬
        scoreList.sort(Collections.reverseOrder());

        // 칩 배분: 각 스태프에 대해 큰 점수부터 14개의 점수에 대해 칩을 배분
        for (int i = 0; i < 14 && i < scoreList.size(); i++) {
            double currentScore = scoreList.get(i);
            // 현재 점수를 가지고 있는 스태프에게 칩을 한 개 배분
            for (Staff staff : staffList) {
                for (int j = 0; j < 14; j++) {
                    if (staff.scores[j] == currentScore) {
                        staff.chips++;
                        // 해당 점수를 찾았으면 중복 배분 방지를 위해 더 이상 찾지 않음
                        break;
                    }
                }
            }
        }

        // 스태프 이름 사전순으로 정렬
        staffList.sort(Comparator.comparing(staff -> staff.name));

        // 결과 출력
        for (Staff staff : staffList) {
            System.out.println(staff.name + " " + staff.chips);
        }

        sc.close();
    }
}