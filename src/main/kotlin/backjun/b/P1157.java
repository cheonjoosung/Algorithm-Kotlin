package backjun.b;

import java.util.Arrays;
import java.util.Scanner;

/**
 * B1 단어공부
 */
public class P1157 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        str = str.toLowerCase();

        int [] arr = new int[26];
        for (int i=0 ; i<str.length() ; i++) {
            arr[str.charAt(i) - 'a']++;
        }

        int maxValue = Arrays.stream(arr).max().getAsInt();
        int count = 0;
        int idx = -1;

        for (int i=0 ; i<arr.length ; i++) {
            if (maxValue == arr[i]) {
                idx = i;
                count++;
            }
        }

        if (count == 1) {
            char ch = (char) (idx + 'a');
            String answer = String.valueOf(ch).toUpperCase();
            System.out.println(answer);
        } else {
            System.out.println("?");
        }
    }
}
