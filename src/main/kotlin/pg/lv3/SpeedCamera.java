package pg.lv3;

import java.util.Arrays;
import java.util.Comparator;

public class SpeedCamera {
    public int solution(int[][] routes) {

        Arrays.sort(routes, Comparator.comparingInt(a -> a[1]));

        int lastCamera = Integer.MIN_VALUE;
        int count = 0;

        for (int[] route : routes) {
            int entry = route[0];
            int exit = route[1];

            if (entry > lastCamera) {
                count++;
                lastCamera = exit;
            }
        }
        return count;
    }
}
