package skypro.java.course2.transport;

import java.time.LocalDate;
import java.time.LocalTime;

// отдельный класс для тестирования класса Transport и наследующих его
public class TestTransport {
    public static void main(String[] args) {
        Transport[] transports = new Transport[]{
                new Car("Audi", "model 1", -1),
                new Car("Seat", "", 2),
                new Bus("Toyota Motor", "XX-xx", 70),
                new Truck("Газель", "Р00", 7)
        };

        for (Transport transport : transports) {
            System.out.println(transport);
        }
    }
}
