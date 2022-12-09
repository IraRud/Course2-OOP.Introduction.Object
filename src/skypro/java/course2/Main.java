package skypro.java.course2;

import skypro.java.course2.transport.Car;   // импорт класса
import skypro.java.course2.transport.Car.Key;   // импорт класса
import skypro.java.course2.transport.Car.Insurance;   // импорт класса

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        task_Person();
        printSpecialSymbol();
        task_Flower();
        printSpecialSymbol();
        task_Car();
    }

    public static void task_Person() {
        /*Максим из города Минск, который родился в 1988 году;
        Аня из города Москва, которая родилась в 1993 году;
        Катя из города Калининград, которая родилась в 1992 году;;
        Артем из города Москва, который родился в 1995 году.
        Владимир, который родился в 2001 году, живет в Казани, сейчас нигде не работает.*/

        Person maksim = new Person("Максим", "Минск", 1988,"бренд-менеджер");
        System.out.println(maksim);

        Person anya = new Person("Аня", "Москва", 1993,"методист образовательных программ");
        System.out.println(anya);

        Person katya = new Person("Катя", "Калиниград", 1992, "продакт-менеджер");
        System.out.println(katya);

        Person artem = new Person("", "       ", -1985,null);   // на примере Артема сделаем все не так
        System.out.println(artem);

        Person vladimir = new Person("Владимир", "Казань", 2001,null);
        System.out.println(vladimir);
    }

    public static void task_Flower() {
        /*Роза обыкновенная из Голландии, стоимость штуки — 35,59 рублей.
        Хризантема, стоимость штуки — 15 рублей, срок стояния — 5 дней.
        Пион из Англии, стоимость штуки — 69,9 рублей, срок стояния — 1 день.
        Гипсофила, страна происхождения — Турция, стоимость штуки — 19,5 рублей, срок стояния — 10 дней.*/
        Flower rose = new Flower("Роза обыкновенная", "Голландия", 35.59);
        System.out.println(rose);
        Flower chrysanthemum = new Flower("Хризантема", "", 15, 5);
        System.out.println(chrysanthemum);
        Flower peony = new Flower("Пион", "Англия", 69.9, 1);
        System.out.println(peony);
        Flower gypsophila = new Flower("Гипсофила", "Турция", 19.5, 10);
        System.out.println(gypsophila);

        printSpecialSymbol();

        Flower[] flowers = new Flower[] {rose, chrysanthemum};  // создаем массив цветков
        Bouquet bouquet = new Bouquet(flowers); // из массива цветков создаем букет
        bouquet.addFlower(rose);   // добавляем еще один цветок
        System.out.println(bouquet);
    }

    public static void task_Car() {
        /*Lada Granta, 2015 год выпуска, сборка в России, желтого цвета, объем двигателя — 1,7 л.
        Audi A8 50 L TDI quattro, 2020 год выпуска, сборка в Германии, черный цвет кузова, объем двигателя — 3,0 л.
        BMW Z8, сборка в Германии в 2021 году, черный цвет кузова, объем — 3,0 л.
        Kia Sportage 4-го поколения, 2018 год выпуска, сборка в Южной Корее, цвет кузова — красный, объем двигателя — 2,4 л.
        Hyundai Avante, сборка в Южной Корее, цвет кузова — оранжевый, объем двигателя — 1,6 л, год выпуска — 2016 год.
        Car firstCar = new Car("  ", "", -2015,null, "", -1.7); // пример для некорректной работы
        System.out.println(firstCar.toString());
        Car secondCar = new Car("Audi", "A8 50 L TDI quattro", 2020,"Германия", "черный", 3.0);
        System.out.println(secondCar.toString());
        Car thirdCar = new Car("BMW", "Z8", 2021,"Германия", "черный", 3.0);
        System.out.println(thirdCar.toString());
        Car fourthCar = new Car("Kia", "Sportage 4-го поколения", 2018,"Южная Корея", "красный", 2.4);
        System.out.println(fourthCar.toString()); */

        Car fifthCar = new Car("Hyundai", "Avante", 2016," ", "оранжевый", 1.6, "T15", "Универсал", "A000AA125", 2, true);
        System.out.println(fifthCar);
        fifthCar.changeTiresForSeasonalOnes();  // метод позволяет сменить резину на сезонную автоматически (на момент выполнения - зима)
        System.out.println(fifthCar);

        Key keyOfFifthCar = fifthCar.new Key(true, false);  // создание ключа для конкретной машины
        Insurance insuranceOfFifthCar = fifthCar.new Insurance(LocalDate.of(2022, 10, 1), -12_000, "000");   // создание страховки для конкретной машины
        fifthCar.setKey(keyOfFifthCar); // тк не передавали в конструктор
        fifthCar.setInsurance(insuranceOfFifthCar); // тк не передавали в конструктор
        System.out.println(fifthCar);
        insuranceOfFifthCar.checkValidityPeriod();  // проверка истечения срока страховки
        insuranceOfFifthCar.checkNumber();  // проверка длины номера страховки
    }

    public static void printSpecialSymbol() {
        System.out.println("\n+ ===================== +\n");
    }
}
