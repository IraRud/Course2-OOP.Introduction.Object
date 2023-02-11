package skypro.java.course2.transport;
import static skypro.java.course2.transport.ValidateUtils.validateString;

public abstract class Transport {
    final private String brand;   // марка
    final private String model;   // модель
    final private double engineVolume;    // объем двигателя в литрах

    public Transport(String brand, String model, double engineVolume) {
        this.brand = validateStringValue(brand);
        this.model = validateStringValue(model);
        this.engineVolume = validateEngineVolume(engineVolume);
    }
    // region VALIDATION
    private double validateEngineVolume(double engineVolume) {
        return engineVolume <= 0 ? 1.5 : engineVolume;
    }
    private String validateStringValue(String value) {
        return validateString(value, "default");
    }
    // endregion

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public double getEngineVolume() {
        return engineVolume;
    }

    @Override
    public String toString() {
        return "Бренд: "+ brand + ", модель: " + model + ", объем двигателя: " + engineVolume + "л.";
    }
}