package skypro.java.course2.transport;

import skypro.java.course2.transport.enums.LoadType;
import skypro.java.course2.transport.enums.Type;

import java.util.List;

public class Truck extends Transport implements Competing { // наследует класс Transport и расширяет интерфейс Competing

    private final LoadType loadType;       // переменная для типа грузоподъемности (из enum LoadType)

    public Truck (String brand, String model, double engineVolume, LoadType loadType, List<Mechanic> mechanicList) {
        super(brand, model, engineVolume, mechanicList);
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
    protected void passDiagnostics() {
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
