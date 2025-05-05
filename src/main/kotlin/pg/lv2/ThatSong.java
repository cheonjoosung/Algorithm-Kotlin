package pg.lv2;

public class ThatSong {
    public String solution(String m, String[] musicinfos) {
        String answer = "(None)";
        int maxTime = -1;

        m = convertMelody(m);

        for (String info : musicinfos) {
            String[] parts = info.split(",");
            String start = parts[0];
            String end = parts[1];
            String title = parts[2];
            String melody = convertMelody(parts[3]);

            int playTime = getMinutes(end) - getMinutes(start);
            String fullMelody = buildFullMelody(melody, playTime);

            if (fullMelody.contains(m)) {
                if (playTime > maxTime) {
                    maxTime = playTime;
                    answer = title;
                }
            }
        }

        return answer;
    }

    // C# -> c, D# -> d ... 으로 치환하여 한 글자로 통일
    private String convertMelody(String s) {
        return s.replaceAll("C#", "c")
                .replaceAll("D#", "d")
                .replaceAll("F#", "f")
                .replaceAll("G#", "g")
                .replaceAll("E#", "e")
                .replaceAll("B#", "b")
                .replaceAll("A#", "a");
    }

    // HH:MM 문자열을 분 단위로 변환
    private int getMinutes(String time) {
        String[] t = time.split(":");
        return Integer.parseInt(t[0]) * 60 + Integer.parseInt(t[1]);
    }

    // 전체 재생 멜로디 생성
    private String buildFullMelody(String melody, int length) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            sb.append(melody.charAt(i % melody.length()));
        }
        return sb.toString();
    }
}
