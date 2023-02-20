package skypro.java.course2.transport.drivers;

import skypro.java.course2.transport.Car;

public class DriverCategoryB <B extends Car> extends Driver   {

    public DriverCategoryB(String fullName, boolean driversLicense, int experience) {
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
        System.out.println(getFullName() + " решает заправить авто.");
    }
    //endregion

    public void driveCar(B car) {
        System.out.println(getFullName() + " управляет автомобилем " + car.getBrand() + " " + car.getModel() +
                " и будет участвовать в заезде.");
    }

    @Override
    public String toString() {
        return "Водитель категории В (легковушка). " + super.toString();
    }
}
