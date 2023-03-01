package skypro.java.course2.transport;

import skypro.java.course2.transport.drivers.DriverCategoryB;
import skypro.java.course2.transport.drivers.DriverCategoryC;
import skypro.java.course2.transport.drivers.DriverCategoryD;
import skypro.java.course2.transport.enums.BodyType;
import skypro.java.course2.transport.enums.Capacity;
import skypro.java.course2.transport.enums.LoadType;

import java.util.ArrayList;
import java.util.List;

// отдельный класс для тестирования класса Transport и наследующих его
public class TestTransport {
    public static void main(String[] args) {

        //region (lesson 7) работа с коллекциями
        printSpecialSymbol();

        // список механиков для легковых машин
        Mechanic oleg = new Mechanic("Олег", "Иванов", "");
        Mechanic valentina = new Mechanic("Валентина", "Некрасова", "\"Починим все\"");
        List<Mechanic> mechanicsListForCar = new ArrayList<>();
        mechanicsListForCar.add(oleg);
        mechanicsListForCar.add(valentina);
        // вывод механиков для легковых машин для проверки
        System.out.println("Механики легковых автомобилей: ");
        printMechanic(mechanicsListForCar);

        // список механиков для грузовиков
        Mechanic nikita = new Mechanic("Никита", "Сергеев", "\"Покрышки\"");
        List<Mechanic> mechanicsListForTruck = new ArrayList<>();
        mechanicsListForTruck.add(nikita);
        mechanicsListForTruck.add(valentina);
        // вывод механиков для легковых машин для проверки
        System.out.println("Механики грузовиков: ");
        printMechanic(mechanicsListForTruck);

        // список механиков для автобусов
        List<Mechanic> mechanicsListForBus = new ArrayList<>();
        mechanicsListForBus.add(valentina);
        // вывод механиков для автобусов для проверки
        System.out.println("Механики автобусов: ");
        printMechanic(mechanicsListForBus);

        // водители
        DriverCategoryB<Car> ivanIvanov = new DriverCategoryB<>("Иванов Иван Иванович", true, 3);
        DriverCategoryC<Truck> larisaPestrisova = new DriverCategoryC<>("Пестрицова Лариса Ивановна", true, -1);
        DriverCategoryD<Bus> kovalVladislav = new DriverCategoryD<>("Коваль Владислав Какой-то-Там", true, 2);

        // список для соревнующихся машин
        Car thirdCar = new Car("Kia", "Model KK", 3, BodyType.VAN, ivanIvanov, mechanicsListForCar);
        Truck secondTruck = new Truck("Газель", "Model 1070", 10, LoadType.N2, larisaPestrisova, mechanicsListForTruck);
        Bus secondBus = new Bus("АВТОбусы", "Мосгортрнас", 0, Capacity.BIG, kovalVladislav, mechanicsListForBus);
        List<Transport> participantsOfCompetition = new ArrayList<>();
        participantsOfCompetition.add(thirdCar);
        participantsOfCompetition.add(secondTruck);
        participantsOfCompetition.add(secondBus);

        // вывод участников гонки в консоль для проверки
        System.out.println("Список участников гонки: ");
        printParticipantsOfCompetition(participantsOfCompetition);

        // вывод листа механиков для конкретного авто
        printMechanic(thirdCar);

        // вывод водителя авто
        printNameOfDriver(thirdCar);
        //endregion

/*
        printSpecialSymbol();

        Transport[] transports = new Transport[]{
                new Car("Audi", "Model YY", -1, BodyType.VAN, mechanicsListForCar),
                new Bus("Toyota Motor", "Model XX-xx", 70, Capacity.SMALL, mechanicsListForTruck),
        };
        checkClassMethods(transports);  // проверка методов из родительского класса

        printSpecialSymbol();

        //region проверка переопределенных методов интерфейса
        Transport firstCar = new Car("Seat", "", 2, BodyType.VAN, mechanicsListForCar);
        ((Car) firstCar).pitStop();

        Car secondCar = new Car("Honda", "Model UU", 1, BodyType.SEDAN, mechanicsListForCar);
        System.out.println(secondCar);
        secondCar.bestLapTime(30);
        System.out.println(secondCar.getType());
        secondCar.printType();

        Truck firstTruck = new Truck("Газель", "Model 800", 7, LoadType.N1, mechanicsListForTruck);
        System.out.println(firstTruck);
        System.out.println(firstTruck.getType());
        firstTruck.printType();
        firstTruck.bestLapTime(250);
        firstTruck.maxSpeed(100);

        Bus firstBus = new Bus("АвтоМир", "Мосгортрнас", 0, Capacity.SMALL, mechanicsListForBus);
        System.out.println(firstBus);
        System.out.println(firstBus.getType());
        firstBus.printType();
        firstBus.maxSpeed(70);
        firstBus.pitStop();
        //endregion
*/

        printSpecialSymbol();

/*
        //region проверка дженериков (водители созданы выше для баланса вселенной)
        System.out.println(ivanIvanov);
        ivanIvanov.driveCar(thirdCar);
        ivanIvanov.refuel();

        System.out.println(larisaPestrisova);
        larisaPestrisova.driveTruck(secondTruck);
        larisaPestrisova.startMoving();

        System.out.println(kovalVladislav);
        kovalVladislav.driveBus(secondBus);
        kovalVladislav.stopMoving();
        //endregion
*/

/*       printSpecialSymbol();
        // метод passDiagnostics необходимо вызывать через статический метод checkPassDiagnostics()
        checkPassDiagnostics(firstBus);
        checkPassDiagnostics(secondCar);
        checkPassDiagnostics(firstTruck);
*/
    }

/*    // проверка методов из родительского класса
    public static void checkClassMethods(Transport... transports) {
        for (Transport transport : transports) {
            System.out.println(transport);
            transport.startMoving();
            transport.finishMoving();
        }
    }

    // метод для проверки метода <>.passDiagnostics()
    public static void checkPassDiagnostics(Transport transport) {
        try {
            transport.passDiagnostics();
        } catch (TransportTypeException e) {
            // вывод сообщения об ошибке (с подсветкой)
            System.err.println(e.getMessage() + " Автобус " + transport.getBrand() + " " + transport.getModel()
                    + " не может проходить диагностику!");
        }
    }*/

    // метод для вывода участников гонки в консоль
    public static void printParticipantsOfCompetition(List<Transport> participantsOfCompetition) {
        for (Transport transport : participantsOfCompetition) {
            System.out.println(transport);
        }
    }

    // метод для вывода листа механиков по группам (легковушка, грузовик, автобус)
    public static void printMechanic(List<Mechanic> mechanicList) {
        for (Mechanic mechanic : mechanicList) {
            System.out.println(mechanic);
        }
    }

    // метод для вывода листа механиков для конкретного авто
    public static void printMechanic(Transport transport) {
        System.out.println(transport.getType() + " " + transport.getBrand() + " " + transport.getModel()
                + " обслуживается механиками: " + transport.getMechanicList());
    }

    public static void printNameOfDriver(Transport transport) {
        System.out.println("Водителем " + transport.getBrand() + " " + transport.getModel()
                + " является " + transport.getDriver().getFullName() + ".");
    }

    public static void printSpecialSymbol() {
        System.out.println("--------------- + + + ---------------");
    }

}
