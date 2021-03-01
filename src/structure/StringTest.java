package structure;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class StringTest {
    public static void main(String[] args) {
        /*
        1. 자바의 데이터 타입
         - 기본형 : Byte, Short, Int(21억), Long, Float, Double, Boolean, Char
         - 참조형 : 클래스, 배열, 인터페이스
         - 이상한놈 : ""String"" 실제는 참조형인데 동작은 기본형처럼 */

        int val = 4;
        String s = "abcd"; //스트링을 Immutable Class 라고도해 네이버 면접에 자주나
        int [] arr = {0};

        /*
        2. Call By Value vs Call By Reference
         - 기본형은 call by value     값의
         - 참조형은 call by reference
        */
        System.out.println("CallByValue Before : " + val + " " + s);
        callByValue(val, s);
        System.out.println("CallByValue After : " + val + " " + s);

        System.out.println("\nCallByReference Before : " + arr[0]);
        callByReference(arr);
        System.out.println("CallByReference After : " + arr[0]);

        /*
        3. String Class 는 Immutable 클래스 인가요? 네
          => String 클래스의 멤버 변수가 final 선언 private final char value[];

          아래의 코드 동작 원리
          1. 힙에 abc를 만들고 변수 a가 가리킴
          2. a = "dfg"라고 새로 할당하면 값을 바꾸는 것이 아니라 힙에 "dfg"를 새로 생성
          3. 변수 a가 "dfg"의 주소를 가리키도록 변경
        */

        String a = "abc";
        a = "dfg";

        /*
        4. String VS StringBuilder 비교
        위의 설명을 보면 + + 로 연결된 문자열은
        새로 생성해서 가리키고 또 새로생성하고 가리키므로 메모리 낭비가 커진다는 것을 알겠죠?

        하지만, StringBuilder는 동일한 객체내에서 지지고 볶고 섞고 흔들고 돌리고 하기 때문에 메모리 낭비가 적어요 ^^
        실제 내부 함수
        public AbstractStringBuilder append(String str) {
            if (str == null)
                return appendNull();
            int len = str.length();
            ensureCapacityInternal(count + len);  char [] = size 4->7 "abcd" .append("ced")
            str.getChars(0, len, value, count);
            count += len;
            return this;
        }

        StringBuilder()-동기화지원안함 vs StringBuffer()-동기화지원 멀티쓰레드환경
        코테에서는 StringBuilder 까지만 쓰면 된다는게 결론.
        근데 String 써도 코테에서 문제나는 경우는 많이 없으나 네이버에서 가끔씩 물어봄
         */

        String str = "abc" + "def" + "hij" + "klm" + "opq" + "str";
        StringBuilder sb = new StringBuilder()
                .append("abc").append("def").append("hij")
                .append("klm").append("opq").append("str");

        System.out.println(str + " " + sb.toString());
    }

    public static void callByValue(int val, String str) {
        val = 4;
        str = "ppppppppppp";
        System.out.println("changed : " + val + " " + str);
    }

    public static void callByReference(int [] arr) {
        arr[0] = 9999;
        System.out.println("changed : " + arr[0]);
    }
}