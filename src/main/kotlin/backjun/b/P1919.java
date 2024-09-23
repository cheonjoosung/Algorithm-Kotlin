package backjun.b;

import java.util.Scanner;

public class P1919 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        String b = sc.next();

        // 문자열의 카운트를 배열로 저장
        int [] countA = new int[26];
        int [] countB = new int[26];

        for (int i=0 ; i<a.length() ; i++) {
            countA[a.charAt(i) - 'a']++;
        }

        for (int i=0 ; i<b.length() ; i++) {
            countB[b.charAt(i) - 'a']++;
        }

        int answer = 0;
        for (int i=0 ; i<26 ; i++) {
            answer += Math.abs(countA[i] - countB[i]);
        }

        System.out.println(answer);
    }
}
