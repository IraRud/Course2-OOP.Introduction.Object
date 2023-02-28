package skypro.java.course2.transport;

import skypro.java.course2.transport.enums.Capacity;
import skypro.java.course2.transport.enums.Type;

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

    //region переопределение методов родительского класса
    @Override
    protected Type getType() {   // переопределение метода, возвразщает тип BUS (т.к. Bus всегда грузовик)
        return Type.BUS;
    }

    @Override
    protected void printType() {   // переопределение метода, возвразщает информацию о типе вместимости
        if (capacity == null) {
            System.out.println("Данных по транспортному средству недостаточно!");
        } else {
            System.out.println(getType() + ". " + getCapacity());
        }
    }

    // переопределение метода «Пройти диагностику», для автобуса необходимо выкинуть исключение
    @Override
    protected void passDiagnostics() throws TransportTypeException {
        throw new TransportTypeException("Автобусы диагностику проходить не должны!");
    }
    //endregion

    @Override
    public String toString() {
        return getType() + ". " + super.toString() + " " + getCapacity();
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
