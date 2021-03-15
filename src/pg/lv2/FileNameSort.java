package pg.lv2;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FileNameSort {
    public static void main(String[] args) {
        String[] f1 = {"img12.png", "img10.png", "img02.png", "img1.png", "IMG01.GIF", "img2.JPG"};
        //"img1.png", "IMG01.GIF", "img02.png", "img2.JPG", "img10.png", "img12.png"
        String[] f2 = {"F-5 Freedom Fighter", "B-50 Superfortress", "A-10 Thunderbolt II", "F-14 Tomcat"};
        //"A-10 Thunderbolt II", "B-50 Superfortress", "F-5 Freedom Fighter", "F-14 Tomcat"

        String[] answer = solution(f1);
        for (String item : answer) {
            System.out.print(item + " ");
        }
        System.out.println();


        answer = solution(f2);
        for (String item : answer) {
            System.out.print(item + " ");
        }
        System.out.println();

    }

    public static String[] solution(String[] files) {
        String[] answer = new String[files.length];

        /*
        head(문자구성 한글자이상)/number(1에서5사이의연속숫자)/tail(그 이외에 모두 공백이 될수도있음) 로 나누기
        1. 영역 나누기
        2. 정렬하기
         */

        ArrayList<S> list = new ArrayList<>();
        //"img12.png", "img10.png", "img02.png", "img1.png", "IMG01.GIF", "img2.JPG"}
        for (int i = 0; i < files.length; i++) {
            String temp = files[i];

            int numStart = -1;
            int numEnd = -1;

            Pattern p = Pattern.compile("[0-9]");
            Matcher m = p.matcher(temp);

            if (m.find()) {
                numStart = temp.indexOf(m.group(0));
                numEnd = find(numStart, temp);

                String head = temp.substring(0, numStart);
                String number = temp.substring(numStart, numEnd + 1);
                String tail = temp.substring(numEnd + 1);

//                System.out.println(head + " " + number + " " + tail);
                list.add(new S(head, number, tail, i));
            }
        }

        list.sort((o1, o2) -> {
            if (o1.head.toLowerCase().equals(o2.head.toLowerCase())) {
                int n1 = Integer.parseInt(o1.number);
                int n2 = Integer.parseInt(o2.number);

                return n1-n2;
                /*if (n1 < n2) {
                    return 1;
                } else if (n1 == n2) {
                    //원래 순서대로
                    return 0;
                } else {
                    return -1;
                }*/
            } else {
                return o1.head.toLowerCase().compareTo(o2.head.toLowerCase());
            }
        });

        for (int i = 0 ; i<list.size() ; i++) {
            S s = list.get(i);
            answer[i] = s.head+s.number+s.tail;
        }

        return answer;
    }

    public static int find(int s, String temp) {
        int endIdx = s;
        int cnt = 1;

        for (int i = s + 1; i < temp.length(); i++) {
            char c = temp.charAt(i);

            if (c >= '0' && c <= '9') { //숫자인가
                endIdx = i;
                cnt++; // 최대 5자리 수 이므로

                if (cnt == 5) break;
            } else {
                break;
            }
        }

        return endIdx;
    }
}

class S {
    String head;
    String number;
    String tail;
    int idx;

    S(String head, String number, String tail, int idx) {
        this.head = head;
        this.number = number;
        this.tail = tail;
        this.idx = idx;
    }
}
