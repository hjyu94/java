package _31_Serialization;

import java.io.*;

class Person implements Serializable {
    String name;
    transient String job; // 직렬화 할 수 없는 값 표시

    public Person(String name, String job) {
        this.name = name;
        this.job = job;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", job='" + job + '\'' +
                '}';
    }
}

class Person_2 implements Externalizable {

    @Override
    public void writeExternal(ObjectOutput objectOutput) throws IOException {

    }

    @Override
    public void readExternal(ObjectInput objectInput) throws IOException, ClassNotFoundException {

    }
}

public class SerializationTest {
    public static void main(String[] args) {
        Person jimin = new Person("최지민", "게임 개발자");
        Person hjeong = new Person("유효정", "웹 개발자");

        try(FileOutputStream fos = new FileOutputStream("serial.dat");
            ObjectOutputStream oos = new ObjectOutputStream(fos))
        {
            oos.writeObject(jimin);
            oos.writeObject(hjeong);
        } catch (IOException e)
        {
            System.out.println(e);
        }

        try(FileInputStream fis = new FileInputStream("serial.dat");
            ObjectInputStream oos = new ObjectInputStream(fis))
        {
            // 안전하게 다운캐스팅 하려면 instanceof 를 사용해서 Person 인지 확인하면 된다.
            Person p1 = (Person)oos.readObject();
            Person p2 = (Person)oos.readObject();
        } catch (IOException | ClassNotFoundException e)
        {
            System.out.println(e);
        }
    }
}
