package skypro.java.course2.transport.drivers;

import skypro.java.course2.transport.Truck;

public class DriverCategoryC<C extends Truck> extends Driver {

    public DriverCategoryC(String fullName, boolean driversLicense, int experience) {
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
        System.out.println(getFullName() + " решает заправить грузовик.");
    }
    //endregion

    public void driveTruck(C truck) {
        System.out.println(getFullName() + " управляет грузовиком " + truck.getBrand() + " " + truck.getModel() +
                " и будет участвовать в заезде.");
    }

    @Override
    public String toString() {
        return "Водитель категории С (грузовик). " + super.toString();
    }
}
