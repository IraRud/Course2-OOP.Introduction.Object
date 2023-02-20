package skypro.java.course2.transport;

import skypro.java.course2.transport.enums.Capacity;

public class Bus extends Transport implements Competing { // наследует класс Transport и расширяет интерфейс Competing

    private final Capacity capacity;       // переменная для типа вместимости (из enum Capacity)

    public Bus (String brand, String model, double engineVolume, Capacity capacity) {
        super(brand, model, engineVolume);
        this.capacity = capacity;
    }

    // переопределение проверки объема двигателя
    @Override
    protected double validateEngineVolume(double engineVolume) {
        return engineVolume <= 1.5 || engineVolume >= 3.5 ? 2.5 : engineVolume;
    }

    public Capacity getCapacity() {
        return capacity;
    }

    @Override
    public String toString() {
        return "Автобус. " + super.toString() + " " + getCapacity();
    }

    //region переопределение методов интерфейса
    @Override
    public void pitStop() {
        System.out.println("Автобусу " + getBrand() + " " + getModel() + " срочно нужен пит-стоп!");
    }

    @Override
    public void bestLapTime(int seconds) {
        System.out.println("Лучшее время прохождения автобуса " + getBrand() + " " + getModel() + " - "
                + seconds / 60 + " м, " + seconds % 60 +" с");
    }

    @Override
    public void maxSpeed(double speed) {
        System.out.println("Лучшая скорость автобуса " + getBrand() + " " + getModel() + " - " + speed + " км/ч");
    }
    //endregion
}
