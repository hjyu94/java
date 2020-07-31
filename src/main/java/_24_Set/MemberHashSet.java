package _24_Set;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.HashSet;
import java.util.Iterator;

@Getter @Setter @AllArgsConstructor @ToString
class Member {
    int memberId;
    String name;

//    @Override
//    public int hashCode() {
//        return memberId;
//    }
//
//    @Override
//    public boolean equals(Object obj) {
//        if (obj instanceof Member) {
//            Member member = (Member) obj;
//            return (this.memberId == member.getMemberId());
//        }
//        return false;
//    }
}

public class MemberHashSet {
    private HashSet<Member> hashSet;

    public MemberHashSet() {
        hashSet = new HashSet<>();
    }

    public void addMember(Member member) {
        hashSet.add(member);
    }

    public boolean removeMember(int memberId) {
        Iterator ir = hashSet.iterator();
        while(ir.hasNext()) {
            Member member = (Member) ir.next();
            if(member.getMemberId() == memberId) {
                hashSet.remove(member);
                return true;
            }
        }
        return false;
    }

    public void showAllMember() {
        for (Member member : hashSet) {
            System.out.println(member);
        }
    }
}

class MemberHashSetTest {
    public static void main(String[] args) {
        MemberHashSet memberHashSet = new MemberHashSet();
        memberHashSet.addMember(new Member(1, "ㄱㄱ"));
        memberHashSet.addMember(new Member(2, "ㄴㄴ"));
        memberHashSet.addMember(new Member(1, "ㄷㄷ"));
        memberHashSet.showAllMember();
    }
}