package skypro.java.course2.transport;

// отдельный класс для тестирования класса Transport и наследующих его
public class TestTransport {
    public static void main(String[] args) {
        Transport[] transports = new Transport[]{
                new Car("Audi", "Model YY", -1),
                new Bus("Toyota Motor", "Model XX-xx", 70),
        };

        checkClassMethods(transports);  // проверка методов из родительского класса
        specialSymbol();

        // проверка переопределенных методов интерфейса
        Transport firstCar = new Car("Seat", "", 2);
        ((Car) firstCar).pitStop();
        Car secondCar = new Car("Honda", "Model UU", 1);
        secondCar.bestLapTime(30);

        Truck firstTruck = new Truck("Газель", "Model 800", 7);
        firstTruck.bestLapTime(250);
        Truck secondTruck = new Truck("Газель", "Model 700", 0);
        secondTruck.maxSpeed(100);

        Bus firstBus = new Bus("АвтоМир", "Мосгортрнас", 0);
        firstBus.maxSpeed(70);
        firstBus.pitStop();

    }

    // проверка методов из родительского класса
    public static void checkClassMethods(Transport... transports) {
        for (Transport transport : transports) {
            System.out.println(transport);
            transport.startMoving();
            transport.finishMoving();
        }
    }

    public static void specialSymbol() {
        System.out.println("--------------- + + + ---------------");
    }

}
