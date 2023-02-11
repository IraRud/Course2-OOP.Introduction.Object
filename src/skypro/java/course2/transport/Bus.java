package skypro.java.course2.transport;

public class Bus extends Transport {

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
}
