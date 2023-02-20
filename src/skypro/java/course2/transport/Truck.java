package skypro.java.course2.transport;

import skypro.java.course2.transport.enums.LoadType;

public class Truck extends Transport implements Competing { // наследует класс Transport и расширяет интерфейс Competing

    private final LoadType loadType;       // переменная для типа грузоподъемности (из enum LoadType)

    public Truck (String brand, String model, double engineVolume, LoadType loadType) {
        super(brand, model, engineVolume);
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
    public String toString() {
        return "Грузовик. " + super.toString() + " " + getLoadType();
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
