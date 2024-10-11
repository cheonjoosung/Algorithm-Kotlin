package backjun.s3;

import java.util.*;

/**
 * S3 좌표압축
 */
public class P18870 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 입력
        int N = sc.nextInt();
        int[] original = new int[N];
        int[] sortedUnique = new int[N];

        for (int i = 0; i < N; i++) {
            original[i] = sc.nextInt();
            sortedUnique[i] = original[i];
        }

        // 배열을 정렬하고, 중복을 제거하여 압축할 좌표 목록을 만듬
        Arrays.sort(sortedUnique);
        Map<Integer, Integer> compressedMap = new HashMap<>();
        int compressIndex = 0;

        for (int i = 0; i < N; i++) {
            if (!compressedMap.containsKey(sortedUnique[i])) {
                compressedMap.put(sortedUnique[i], compressIndex++);
            }
        }

        // 원래 좌표를 압축된 좌표로 변환하여 출력
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(compressedMap.get(original[i])).append(" ");
        }

        System.out.println(sb.toString().trim());
        sc.close();
    }
}