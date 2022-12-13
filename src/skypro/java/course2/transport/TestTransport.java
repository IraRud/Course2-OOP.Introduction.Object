package skypro.java.course2.transport;

import java.time.LocalDate;
import java.time.LocalTime;

// отдельный класс для тестирования класса Transport и наследующих его
public class TestTransport {
    public static void main(String[] args) {
        Car hyundai = new Car("Hyundai", "Avante", 2016," ", "оранжевый", 1.6, 12, 39, "T15", "Универсал", "A000AA125", 2, true);
        System.out.println(hyundai);
        Car.Key keyOfFifthCar = hyundai.new Key(true, false);  // создание ключа для конкретной машины
        Car.Insurance insuranceOfFifthCar = hyundai.new Insurance(LocalDate.of(2022, 10, 1), -12_000, "000");   // создание страховки для конкретной машины
        hyundai.setKey(keyOfFifthCar); // тк не передавали в конструктор
        hyundai.setInsurance(insuranceOfFifthCar); // тк не передавали в конструктор
        System.out.println(hyundai);

        Train lastochka = new Train("\"Ласточка\"", "B-901", 2011, "Россия", "" ,301, 45.56,3_500, LocalTime.of(2,3),"Белорусский вокзал", "Минск-Пассажирский", 11 );
        System.out.println(lastochka);
        Train leningrad = new Train("\"Ленинград\"", "D-125", 2019, "Россия", "" ,270, 98.00,1_700, null,"Ленинградский вокзал", "Ленинград-Пассажирский", 8 );
        System.out.println(leningrad);

        Bus toyota = new Bus("Toyota Motor", "XX-xx", 2013, "Япония");
        System.out.println(toyota);
        Bus volkswagen = new Bus("Volkswagen Group", "12-xx", 17, "Германия", "красный", 120, 100);
        System.out.println(volkswagen);
        Bus uaz = new Bus("УАЗ", "  ", 1997, "Россия", "белый", 90, 30);
        System.out.println(uaz);
        uaz.refill();
    }
}
