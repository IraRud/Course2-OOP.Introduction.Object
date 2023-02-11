package skypro.java.course2.transport;

public class Truck extends Transport {

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
}
