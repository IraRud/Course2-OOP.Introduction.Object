package skypro.java.course2.transport;

import java.time.LocalDate;

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
    }
}
