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

    public static void main_5(String[] args) {
        String pattern = "[abc][vz]";
        System.out.println("av".matches(pattern));
        System.out.println("ac".matches(pattern));

        pattern = "Ex_[a-g1-5]";
        System.out.println("Ex_g".matches(pattern));
        System.out.println("Ex_6".matches(pattern));
    }

    public static void main_6(String[] args) {
        String pattern = "a*[0-9]*";
        System.out.println("aaa123".matches(pattern));
        System.out.println("aaa".matches(pattern));

        pattern = "a*[0-9]+";
        System.out.println("aaa123".matches(pattern));
        System.out.println("aaa".matches(pattern));
    }

    public static void main_7(String[] args) {
        String pattern = "a*[0-9]?";
        System.out.println("aaa".matches(pattern));
        System.out.println("aaa12".matches(pattern));

        pattern = "a*[0-9]{0,1}";
        System.out.println("aaa".matches(pattern));
        System.out.println("aaa12".matches(pattern));
    }

    public static void main_8(String[] args) {
        String pattern = "(\\w)(\\s+)([\\w])";
        System.out.println("Hello     World".replaceAll(pattern, "-"));

        pattern = "(\\w)(\\s+)([\\w])";
        System.out.println("Hello     World".replaceAll(pattern, "$1-$3"));
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

    public static void main(String[] args) {
        String data = "평촌(서울/경기-4호선)";
        String pattern = "[()-]";
        String[] split = data.split(pattern);
        System.out.println(Arrays.asList(split));
    }

}
