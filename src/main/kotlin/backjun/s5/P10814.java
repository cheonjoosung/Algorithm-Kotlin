package backjun.s5;

import org.jetbrains.annotations.NotNull;

import java.util.*;

/**
 * S5 나이순 정렬
 */
public class P10814 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        List<Memeber> list = new ArrayList<>();

        int idx = 0;
        while (n-- > 0) {
            idx++;
            int age = sc.nextInt();
            String name = sc.next();
            list.add(new Memeber(idx, age, name));
        }

        Collections.sort(list);

        for (Memeber m : list) {
            System.out.println(m.age + " " + m.name);
        }


        sc.close();
    }

    static class Memeber implements Comparable<Memeber> {
        int idx;
        int age;
        String name;

        Memeber(int idx, int age, String name) {
            this.idx = idx;
            this.age = age;
            this.name = name;
        }

        @Override
        public int compareTo(Memeber other) {
            if (this.age != other.age) {
                return Integer.compare(this.age, other.age);  // 나이 순으로 정렬
            } else {
                return Integer.compare(this.idx, other.idx);  // 가입 순서로 정렬
            }
        }
    }
}
