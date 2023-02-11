package skypro.java.course2.transport;

import static skypro.java.course2.transport.ValidateUtils.validateString;

public abstract class Transport {
    final private String brand;   // марка
    private String model;   // модель, можно изменять
    final private double engineVolume;    // объем двигателя в литрах

    public Transport(String brand, String model, double engineVolume) {
        this.brand = validateStringValue(brand);
        this.model = validateStringValue(model);
        this.engineVolume = validateEngineVolume(engineVolume);
    }

    // region VALIDATION
    // для разного типа авто - разный объем двигателя. отсюда разная проверка для наследников
    protected abstract double validateEngineVolume(double engineVolume);

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

    public void setModel(String model) {
        this.model = validateStringValue(model);
    }

    @Override
    public String toString() {
        return "Бренд: "+ brand + ", модель: " + model + ", объем двигателя: " + engineVolume + " л.";
    }
}