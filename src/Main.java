import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        List<Integer> myList = new ArrayList<>();
        myList.add(5);
        myList.add(18);
        myList.add(1);
        myList.add(56);

        myList.stream();
        BiConsumer<Integer, Integer> biConsumer = (min, max) -> {
            System.out.println("Min - " + min);
            System.out.println("Max - " + max);
        };
        Comparator<Integer> integerComparator = Comparator.naturalOrder();

        findMinMax(myList.stream(), integerComparator, biConsumer);
        evenNumbers(myList);
    }

    public static <T> void findMinMax(Stream<? extends T> stream,
                                      Comparator<? super T> order,
                                      BiConsumer<? super T, ? super T> minMaxConsumer){
        List<T> list = stream.collect(Collectors.toList());
        if (list.isEmpty()) {
            minMaxConsumer.accept(null, null);
        } else {
            list.sort(order);
            minMaxConsumer.accept(list.get(0),list.get(list.size()-1) );
        }
    }

    public static void evenNumbers(List <Integer> list) {
        Predicate<Integer> predicate = a -> a % 2 == 0;
        for (Integer integer : list) {}
        System.out.println(list.stream().filter(predicate).count() + " шт. четных чисел");
    }
}