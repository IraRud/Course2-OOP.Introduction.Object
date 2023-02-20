package skypro.java.course2.transport;

import skypro.java.course2.transport.drivers.DriverCategoryB;
import skypro.java.course2.transport.drivers.DriverCategoryC;
import skypro.java.course2.transport.drivers.DriverCategoryD;

// отдельный класс для тестирования класса Transport и наследующих его
public class TestTransport {
    public static void main(String[] args) {
/*        Transport[] transports = new Transport[]{
                new Car("Audi", "Model YY", -1),
                new Bus("Toyota Motor", "Model XX-xx", 70),
        };

        checkClassMethods(transports);  // проверка методов из родительского класса

        printSpecialSymbol();

        // проверка переопределенных методов интерфейса
        Transport firstCar = new Car("Seat", "", 2);
        ((Car) firstCar).pitStop(); */

        Car secondCar = new Car("Honda", "Model UU", 1, BodyType.SEDAN);
        secondCar.bestLapTime(30);
        System.out.println(secondCar);

        Truck firstTruck = new Truck("Газель", "Model 800", 7, LoadType.N1);
        firstTruck.bestLapTime(250);
        System.out.println(firstTruck);
/*         Truck secondTruck = new Truck("Газель", "Model 700", 0);
        secondTruck.maxSpeed(100);

        Bus firstBus = new Bus("АвтоМир", "Мосгортрнас", 0);
        firstBus.maxSpeed(70);
        firstBus.pitStop();*/

        printSpecialSymbol();

        // проверка дженериков
        DriverCategoryB<Car> ivanIvanov = new DriverCategoryB<>("Иванов Иван Иванович", true, 3);
        System.out.println(ivanIvanov);
        ivanIvanov.driveCar(secondCar);
        ivanIvanov.refuel();

       DriverCategoryC<Truck> larisaPestrisova = new DriverCategoryC<>("Пестрицова Лариса Ивановна", true, -1);
        System.out.println(larisaPestrisova);
        larisaPestrisova.driveTruck(firstTruck);
        larisaPestrisova.startMoving();

/*         DriverCategoryD<Bus> kovalVladislav = new DriverCategoryD<>("Коваль Владислав Какой-то-Там", true, 2);
        System.out.println(kovalVladislav);
        kovalVladislav.driveBus(firstBus);
        kovalVladislav.stopMoving();*/
    }

    // проверка методов из родительского класса
    public static void checkClassMethods(Transport... transports) {
        for (Transport transport : transports) {
            System.out.println(transport);
            transport.startMoving();
            transport.finishMoving();
        }
    }

    public static void printSpecialSymbol() {
        System.out.println("--------------- + + + ---------------");
    }

}
