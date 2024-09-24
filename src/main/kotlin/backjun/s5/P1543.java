package backjun.s5;

import java.util.Scanner;

/**
 * S5 문서 검색
 */
public class P1543 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 입력 받기
        String document = scanner.nextLine();
        String word = scanner.nextLine();

        int docLength = document.length();
        int wordLength = word.length();
        int count = 0;
        int index = 0;

        // 문서를 검색하면서 단어가 발견되면 그 위치 이후부터 다시 검색
        while (index <= docLength - wordLength) {
            // 현재 위치에서 단어를 찾기
            if (document.substring(index, index + wordLength).equals(word)) {
                count++;  // 단어를 찾으면 카운트 증가
                index += wordLength;  // 중복되지 않기 위해 단어 길이만큼 인덱스 이동
            } else {
                index++;  // 단어가 없으면 한 칸씩 이동
            }
        }

        System.out.println(count);  // 결과 출력

        /* 길이로 풀기
            String newDoc = document.replace(word,"");
            System.out.println((document.length()-newDoc.length())/word.length());
         */
        scanner.close();
    }
}
