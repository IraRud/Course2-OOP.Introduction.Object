package skypro.java.course2.transport;

import skypro.java.course2.transport.drivers.DriverCategoryB;
import skypro.java.course2.transport.enums.BodyType;
import skypro.java.course2.transport.enums.Type;

import java.util.List;
import java.util.Objects;

public class Car extends Transport<DriverCategoryB>  implements Competing{ // наследует класс Transport и расширяет интерфейс Competing

    private final Type type = Type.CAR;
    private final BodyType bodyType;       // переменная для типа кузова (из enum BodyType)

    public Car (String brand, String model, double engineVolume, BodyType bodyType, DriverCategoryB driver, List<Mechanic> mechanicList) {
        super(brand, model, engineVolume, driver, mechanicList);
        this.bodyType = bodyType;
    }

    // переопределение проверки объема двигателя
    @Override
    protected double validateEngineVolume(double engineVolume) {
        return engineVolume <= 0 || engineVolume >= 1.5 ? 0.5 : engineVolume;
    }

    public BodyType getBodyType() {
        return bodyType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return type == car.type && bodyType == car.bodyType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, bodyType);
    }

    //region переопределение методов родительского класса
    @Override
    protected Type getType() {  // переопределение метода, возвразщает тип CAR (т.к. Car всегда легковушка)
        return Type.CAR;
    }

    @Override
    protected void printType() {   // переопределение метода, возвразщает информацию о типе кузова
        if (bodyType == null) {
            System.out.println("Данных по транспортному средству недостаточно!");
        } else {
            System.out.println(getType() + ". " + getBodyType());
        }
    }

    // переопределение метода «Пройти диагностику», для легковушки достаточно прсто сообщения
    @Override
    public void passDiagnostics() {
        System.out.println(getType() + " " + getBrand() + " " + getModel() + " может проходить диагностику.");
    }
    //endregion

    @Override
    public String toString() {
        return getType() + ". " + super.toString() + " " + getBodyType();
    }

    //region переопределение методов интерфейса
    @Override
    public void pitStop() {
        System.out.println("Легковушке " + getBrand() + " " + getModel() + " срочно нужен пит-стоп!");
    }

    @Override
    public void bestLapTime(int seconds) {
        System.out.println("Лучшее время прохождения легковушки " + getBrand() + " " + getModel() + " - "
                + seconds / 60 + " м, " + seconds % 60 +" с");
    }

    @Override
    public void maxSpeed(double speed) {
        System.out.println("Лучшая скорость легковушки " + getBrand() + " " + getModel() + " - " + speed + " км/ч");
    }
    //endregion
}
