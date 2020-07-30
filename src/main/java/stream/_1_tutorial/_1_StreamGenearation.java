package stream._1_tutorial;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/*
    1) 생성하기

    보통 배열과 컬렉션을 이용해서 스트림을 만들지만 이 외에도 다양한 방법으로 스트림을 만들 수 있습니다.
    하나씩 살펴보겠습니다.
*/

class _1_StreamGenearation {

    /*
        [1] 배열 스트림

        스트림을 이용하기 위해서는 먼저 생성을 해야 합니다.
        스트림은 배열 또는 컬렉션 인스턴스를 이용해서 생성할 수 있습니다.
        배열은 다음과 같이 Arrays.stream 메소드를 사용합니다.
    */
    public static void arrayStream() {
        String[] arr = new String[]{"a", "b", "c"};
        Stream<String> stream = Arrays.stream(arr);
        Stream<String> streamOfArrayPart = Arrays.stream(arr, 1, 3);
    }

    /*
        [2] 컬렉션 스트림

        컬렉션 타입(Collection, List, Set)의 경우 인터페이스에 추가된 디폴트 메소드 stream 을 이용해서 스트림을 만들 수 있습니다.

        public interface Collection<E> extends Iterable<E> {
            default Stream<E> stream() {
                return StreamSupport.stream(spliterator(), false);
            }
            // ...
        }

        그러면 다음과 같이 생성할 수 있습니다.
    */
    public static void CollectionStream() {
        List<String> list = Arrays.asList("a", "b", "c");
        Stream<String> stream = list.stream();
        Stream<String> parallelStream = list.parallelStream();
    }

    /*
        [3] 비어 있는 스트림

        비어 있는 스트림(empty streams)도 생성할 수 있습니다.
        언제 빈 스트림이 필요할까요?
        빈 스트림은 요소가 없을 때 null 대신 사용할 수 있습니다.
    */
    public Stream<String> streamOf(List<String> list) {
        return list == null || list.isEmpty() ? Stream.empty() : list.stream();
    }

    /*
        [4] Stream.builder()

        빌더(Builder)를 사용하면 스트림에 직접적으로 원하는 값을 넣을 수 있습니다.
        마지막에 build 메소드로 스트림을 리턴합니다.
    */
    public static Stream<String> streamBuilder() {
        return Stream.<String>builder()
                .add("Eric")
                .add("Elena")
                .add("Java")
                .build();
    }

    /*
        [5] Stream.generate()

        generate 메소드를 이용하면 Supplier<T> 에 해당하는 람다로 값을 넣을 수 있습니다.
        Supplier<T> 는 인자는 없고 리턴값만 있는 함수형 인터페이스죠.
        람다에서 리턴하는 값이 들어갑니다.

        public static<T> Stream<T> generate(Supplier<T> s) { ... }

        이 때 생성되는 스트림은 크기가 정해져있지 않고 무한(infinite)하기 때문에 특정 사이즈로 최대 크기를 제한해야 합니다.
    */
    public static Stream<String> generatedStream() {
        return Stream.generate(() -> "gen").limit(5);
    }
}