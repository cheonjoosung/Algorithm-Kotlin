package backjun.s1;

import java.util.*;

/**
 * S1 회의실 배정
 */
public class P1931 {
    static class Meeting implements Comparable<Meeting> {
        int start;
        int end;

        public Meeting(int start, int end) {
            this.start = start;
            this.end = end;
        }

        // 종료 시간 기준 오름차순 정렬, 종료 시간이 같으면 시작 시간 기준 오름차순 정렬
        @Override
        public int compareTo(Meeting other) {
            if (this.end != other.end) {
                return Integer.compare(this.end, other.end);
            } else {
                return Integer.compare(this.start, other.start);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        List<Meeting> meetings = new ArrayList<>();

        // 회의 정보 입력
        for (int i = 0; i < N; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            meetings.add(new Meeting(start, end));
        }

        // 회의를 종료 시간 기준으로 정렬
        Collections.sort(meetings);

        int count = 0;
        int lastEndTime = 0;

        // 회의 선택
        for (Meeting meeting : meetings) {
            if (meeting.start >= lastEndTime) {
                lastEndTime = meeting.end;
                count++;
            }
        }

        // 최대 사용할 수 있는 회의 개수 출력
        System.out.println(count);
        sc.close();
    }
}