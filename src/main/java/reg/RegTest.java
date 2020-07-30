package reg;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegTest {
    public static void main_0(String[] args) {
        String data = "Window98, WindowMe, WindowXP, WindowNT, Window2000, Window7";
        Pattern p = Pattern.compile("(Window)(98|XP|7)");
        Matcher m = p.matcher(data);
        while(m.find()) {
            System.out.println(m.group(0) + ": " + m.group(1) + "," + m.group(2));
        }
        System.out.println("count: " + m.groupCount());
    }

    public static void main_1(String[] args) {
        System.out.println("ab".matches("ab."));
        System.out.println("abc".matches("ab."));
    }

    public static void main_2(String[] args) {
        System.out.println("The cat sat on the mat.".replaceAll("[Tt]he", "*"));
        System.out.println("the cat sat on the mat.".replaceAll("[Tt]he", "*"));
        System.out.println("The cat sat on the mat.".replaceAll("^[Tt]he", "*"));
        System.out.println("the cat sat on the mat.".replaceAll("^[Tt]he", "*"));
    }

    public static void main_3(String[] args) {
        System.out.println("The cat sat on the mat. and the cat".replaceAll("cat", "*"));
        System.out.println("The cat sat on the mat. and the cat".replaceAll("cat$", "*"));
    }

    public static void main_4(String[] args) {
        System.out.println("This island is beautiful.".replaceAll("is", "*"));
        System.out.println("This island is beautiful.".replaceAll("\\bis\\b", "*"));
    }

    // [ ]는 내부의 문자열과 일치하는 문자 1개를 찾습니다
    public static void main_5(String[] args) {
        String pattern = "[abc][vz]";
        System.out.println("av".matches(pattern));
        System.out.println("ac".matches(pattern));

        pattern = "Ex_[a-g1-5]";
        System.out.println("Ex_g".matches(pattern));
        System.out.println("Ex_6".matches(pattern));
    }

    public static void main_6(String[] args) {
        String pattern = "a*[0-9]*"; // *은 * 앞의 요소가 0이상 반복되는 것을 의미
        System.out.println("aaa123".matches(pattern)); // true
        System.out.println("aaa".matches(pattern)); // true

        pattern = "a*[0-9]+"; // +는 1이상 반복되는 것을 의미
        System.out.println("aaa123".matches(pattern)); // true
        System.out.println("aaa".matches(pattern)); // false
    }

    public static void main_7(String[] args) {
        String pattern = "a*[0-9]?"; // ?는 요소가 0 또는 1회만 반복되는 것을 의미합니다. == {0,1}
        System.out.println("aaa".matches(pattern)); // true
        System.out.println("aaa12".matches(pattern)); // false

        pattern = "a*[0-9]{0,1}"; // {X,Y}는 X~Y 사이의 수만큼 반복된다는 것을 의미.
        System.out.println("aaa".matches(pattern)); // true
        System.out.println("aaa12".matches(pattern)); // false
    }

    // 그룹은 ()로 지정
    // replaceAll(pattern, replacement)는 pattern과 일치하는 문자열을 replacement로 변환합니다.
    public static void main_8(String[] args) {
        String pattern = "(\\w)(\\s+)([\\w])";
        System.out.println("Hello     World".replaceAll(pattern, "-")); // 일치하는 문자열을 "-"로 변환, Hello-orld

        pattern = "(\\w)(\\s+)([\\w])";
        System.out.println("Hello     World".replaceAll(pattern, "$1-$3")); // 그룹1과 그룹3에 해당하는 내용으로 변환, Hello-World
    }

    public static void main_9(String[] args) {
        String pattern = "a*[0-9]*";
        System.out.println("aaa123".matches(pattern));

        pattern = "\\s";
        String arr[] = "Hello World Java Regex".split(pattern);
        System.out.println(Arrays.asList(arr));

        pattern = "Hello";
        System.out.println("Hello World Hello World ".replaceFirst(pattern, "Regex"));

        pattern = "Hello";
        System.out.println("Hello World Hello World ".replaceAll(pattern, "Regex"));
    }

    public static void main_10(String[] args) {
        Pattern pattern = Pattern.compile("\\bcat\\b"); // Pattern: 컴파일된 Regex
        Matcher matcher = pattern.matcher("cat cat cat cattie cat"); // Matcher는 match operation을 수행하는 engine입니다.
        int count = 0;
        while(matcher.find()) {
            count++;
            System.out.println("Match number " + count);
            System.out.println("group(): " + matcher.group());
            System.out.println("start(): " + matcher.start());
            System.out.println("end(): " + matcher.end());
        }
    }

    public static void main_11(String[] args) {
        Pattern pattern = Pattern.compile("\\d{3}-\\d{5}");
        Matcher matcher = pattern.matcher("123-45678");
        System.out.println(matcher.find());
    }

    public static void main_12(String[] args) {
        Pattern pattern = Pattern.compile("c(..) s\\1");
        Matcher matcher = pattern.matcher("The cat sat on the mat");
        System.out.println(matcher.find());
    }

    public static void main_13(String[] args) {
        Pattern pattern = Pattern.compile("\\b(\\w+)\\s+\\1\\b");
        Matcher matcher = pattern.matcher("hello world world");
        System.out.println(matcher.find());
    }

    public static void main_14(String[] args) {
        String result;
        Pattern p = Pattern.compile("dog");
        Matcher m = p.matcher("The dog says meow. All dogs say meow.");
        System.out.println(m.replaceAll("cat"));

        result = "The cat sat on the mat.".replaceAll("at[.]", "*");
        System.out.println(result);

        result = "The cat sat on the mat.".replaceAll("at[.]?", "*");
        System.out.println(result);

        result = "The cat sat on the mat.".replaceAll("[a-z]+", "*");
        System.out.println(result);
    }

    public static void main_15(String[] args) {
        String result;
        result = "The cat sat on the mat.".replaceAll("c.+t", "*");
        System.out.println(result);

        result = "The cat sat on the mat.".replaceAll("c.+?t", "*");
        System.out.println(result);
    }

    public static void main_99(String[] args) {
        String data = "평촌(서울/경기-4호선)";
        String pattern = "[()-]";
        String[] split = data.split(pattern);
        System.out.println(Arrays.asList(split));
    }

    public static void main(String[] args) {
        String[] keywordsArr = {"A, B, C", "A,B,C", "A B C", "A  B   C"};
        Arrays.stream(keywordsArr).forEach(keywords -> {
           String[] keywordArr = keywords.split("[,\\s]+");
            System.out.println(Arrays.asList(keywordArr));
        });
    }

}
