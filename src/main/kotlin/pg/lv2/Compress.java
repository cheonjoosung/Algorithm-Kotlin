package pg.lv2;

import java.util.ArrayList;
import java.util.HashMap;

public class Compress {

    public static void main(String[] args) {
        //KAKAO	[11, 1, 27, 15]
        //TOBEORNOTTOBEORTOBEORNOT	[20, 15, 2, 5, 15, 18, 14, 15, 20, 27, 29, 31, 36, 30, 32, 34]
        //ABABABABABABABAB	[1, 2, 27, 29, 28, 31, 30]

        System.out.println(solution("KAKAO"));
        System.out.println(solution("TOBEORNOTTOBEORTOBEORNOT"));
        System.out.println(solution("ABABABABABABABAB"));
    }

    public static int[] solution(String msg) {
        HashMap<String, Integer> map = new HashMap<>();
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i <= 25; i++) {
            String alphabet = String.valueOf((char) (i + 'A'));
            map.put(alphabet, map.size() + 1);
        }

        for (int i = 0; i < msg.length(); i++) {

            String first = String.valueOf(msg.charAt(i));
            StringBuilder temp = new StringBuilder(first);

            for (int j = i + 1; j < msg.length(); j++) {
                String next = String.valueOf(msg.charAt(j));

                if (!map.containsKey(temp.toString() + next)) {
//                    System.out.println("들어간거 " + (temp.toString()+next));
                    map.put(temp.toString() + next, map.size() + 1);
                    i = j - 1;
                    break;
                } else {
                    temp.append(next); //OT
                    i = j;
                }

            }

            //k a ka o
//            System.out.println(temp.toString());
            list.add(map.get(temp.toString()));
        }

        for (int val : list) {
            System.out.print(val + " ");
        }

        int [] answer = list.stream().mapToInt(Integer::intValue).toArray();
        return answer;
    }
}
