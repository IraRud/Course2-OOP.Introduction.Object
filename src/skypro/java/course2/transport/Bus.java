package skypro.java.course2.transport;

public class Bus extends Transport implements Competing { // наследует класс Transport и расширяет интерфейс Competing

    public Bus (String brand, String model, double engineVolume) {
        super(brand, model, engineVolume);
    }

    // переопределение проверки объема двигателя
    @Override
    protected double validateEngineVolume(double engineVolume) {
        return engineVolume <= 1.5 || engineVolume >= 3.5 ? 2.5 : engineVolume;
    }

    @Override
    public String toString() {
        return "Автобус. " + super.toString();
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
