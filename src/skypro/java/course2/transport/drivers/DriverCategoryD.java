package skypro.java.course2.transport.drivers;

import skypro.java.course2.transport.Bus;

public class DriverCategoryD<D extends Bus> extends Driver{

    public DriverCategoryD(String fullName, boolean driversLicense, int experience) {
        super(fullName, driversLicense, experience);
    }

    //region переопределение методов
    @Override
    public void startMoving() { // начать движение
        System.out.println(getFullName() + " начинает движение!");
    }

    @Override
    public void stopMoving() { // остановиться
        System.out.println(getFullName() + " внезапно остановился!");
    }

    @Override
    public void refuel() {  // заправить авто
        System.out.println(getFullName() + " решает заправить автобус.");
    }
    //endregion

    public void driveBus(D bus) {
        System.out.println(getFullName() + " управляет грузовиком " + bus.getBrand() + " " + bus.getModel() +
                " и будет участвовать в заезде.");
    }

    @Override
    public String toString() {
        return "Водитель категории D (автобус). " + super.toString();
    }
}


