package skypro.java.course2.transport;

public class Car extends Transport {

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

}
