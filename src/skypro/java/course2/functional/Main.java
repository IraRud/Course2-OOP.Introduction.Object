package skypro.java.course2.functional;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
//        task1();
//        task2();
        task3();
    }

    private static void task1() {
        // переменные для задания 1
        Integer number1 = 3;
        Integer number2 = -3;

        // определение классификации числа через анонимный класс
        // отнесем 0 к положительным числам
        Predicate<Integer> integerPredicateAC = new Predicate<Integer>() {
            @Override
            public boolean test(Integer integer) {
                return integer >= 0;
            }
        };
        // проверка
        System.out.println(integerPredicateAC.test(number1));
        System.out.println(integerPredicateAC.test(number2));

        // определение классификации числа через лямбда-выражение
        // отнесем 0 к положительным числам
        Predicate<Integer> integerPredicateLE = integer -> integer >= 0;
        // проверка
        System.out.println(integerPredicateLE.test(number1));
        System.out.println(integerPredicateLE.test(number2));
    }

    private static void task2() {
        // переменные для задания 2
        String name1 = "Аяка";
        String name2 = "Аято";

        // вывод приветсвия через анонимный класс
        Consumer<String> stringConsumerAC = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.printf("Давно не виделись, %s!\n", s);
            }
        };
        // проверка
        stringConsumerAC.accept(name1);
        stringConsumerAC.accept(name2);

        // определение классификации числа через лямбда-выражение
        Consumer<String> stringConsumerLE = s -> System.out.printf("Давно не виделись, %s!\n", s);
        // проверка
        stringConsumerLE.accept(name1);
        stringConsumerLE.accept(name2);
    }

    private static void task3() {
        // переменные для задания 3
        Double number1 = 2.1;
        Double number2 = 2.9;

        // округление и приведение к типу Long через анонимный класс
        Function<Double, Long> doubleLongFunctionAC = new Function<Double, Long>() {
            @Override
            public Long apply(Double aDouble) {
                return Math.round(aDouble);
            }
        };
        // проверка
        System.out.println(doubleLongFunctionAC.apply(number1));
        System.out.println(doubleLongFunctionAC.apply(number2));

        // округление и приведение к типу Long через лямбда-выражение
        Function<Double, Long> doubleLongFunctionLE = Math::round;
        // проверка
        System.out.println(doubleLongFunctionLE.apply(number1));
        System.out.println(doubleLongFunctionLE.apply(number2));
    }

}
