package backjun.s4;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Scanner;

/**
 * S4 베스트셀러
 */
public class P1302 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); // 1<= n <= 1000

        // 가장 많이 팔린 책의 제목을 출력
        HashMap<String, Integer> hm = new HashMap<>();
        while (n-- > 0) {
            String bookName = sc.next(); // 길이 50자 이하 && 소문자
            if (hm.containsKey(bookName)) {
                int count = hm.get(bookName) + 1;
                hm.put(bookName, count);
            } else {
                hm.put(bookName, 1);
            }
        }

        int max = -1;
        ArrayList<String> list = new ArrayList<>();

        for (String key : hm.keySet()) {
            int count = hm.get(key);

            if (count > max) {
                list.clear();
                max = count;
                list.add(key);
            } else if (count == max){
                list.add(key);
            }
        }

        list.sort(Comparator.naturalOrder());
        System.out.println(list.get(0));

        sc.close();
    }

}
