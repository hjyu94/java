package stream._1_tutorial;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/*
    2) 가공하기

    전체 요소 중에서 다음과 같은 API 를 이용해서 내가 원하는 것만 뽑아낼 수 있습니다.
    이러한 가공 단계를 중간 작업(intermediate operations)이라고 하는데,
    이러한 작업은 스트림을 리턴하기 때문에 여러 작업을 이어 붙여서(chaining) 작성할 수 있습니다.
 */
public class _2_StreamProcessing {

    private static Stream<String> streamEx = Stream.<String>builder().add("Eric").add("Elena").add("Java").build();
    private static List<Product> productList =
            Arrays.asList(
                    new Product(23, "potatoes"),
                    new Product(14, "orange"),
                    new Product(13, "lemon"),
                    new Product(23, "bread"),
                    new Product(13, "sugar")
            );

    /*
        [1] Filtering

        필터(filter)은 스트림 내 요소들을 하나씩 평가해서 걸러내는 작업입니다.
        인자로 받는 Predicate 는 boolean 을 리턴하는 함수형 인터페이스로 평가식이 들어가게 됩니다.

        Stream<T> filter(Predicate<? super T> predicate);
    */
    public static void Filtering() {
        Stream<String> filteredStream = streamEx.filter(name -> name.contains("a"));
    }

    /*
        [2] Mapping

        맵(map)은 스트림 내 요소들을 하나씩 특정 값으로 변환해줍니다.
        이 때 값을 변환하기 위한 람다를 인자로 받습니다.

        <R> Stream<R> map(Function<? super T, ? extends R> mapper);
    */
    public static void Mapping() {
        Stream<String> stringStream = streamEx.map(String::toUpperCase);
        // 스트림 내 String 의 toUpperCase 메소드를 실행해서 대문자로 변환한 값들이 담긴 스트림을 리턴합니다.
        // [ERIC, ELENA, JAVA]

        Stream<Integer> integerStream = productList.stream().map(Product::getAmount);
        // 다음처럼 요소 내 들어있는 Product 개체의 수량을 꺼내올 수도 있습니다. 각 ‘상품’을 ‘상품의 수량’으로 맵핑하는거죠.
        // [23, 14, 13, 23, 13]
    }

    /*
        [2-1] flatMap

        map 이외에도 조금 더 복잡한 flatMap 메소드도 있습니다.
        <R> Stream<R> flatMap(Function<? super T, ? extends Stream<? extends R>> mapper);

        인자로 mapper를 받고 있는데, 리턴 타입이 Stream 입니다.
        즉, 새로운 스트림을 생성해서 리턴하는 람다를 넘겨야합니다.
        flatMap 은 중첩 구조를 한 단계 제거하고 단일 컬렉션으로 만들어주는 역할을 합니다.
        이러한 작업을 플래트닝(flattening)이라고 합니다.
    */
    public static void FlatMapping() {
        // 1) 기본 데이터 타입
        // 다음과 같은 중첩된 리스트가 있습니다.
        List<List<String>> list = Arrays.asList(
                Arrays.asList("ㄱ","ㄴ","ㄷ","ㄹ")
                , Arrays.asList("a","b","c","d")
        );
        List<String> collect = list
                .stream()
                .flatMap(Collection::stream)
                .collect(Collectors.toList());

        // 2) 객체에 적용해보기
        // 아래 예제에서는 학생 객체를 가진 스트림에서 학생의 국영수 점수를 뽑아 새로운 스트림을 만들어 평균을 구하는 코드입니다.
        // 이는 map 메소드 자체만으로는 한번에 할 수 없는 기능입니다.
        List<Student> students =
                Arrays.asList(
                        new Student(1, 2, 3)
                        , new Student(4, 5, 6)
                        , new Student(7, 8, 9)
                );
        students
                .stream()
                .flatMapToInt(student ->
                        IntStream.of(student.getKor(), student.getEng(), student.getMath())
                )
                .average()
                .ifPresent(avg ->
                        System.out.println(Math.round(avg * 10) / 10.0)
                );
    }
}