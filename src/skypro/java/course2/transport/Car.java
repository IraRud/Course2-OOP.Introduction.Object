package skypro.java.course2.transport;

public class Car extends Transport implements Competing{ // наследует класс Car и расширяет интерфейс Competing

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

    }

    @Override
    public void bestLapTime() {

    }

    @Override
    public double maxSpeed() {
        return 0;
    }
    //endregion
}
