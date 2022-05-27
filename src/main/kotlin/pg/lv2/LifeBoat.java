package pg.lv2;

public class LifeBoat {

    public static void main(String[] args) {

        LifeBoat lb = new LifeBoat();
        System.out.println(lb.solution(new int[]{70, 50, 80, 50},100));
        System.out.println(lb.solution(new int[]{70, 80, 50},100));
    }

    public int solution(int[] people, int limit) {
        int answer = 0;

        java.util.Arrays.sort(people);

        int i = 0;
        int j = 0;

        for (j = people.length-1 ; i<=j ; j--) {
            if (people[i] + people[j] <= limit) {
                i++;
            }
            answer++;
        }
        return answer;
    }
}
