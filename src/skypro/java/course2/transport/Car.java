package skypro.java.course2.transport;

public class Car extends Transport implements Competing{ // наследует класс Transport и расширяет интерфейс Competing

    public Car (String brand, String model, double engineVolume) {
        super(brand, model, engineVolume);
    }

    // переопределение проверки объема двигателя
    @Override
    protected double validateEngineVolume(double engineVolume) {
        return engineVolume <= 0 || engineVolume >= 1.5 ? 0.5 : engineVolume;
    }

    @Override
    public String toString() {
        return "Легковушка. " + super.toString();
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
