package skypro.java.course2.transport;

import java.time.LocalDate;
import java.time.LocalTime;

// отдельный класс для тестирования класса Transport и наследующих его
public class TestTransport {
    public static void main(String[] args) {
        Car hyundai = new Car("Hyundai", "Avante", 2016," ", "оранжевый", 1.6, 39, "T15", "Универсал", "A000AA125", 2, true);
        System.out.println(hyundai);
        Car.Key keyOfFifthCar = hyundai.new Key(true, false);  // создание ключа для конкретной машины
        Car.Insurance insuranceOfFifthCar = hyundai.new Insurance(LocalDate.of(2022, 10, 1), -12_000, "000");   // создание страховки для конкретной машины
        hyundai.setKey(keyOfFifthCar); // тк не передавали в конструктор
        hyundai.setInsurance(insuranceOfFifthCar); // тк не передавали в конструктор
        System.out.println(hyundai);

        /*Поезд «Ласточка», модель B-901, 2011 год выпуска в России, скорость передвижения — 301 км/ч, отходит от
        Белорусского вокзала и следует до станции Минск-Пассажирский. Цена поездки — 3500 рублей, в поезде 11 вагонов.
Поезд «Ленинград», модель D-125, 2019 год выпуска в России, скорость передвижения — 270 км/ч, отходит от Ленинградского
вокзала и следует до станции Ленинград-Пассажирский. Цена поездки — 1700 рублей, в поезде 8 вагонов.*/
        Train lastochka = new Train("\"Ласточка\"", "B-901", 2011, "Россия", "" ,301, 3_500, LocalTime.of(2,3),"Белорусский вокзал", "Минск-Пассажирский", 11 );
        System.out.println(lastochka);
        Train leningrad = new Train("\"Ленинград\"", "D-125", 2019, "Россия", "" ,270, 1_700, null,"Ленинградский вокзал", "Ленинград-Пассажирский", 8 );
        System.out.println(leningrad);
    }
}
