package _29_Stream._1_tutorial;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/*
    3) 결과 만들기

    가공한 스트림을 가지고 내가 사용할 결과값으로 만들어내는 단계입니다.
    따라서 스트림을 끝내는 최종 작업(terminal operations)입니다.
*/

/*
    Collecting

    collect 메소드는 또 다른 종료 작업입니다.
    Collector 타입의 인자를 받아서 처리를 하는데요,
    자주 사용하는 작업은 Collectors 객체에서 제공하고 있습니다.

    이번 예제에서는 다음과 같은 간단한 리스트를 사용합니다.
    Product 객체는 수량(amount)과 이름(name)을 가지고 있습니다.
*/
public class _3_StreamCollecting {

    public static List<Product> productList =
            Arrays.asList(
                    new Product(23, "potatoes"),
                    new Product(14, "orange"),
                    new Product(13, "lemon"),
                    new Product(23, "bread"),
                    new Product(13, "sugar")
            );

    /*
        Collectors.toList()

        스트림에서 작업한 결과를 담은 리스트로 반환합니다.
        다음 예제에서는 map 으로 각 요소의 이름을 가져온 후 Collectors.toList 를 이용해서 리스트로 결과를 가져옵니다.
    */
    public static List<String> toList() {
        return productList.stream()
                .map(Product::getName)  // === .map(product -> product.getName())
                .collect(Collectors.toList());
    }
}

/*
    Reduction
*/
class _3_StreamReduce {
    public static void main(String[] args) {
        // 먼저 인자가 하나만 있는 경우입니다.
        // 여기서 BinaryOperator<T> 는 같은 타입의 인자 두 개를 받아 같은 타입의 결과를 반환하는 함수형 인터페이스입니다.
        // 다음 예제에서는 두 값을 더하는 람다를 넘겨주고 있습니다. 따라서 결과는 6(1 + 2 + 3)이 됩니다.
        OptionalInt reduced =
                IntStream.range(1, 4) // [1, 2, 3]
                        .reduce((a, b) -> {
                            return Integer.sum(a, b);
                        });

        // 이번엔 두 개의 인자를 받는 경우입니다.
        // 여기서 10은 초기값이고, 스트림 내 값을 더해서 결과는 16(10 + 1 + 2 + 3)이 됩니다.
        // 여기서 람다는 메소드 참조(method reference)를 이용해서 넘길 수 있습니다.
        int reducedTwoParams =
                IntStream.range(1, 4) // [1, 2, 3]
                        .reduce(10, Integer::sum); // method reference


        // 마지막으로 세 개의 인자를 받는 경우입니다.
        {
            // Combiner 가 하는 역할을 설명만 봤을 때는 잘 이해가 안갈 수 있는데요, 코드를 한번 살펴봅시다.
            // 그런데 다음 코드를 실행해보면 이상하게 마지막 인자인 combiner 는 실행되지 않습니다.
            Integer reducedParams = Stream.of(1, 2, 3)
                    .reduce(10, // identity
                            Integer::sum, // accumulator
                            (a, b) -> {
                                System.out.println("combiner was called");
                                return a + b;
                            });

            // Combiner 는 병렬 처리 시 각자 다른 쓰레드에서 실행한 결과를 마지막에 합치는 단계입니다.
            // 따라서 병렬 스트림에서만 동작합니다
            // 결과는 다음과 같이 36이 나옵니다.
            //
            // 먼저 accumulator 는 총 세 번 동작합니다.
            // 초기값 10에 각 스트림 값을 더한 세 개의 값(10 + 1 = 11, 10 + 2 = 12, 10 + 3 = 13)을 계산합니다.
            // Combiner 는 identity 와 accumulator 를 가지고 여러 쓰레드에서 나눠 계산한 결과를 합치는 역할입니다.
            // 12 + 13 = 25, 25 + 11 = 36 이렇게 두 번 호출됩니다.
            Integer reducedParallel = Arrays.asList(1, 2, 3)
                    .parallelStream()
                    .reduce(10,
                            Integer::sum,
                            (a, b) -> {
                                System.out.println("combiner was called");
                                return a + b;
                            });
        }
    }
}

class 문자열_연결_Test {
    public static void main(String[] args) {
        Set<String> stations = Set.of("A", "B", "C");
        System.out.println(stations.stream().reduce((a,b) -> a + ", " + b).get());
    }
}