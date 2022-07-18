package backjun.g5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P17609 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());

        int T = Integer.parseInt(st.nextToken());
        while (T-- > 0) {
            st = new StringTokenizer(in.readLine());
            String s = st.nextToken();
            System.out.println(solve(s, 0, s.length()-1, 0));
        }
    }

    static int solve(String s, int leftpos, int rightpos, int cnt) {
        if (cnt == 2) {
            return 2;
        }
        int ret = cnt;
        while (leftpos < rightpos) {
            if (s.charAt(leftpos) != s.charAt(rightpos)) {
                int leftvalue = solve(s, leftpos + 1, rightpos, cnt + 1);
                int rightvalue = solve(s, leftpos, rightpos - 1, cnt + 1);
                ret = Math.min(leftvalue, rightvalue);
                break;
            }
            leftpos++;
            rightpos--;
        }
        return ret;
    }
}
