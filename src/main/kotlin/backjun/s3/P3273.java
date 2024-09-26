package backjun.s3;

import java.util.Scanner;

/**
 * S3 두 수의 합
 */
public class P3273 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        // 1<=n<=100000

        int [] count = new int[1000000 + 1];
        int [] arr = new int[n];
        int answer = 0;


        for (int i = 0 ; i<n ; i++) {
            int num = sc.nextInt();
            arr[i]= num;
            count[num]++;
        }
        int sum = sc.nextInt();

        for (int i=0 ; i<n ; i++) {
            int diff = sum - arr[i];
            if (diff <= 1000000 && arr[i] < diff) {
                answer += count[diff];
            }
        }

        System.out.println(answer);
    }
}
