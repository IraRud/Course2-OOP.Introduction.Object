package skypro.java.course2.transport;

import skypro.java.course2.transport.drivers.DriverCategoryC;
import skypro.java.course2.transport.enums.LoadType;
import skypro.java.course2.transport.enums.Type;

import java.util.List;
import java.util.Objects;

public class Truck extends Transport<DriverCategoryC> implements Competing { // наследует класс Transport и расширяет интерфейс Competing

    private final LoadType loadType;       // переменная для типа грузоподъемности (из enum LoadType)

    public Truck (String brand, String model, double engineVolume, LoadType loadType, DriverCategoryC driver, List<Mechanic> mechanicList) {
        super(brand, model, engineVolume, driver, mechanicList);
        this.loadType = loadType;
    }

    // переопределение проверки объема двигателя
    @Override
    protected double validateEngineVolume(double engineVolume) {
        return engineVolume <= 2.5 || engineVolume >= 16.5 ? 7.5 : engineVolume;
    }

    public LoadType getLoadType() {
        return loadType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Truck truck = (Truck) o;
        return loadType == truck.loadType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(loadType);
    }

    //region переопределение методов родительского класса
    @Override
    protected Type getType() {   // переопределение метода, возвразщает тип TRUCK (т.к. Truck всегда грузовик)
        return Type.TRUCK;
    }

    @Override
    protected void printType() {   // переопределение метода, возвразщает информацию о типе грузоподъемности
        if (loadType == null) {
            System.out.println("Данных по транспортному средству недостаточно!");
        } else {
            System.out.println(getType() + ". " + getLoadType());
        }
    }

    // переопределение метода «Пройти диагностику», для грузовика достаточно прсто сообщения
    @Override
    public void passDiagnostics() {
        System.out.println(getType() + " " + getBrand() + " " + getModel() + " может проходить диагностику.");
    }
    //endregion

    @Override
    public String toString() {
        return getType() + ". " + super.toString() + " " + getLoadType();
    }

    //region переопределение методов интерфейса
    @Override
    public void pitStop() {
        System.out.println("Грузовику " + getBrand() + " " + getModel() + " срочно нужен пит-стоп!");
    }

    @Override
    public void bestLapTime(int seconds) {
        System.out.println("Лучшее время прохождения грузовика " + getBrand() + " " + getModel() + " - "
                + seconds / 60 + " м, " + seconds % 60 +" с");
    }

    @Override
    public void maxSpeed(double speed) {
        System.out.println("Лучшая скорость грузовика " + getBrand() + " " + getModel() + " - " + speed + " км/ч");
    }
    //endregion

}
