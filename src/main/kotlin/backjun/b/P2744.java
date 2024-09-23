package backjun.b;

import java.util.Scanner;

public class P2744 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        StringBuilder answer = new StringBuilder();
        for (int i=0 ; i<str.length() ; i++) {
            char ch  = str.charAt(i);

            if (ch >= 'a' && ch <='z'){
                answer.append(String.valueOf(ch).toUpperCase());
            } else if (ch >= 'A' && ch <= 'Z') {
                answer.append(String.valueOf(ch).toLowerCase());
            }
        }

        System.out.println(answer);
    }
}
