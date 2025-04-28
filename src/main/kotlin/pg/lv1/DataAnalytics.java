package pg.lv1;

import java.util.*;

public class DataAnalytics {

    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        ArrayList<Product> list = new ArrayList<>();
        for (int i=0 ; i<data.length; i++) {
            int code = data[i][0];
            int date = data[i][1];
            int maxiMum = data[i][2];
            int remain = data[i][3];

            switch (ext) {
                case "code" -> {
                    if (code < val_ext) {
                        list.add(new Product(code, date, maxiMum, remain));
                    }
                }
                case "date" -> {
                    if (date < val_ext) {
                        list.add(new Product(code, date, maxiMum, remain));
                    }
                }
                case "maximum" -> {
                    if (maxiMum < val_ext) {
                        list.add(new Product(code, date, maxiMum, remain));
                    }
                }
                default -> {
                    if (remain < val_ext) {
                        list.add(new Product(code, date, maxiMum, remain));
                    }
                }
            }
        }

        list.sort((o1, o2) -> {
            switch (sort_by) {
                case "code" -> {
                    return o1.code - o2.code;
                }
                case "date" -> {
                    return o1.date - o2.date;
                }
                case "maximum" -> {
                    return o1.maxiMum - o2.maxiMum;
                }
                default -> {
                    return o1.remain - o2.remain;
                }
            }
        });

        int[][] answer = new int[list.size()][4];
        for (int i=0 ; i<list.size() ; i++) {
            answer[i][0] = list.get(i).code;
            answer[i][1] = list.get(i).date;
            answer[i][2] = list.get(i).maxiMum;
            answer[i][3] = list.get(i).remain;
        }
        return answer;
    }
}

class Product {
    int code; int date; int maxiMum; int remain;

    Product(int code, int date, int maxiMum, int remain) {
        this.code = code; this.date = date; this.maxiMum = maxiMum; this.remain = remain;
    }
}
