package skypro.java.course2.transport;

public class Truck extends Transport implements Competing { // наследует класс Transport и расширяет интерфейс Competing

    public Truck (String brand, String model, double engineVolume) {
        super(brand, model, engineVolume);
    }

    // переопределение проверки объема двигателя
    @Override
    protected double validateEngineVolume(double engineVolume) {
        return engineVolume <= 2.5 || engineVolume >= 16.5 ? 7.5 : engineVolume;
    }

    @Override
    public String toString() {
        return "Грузовик. " + super.toString();
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
