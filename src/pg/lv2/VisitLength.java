package pg.lv2;

import java.util.ArrayList;
import java.util.Objects;

public class VisitLength {
    public static void main(String[] args) {
        System.out.println(solution("ULURRDLLU")); //7  ?
        System.out.println(solution("LULLLLLLU")); //7  ?
    }

    public static int solution(String dirs) {
        int answer = 0;

        int sx = 5;
        int sy = 5;

        ArrayList<Pos> list = new ArrayList<>();

        for (int i=0 ; i<dirs.length() ; i++) {
            Pos p = null;
            Pos p2 = null;

            switch (dirs.charAt(i)) {
                case 'U':
                    if (sy >= 10) continue;
                    p = new Pos(sx, sy, sx, sy+1);
                    p2 = new Pos(sx, sy+1, sx, sy);
                    sy += 1;
                    break;
                case 'D':
                    if (sy < 1) continue;
                    p = new Pos(sx, sy, sx, sy-1);
                    p2 = new Pos(sx, sy-1, sx, sy);
                    sy -= 1;
                    break;
                case 'L':
                    if (sx < 1) continue;
                    p = new Pos(sx, sy, sx-1, sy);
                    p2 = new Pos(sx-1, sy, sx, sy);
                    sx -= 1;
                    break;
                case 'R':
                    if (sx >= 10) continue;
                    p = new Pos(sx, sy, sx+1, sy);
                    p2 = new Pos(sx+1, sy, sx, sy);
                    sx += 1;
                    break;
                default:
                    break;
            }

            if (!list.contains(p)) {
                list.add(p);
            }

            if (!list.contains(p2)) {
                list.add(p2);
            }
        }

        answer = list.size()/2;

        return answer;
    }
}

class Pos {
    int x; int y; int nx; int ny;
    Pos(int x, int y, int nx, int ny) {
        this.x = x; this.y = y;
        this.nx = nx; this.ny = ny;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pos pos = (Pos) o;
        return x == pos.x &&
                y == pos.y &&
                nx == pos.nx &&
                ny == pos.ny;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y, nx, ny);
    }
}
