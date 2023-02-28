package skypro.java.course2.transport;

import skypro.java.course2.transport.drivers.DriverCategoryB;
import skypro.java.course2.transport.drivers.DriverCategoryC;
import skypro.java.course2.transport.drivers.DriverCategoryD;
import skypro.java.course2.transport.enums.BodyType;
import skypro.java.course2.transport.enums.Capacity;
import skypro.java.course2.transport.enums.LoadType;

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
        System.out.println(secondCar);
        secondCar.bestLapTime(30);
        System.out.println(secondCar.getType());
        secondCar.printType();

        Truck firstTruck = new Truck("Газель", "Model 800", 7, LoadType.N1);
        System.out.println(firstTruck);
        System.out.println(firstTruck.getType());
        firstTruck.printType();
/*        firstTruck.bestLapTime(250);
        firstTruck.maxSpeed(100);*/

        Bus firstBus = new Bus("АвтоМир", "Мосгортрнас", 0, Capacity.SMALL);
        System.out.println(firstBus);
        System.out.println(firstBus.getType());
        firstBus.printType();
/*        firstBus.maxSpeed(70);
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

         DriverCategoryD<Bus> kovalVladislav = new DriverCategoryD<>("Коваль Владислав Какой-то-Там", true, 2);
        System.out.println(kovalVladislav);
        kovalVladislav.driveBus(firstBus);
        kovalVladislav.stopMoving();
    }

/*    // проверка методов из родительского класса
    public static void checkClassMethods(Transport... transports) {
        for (Transport transport : transports) {
            System.out.println(transport);
            transport.startMoving();
            transport.finishMoving();
        }
    }*/

    public static void printSpecialSymbol() {
        System.out.println("--------------- + + + ---------------");
    }

}
