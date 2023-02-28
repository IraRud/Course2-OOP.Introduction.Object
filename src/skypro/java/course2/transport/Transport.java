package skypro.java.course2.transport;

import static skypro.java.course2.transport.ValidateUtils.validateString;

import skypro.java.course2.transport.enums.Type;

public abstract class Transport {
    final private String brand;   // марка
    private String model;   // модель, можно изменять
    private final double engineVolume;    // объем двигателя в литрах

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

    //region методы, к-ые имеет каждое авто
    protected void startMoving() {
        System.out.println(getBrand() + " " + getModel() + " начианет движение.");
    }

    protected void finishMoving() {
        System.out.println(getBrand() + " " + getModel() + " заканчивает движение.");
    }
    //endregion

    // необходимо переопределить в наследниках, возвращает тип транспортного средства (легковая машина, грузовик, автобус)
    protected abstract Type getType();

    // необходимо переопределить в наследниках, выводит в консоль значение типа транспортного средства
    // (в случае легковых это будет информация о типе кузова, у автобуса - вместимость и т.д. )
    protected abstract void printType();

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