package skypro.java.course2.functional;

import java.util.function.Consumer;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
//        task1();
        task2();
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

}
