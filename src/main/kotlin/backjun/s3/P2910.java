package backjun.s3;

import java.util.*;

/**
 * S3 빈도정렬
 */
public class P2910 {
    static class Number {
        int value;
        int frequency;
        int firstIndex;

        public Number(int value, int frequency, int firstIndex) {
            this.value = value;
            this.frequency = frequency;
            this.firstIndex = firstIndex;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int C = sc.nextInt();

        Map<Integer, Number> frequencyMap = new HashMap<>();
        List<Number> numberList = new ArrayList<>();

        // 빈도 계산 및 순서 기록
        for (int i = 0; i < N; i++) {
            int num = sc.nextInt();
            if (frequencyMap.containsKey(num)) {
                frequencyMap.get(num).frequency++;
            } else {
                Number number = new Number(num, 1, i);
                frequencyMap.put(num, number);
                numberList.add(number);
            }
        }

        // 빈도에 따라 정렬
        Collections.sort(numberList, (Number n1, Number n2) -> {
            if (n1.frequency != n2.frequency) {
                return Integer.compare(n2.frequency, n1.frequency); // 빈도 내림차순
            } else {
                return Integer.compare(n1.firstIndex, n2.firstIndex); // 첫 등장 순서 오름차순
            }
        });

        // 결과 출력
        StringBuilder sb = new StringBuilder();
        for (Number number : numberList) {
            for (int i = 0; i < number.frequency; i++) {
                sb.append(number.value).append(" ");
            }
        }
        System.out.println(sb.toString().trim());
        sc.close();
    }
}