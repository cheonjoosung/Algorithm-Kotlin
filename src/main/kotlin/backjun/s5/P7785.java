package backjun.s5;

import java.util.*;

/**
 * S5 회사에 있는 사람
 */
public class P7785 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); // 2 <= n <= 1,000,000
        HashSet<String> hs = new HashSet<>();
        while (n-- > 0) {
            String name = sc.next();
            String cmd = sc.next();

            if (cmd.equals("enter")) {
                hs.add(name);
            } else {
                hs.remove(name);
            }
        }

        String [] arr = new String[hs.size()];
        hs.toArray(arr);
        Arrays.sort(arr, Comparator.reverseOrder());
        for (String s : arr) {
            System.out.println(s);
        }

        sc.close();
    }

}
