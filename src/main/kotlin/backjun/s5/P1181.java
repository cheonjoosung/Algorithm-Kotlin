package backjun.s5;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * S5 단어 정렬
 */
public class P1181 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        ArrayList<String> list = new ArrayList<>();

        while (n-- > 0) {
            String s = sc.next();
            list.add(s);
        }

        /**
         * 1. 길이가 짧은순 정렬
         * 2. 길이가 같다면 알파벳순 정렬
         */
        list.sort((String o1, String o2) -> {
            if (o1.length() != o2.length()) {
                return Integer.compare(o1.length(), o2.length());
            } else {
                return o1.compareTo(o2);
            }
        });

        // 중복 제거 및 출력
        String previous = "";
        for (String item : list) {
            if (!item.equals(previous)) {
                System.out.println(item);
                previous = item;
            }
        }

        sc.close();
    }

}
