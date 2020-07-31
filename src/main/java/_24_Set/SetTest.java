package _24_Set;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Iterator;

public class SetTest {
    public static void main(String[] args) {
        HashSet<String> set = new HashSet<String>();
        set.add("ㄱㄱㄱ");
        set.add("ㄴㄴㄴ");
        set.add("ㄷㄷㄷ");
        set.add("ㄱㄱㄱ");

        Iterator ir = set.iterator();

        while(ir.hasNext()) {
            System.out.println(ir.next());
        }
        /*
            ㄷㄷㄷ
            ㄴㄴㄴ
            ㄱㄱㄱ
        */
    }
}