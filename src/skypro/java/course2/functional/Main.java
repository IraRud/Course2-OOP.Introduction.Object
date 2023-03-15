package skypro.java.course2.functional;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) {
//        task1();
//        task2();
//        task3();
//        task4();
        task5();
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
        double number1 = 2.1;
        double number2 = 2.9;

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

    private static void task4() {
        // возвращение случайного числа из диапазона от 0 до 100 через анонимный класс
        Supplier<Integer> integerSupplier = new Supplier<Integer>() {
            @Override
            public Integer get() {
                return (int) (Math.random() * 100);
            }
        };
        // проверка
        System.out.println(integerSupplier.get());

        // возвращение случайного числа из диапазона от 0 до 100 через лямбда-выражение
        Supplier<Integer> integerSupplierLE = () -> (int) (Math.random() * 100);
        // проверка
        System.out.println(integerSupplierLE.get());
    }

    private static void task5() {
        // зарплаты сотрудников
        Integer salary1 = 45_000;
        Integer salary2 = 17_035;

        // зарплата меньше 25 тыс.р.?
        Predicate<Integer> integerPredicate = n -> n <= 25_000;
        // если да, то повысьте в полтора раза!
        Function<Integer, Double> ifTrue = n -> n * 1.5;
        // если нет, то заберите часть
        Function<Integer, Integer> ifElse = n -> n - 25_000;

        // пересчитаем зарплаты
        Number newSalary1 = ternaryOperator(integerPredicate, ifTrue, ifElse).apply(salary1);
        Number newSalary2 = ternaryOperator(integerPredicate, ifTrue, ifElse).apply(salary2);
        // проверка
        System.out.println(newSalary1);
        System.out.println(newSalary2);
    }

    // метод для задания 5
    public static <T, U> Function<T, U> ternaryOperator(
            Predicate<? super T> condition,
            Function<? super T, ? extends U> ifTrue,
            Function<? super T, ? extends U> ifFalse) {
        // проверяем, какова зарплата сотрудника (t) относительно минимума
        // если меньше, то возвращем функцию для true, если нет - для false
        return t -> condition.test(t) ? ifTrue.apply(t) : ifFalse.apply(t);
    }

}
