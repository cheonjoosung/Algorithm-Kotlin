package backjun.b;

import java.util.Scanner;

/**
 * B3 소금폭탄
 */
public class P13223 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String currentTime = sc.next();
        String saltTime = sc.next();

        // 두 시간의 차이를 구하라
        int cur = timeToInt(currentTime);
        int salt = timeToInt(saltTime);

        int diff = salt - cur;
        if (diff <= 0) {
            diff += 3600*24;
        }

        int h = (diff / 3600);
        diff = diff%3600;
        int m = diff/60;
        int s = diff%60;
        String answer = String.format("%02d:%02d:%02d", h, m, s);

        System.out.println(answer);
    }

    private static int timeToInt(String timeString) {
        String[] token = timeString.split(":");

        int h = (Integer.parseInt(token[0])) * 60 * 60;
        int m = (Integer.parseInt(token[1])) * 60;
        int s = (Integer.parseInt(token[2]));

        return h + m + s;
    }
}
