package backjun.s5;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

/**
 * S5 나이순 정렬
 */
public class P10814 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        ArrayList<Memeber> list = new ArrayList<>();

        int idx = 0;
        while (n-- > 0) {
            idx++;
            int age = sc.nextInt();
            String name = sc.next();
            list.add(new Memeber(idx, age, name));
        }

        list.sort(new Comparator<Memeber>() {
            @Override
            public int compare(Memeber o1, Memeber o2) {
                if (o1.age < o2.age) return -1;
                else if (o1.age == o2.age) {
                    if (o1.idx < o2.idx) return -1;
                    else return 1;
                } else return 1;
            }
        });

        for (Memeber m : list) {
            System.out.println(m.age + " " + m.name);
        }


        sc.close();
    }

    static class Memeber {
        int idx;
        int age;
        String name;

        Memeber(int idx, int age, String name) {
            this.idx = idx;
            this.age = age;
            this.name = name;
        }
    }
}
