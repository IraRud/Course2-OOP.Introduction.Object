package skypro.java.course2.transport;

import skypro.java.course2.transport.drivers.DriverCategoryB;
import skypro.java.course2.transport.drivers.DriverCategoryC;
import skypro.java.course2.transport.drivers.DriverCategoryD;
import skypro.java.course2.transport.enums.BodyType;
import skypro.java.course2.transport.enums.Capacity;
import skypro.java.course2.transport.enums.LoadType;
import skypro.java.course2.transport.smth.ServiceStation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        // данный список не должен быть пустым
        checkList(mechanicsListForCar);
        // вывод механиков для легковых машин для проверки
        System.out.println("Механики легковых автомобилей: ");
        printMechanic(mechanicsListForCar);

        // список механиков для грузовиков
        printToNewParagraph();
        Mechanic nikita = new Mechanic("Никита", "Сергеев", "\"Покрышки\"");
        List<Mechanic> mechanicsListForTruck = new ArrayList<>();
        mechanicsListForTruck.add(nikita);
        mechanicsListForTruck.add(valentina);
        // данный список не должен быть пустым
        checkList(mechanicsListForTruck);
        // вывод механиков для легковых машин для проверки
        System.out.println("Механики грузовиков: ");
        printMechanic(mechanicsListForTruck);

        // список механиков для автобусов
        printToNewParagraph();
        Mechanic alex = new Mechanic("Александр", "Прямой", "\"Ремонт\"");
        List<Mechanic> mechanicsListForBus = new ArrayList<>();
        mechanicsListForBus.add(valentina);
        mechanicsListForBus.add(alex);
        // данный список не должен быть пустым
        checkList(mechanicsListForBus);
        // вывод механиков для автобусов для проверки
        System.out.println("Механики автобусов: ");
        printMechanic(mechanicsListForBus);

        // водители
        DriverCategoryB<Car> ivanIvanov = new DriverCategoryB<>("Иванов Иван Иванович", true, 3);
        DriverCategoryB<Car> dmitriyKenchin = new DriverCategoryB<>("Кечин Дмитрий Алексеевич", true, 5);
        DriverCategoryC<Truck> larisaPestrisova = new DriverCategoryC<>("Пестрицова Лариса Ивановна", true, -1);
        DriverCategoryC<Truck> olgaNechaeva = new DriverCategoryC<>("Нечаева Ольга Михайловна", true, -1);
        DriverCategoryD<Bus> kovalVladislav = new DriverCategoryD<>("Коваль Владислав Какой-то-Там", true, 2);

        // список для соревнующихся машин
        printToNewParagraph();
        Car thirdCar = new Car("Kia", "Model KK", 3, BodyType.VAN, ivanIvanov, mechanicsListForCar);
        Car fourthCar = new Car("Seat", "Model SS", 3, BodyType.COUPE, dmitriyKenchin, mechanicsListForCar);
        Truck secondTruck = new Truck("Газель", "Model 1070", 10, LoadType.N2, larisaPestrisova, mechanicsListForTruck);
        Truck thirdTruck = new Truck("КамАЗ", "Model 999", 10, LoadType.N1, olgaNechaeva, mechanicsListForTruck);
        Bus secondBus = new Bus("Volgabus", "Мосгортрнас", 0, Capacity.BIG, kovalVladislav, mechanicsListForBus);
        List<Transport> participantsOfCompetition = new ArrayList<>();
        participantsOfCompetition.add(thirdCar);
        participantsOfCompetition.add(fourthCar);
        participantsOfCompetition.add(secondTruck);
        participantsOfCompetition.add(thirdTruck);
        participantsOfCompetition.add(secondBus);
        // данный список не должен быть пустым
        checkList(participantsOfCompetition);
        // вывод участников гонки в консоль для проверки
        System.out.println("Список участников гонки: ");
        printParticipantsOfCompetition(participantsOfCompetition);

        // вывод листа механиков для конкретного авто
        printToNewParagraph();
        printMechanic(thirdCar);

        // вывод водителя авто
        printToNewParagraph();
        printNameOfDriver(thirdCar);
        //endregion

        // добавление в очередь на техобслуживание
        // очередь может быть пустой
        printToNewParagraph();
        ServiceStation maintenanceQueue = new ServiceStation();
        maintenanceQueue.addToMaintenanceQueue(secondTruck);
        maintenanceQueue.carryOutMaintenanceOfCar();
        maintenanceQueue.carryOutMaintenanceOfCar();
        printToNewParagraph();
        maintenanceQueue.addToMaintenanceQueue(secondTruck);
/*        // для проверки на исключение
        maintenanceQueue.addToMaintenanceQueue(secondBus);
        maintenanceQueue.carryOutMaintenanceOfCar();*/

        printSpecialSymbol();

        List<Mechanic> newMechanicsList = new ArrayList<>();
        newMechanicsList.add(new Mechanic("Новый", "Механик", "\"Проверка\""));

        // создадим HashMap, которая в качестве ключа будет принимать автомобиль, а в качестве значения — список механиков,
        // который его обслуживает
        Map<Transport, List<Mechanic>> transportListHashMap = new HashMap<>();
        // используем два одинаковых объекта: thirdCar и новый объект с идентичными полями (!!добавить в классы hashCode() и equals()!!)
        transportListHashMap.put(thirdCar, mechanicsListForCar);
        transportListHashMap.put(new Car("Kia", "Model KK", 3, BodyType.VAN, ivanIvanov, mechanicsListForCar), newMechanicsList);
        // в консоль должна быть выведена только последняя запись при условии наличия одного и того же ключа
        printHashMap(transportListHashMap);

        printToNewParagraph();
        // по аналогии сделаем проверку для автобусов и грузовиков и добавим в предыдущий список
        transportListHashMap.put(secondBus, mechanicsListForBus);
        transportListHashMap.put(new Bus("Volgabus", "Мосгортрнас", 0, Capacity.BIG, kovalVladislav, mechanicsListForBus), newMechanicsList);
        transportListHashMap.put(secondTruck, mechanicsListForTruck);
        transportListHashMap.put(new Truck("Газель", "Model 1070", 10, LoadType.N2, larisaPestrisova, mechanicsListForTruck), newMechanicsList);
        transportListHashMap.put(thirdTruck, mechanicsListForTruck);
        printHashMap(transportListHashMap);

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

        printSpecialSymbol();

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
            // выход из системы
            System.exit(0);
        }
    }*/

    // метод для проверки списков, пустые не могут быть параметрами
    public static void checkList(List list) {
        if (list.isEmpty()) {
            throw new IllegalArgumentException("Пустой лист");
        }
    }

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

    // метод для вывода пары: транспорт <-> список механиков
    public static void printHashMap(Map<Transport, List<Mechanic>> transportListHashMap) {
        System.out.println("HashMap \"транспорт - механики\": ");
        for (Map.Entry<Transport, List<Mechanic>> transport : transportListHashMap.entrySet()) {
            System.out.println(transport.getKey() + " <-> " + transport.getValue());
        }
    }

    public static void printSpecialSymbol() {
        System.out.println("--------------- + + + ---------------");
    }

    public static void printToNewParagraph() {
        System.out.println();
    }

}
