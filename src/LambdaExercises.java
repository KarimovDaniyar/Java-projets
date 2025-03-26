import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.BiFunction;

public class LambdaExercises {
    public static void main(String[] args) {
        MathOperation add = (a,b) -> a+b;
        MathOperation sub = (a,b) -> a-b;
        MathOperation multi = (a,b) -> a*b;
        MathOperation div = (a,b) -> a/b;
        System.out.println(add.operate(7, 4) +" "+ sub.operate(7, 4) +" "+ multi.operate(7, 3) +" "+ div.operate(7, 3));

        List<Integer> numbers = Arrays.asList(10, 15, 22, 33, 40, 55);
        Predicate<Integer> isOdd = n -> n%2!=0;
        List<Integer> oddNumbers = new ArrayList<>();
        for(int num : numbers){
            if(isOdd.test(num)){
                oddNumbers.add(num);
            }
        }
        System.out.println("Odd numbers" + oddNumbers);
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie", "David");
        names.sort((a, b) -> b.compareTo(a));
        System.out.println("Sorted Names: " + names);

        List<String> words = Arrays.asList("hello", "java", "lambda");
        Function<String, String> transform = s -> new StringBuilder(s.toUpperCase()).reverse().toString();
        List<String> transformedWords = new ArrayList<>();
        for (String word : words) {
            transformedWords.add(transform.apply(word));
        }
        System.out.println("Transformed Strings: " + transformedWords);

        List<String> cities = Arrays.asList("New York", "London", "Tokyo", "Berlin");
        Consumer<String> printCity = city -> System.out.println(city);
        cities.forEach(printCity);

        List<String> citiess = Arrays.asList("New York", "London", "Tokyo", "Berlin");
        citiess.forEach(System.out::println);

        BiFunction<Integer, Integer, Integer> maxFunction = (a, b) -> Math.max(a, b);
        BiFunction<Integer, Integer, Integer> minFunction = (a, b) -> Math.min(a, b);
        int a = 25, b = 40;
        System.out.println("Max: " + maxFunction.apply(a, b));
        System.out.println("Min: " + minFunction.apply(a, b));
    }
}

interface MathOperation{
    int operate (int a, int b);
}